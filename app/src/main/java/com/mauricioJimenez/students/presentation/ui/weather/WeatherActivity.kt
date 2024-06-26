package com.mauricioJimenez.students.presentation.ui.weather

import android.Manifest
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.mauricioJimenez.students.R
import com.mauricioJimenez.students.utils.Strings
import com.mauricioJimenez.students.databinding.ActivityWeatherBinding
import com.mauricioJimenez.students.presentation.ui.base.BaseActivity
import com.mauricioJimenez.students.presentation.ui.home.HomeActivity
import com.mauricioJimenez.students.presentation.viewModel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class WeatherActivity : BaseActivity() {
    private val weatherViewModel: WeatherViewModel by viewModels()

    private lateinit var binding: ActivityWeatherBinding
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
        )
            != PackageManager.PERMISSION_GRANTED
            ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                Strings.LOCATION_PERMISSION_REQUEST_CODE
            )
        } else {
            fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
            getLocation()
        }
        observeViewModel()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            Strings.LOCATION_PERMISSION_REQUEST_CODE -> {
                if (
                    grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
                    getLocation()
                } else {
                    return
                }
            }
        }
    }

    override fun onBackPressed() {
        navigate(HomeActivity())
    }

    private fun getLocation() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {

            fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    val geocoder = Geocoder(this, Locale.getDefault())
                    location?.let {
                        val lat = location.latitude
                        val lon = location.longitude
                        weatherViewModel.getWeather(lat, lon)
                        val directions: List<Address> = geocoder.getFromLocation(
                            lat,
                            lon,
                            1)!!
                        if (directions.isNotEmpty()) {
                            val city = directions[0].locality
                            val currentDate = Date()
                            val dateFormat = SimpleDateFormat(
                                "dd/MM/yyyy", Locale.getDefault()
                            )
                            val formattedDate = dateFormat.format(currentDate)
                            binding.address.text = city
                            binding.updatedAt.text = formattedDate
                            binding.update.setOnClickListener {
                                binding.loader.visibility = View.VISIBLE
                                binding.temp.visibility = View.GONE
                                weatherViewModel.getWeather(lat, lon)
                            }
                        }

                    } ?: run {
                        Toast
                            .makeText(
                                this,
                                getString(R.string.string_toast),
                                Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    private fun observeViewModel() {
        binding.loader.visibility = View.VISIBLE
        weatherViewModel.weatherData.observe(this) { weather ->
            weather?.let {
                binding.loader.visibility = View.GONE
                binding.temp.visibility = View.VISIBLE
                binding.temp.text = "${weather.hourly.temperature.firstOrNull().toString()}°C"
            }
        }
    }

}