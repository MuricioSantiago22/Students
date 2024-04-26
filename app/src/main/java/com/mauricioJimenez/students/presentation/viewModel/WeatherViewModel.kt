package com.mauricioJimenez.students.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mauricioJimenez.students.domain.entities.Weather
import com.mauricioJimenez.students.domain.useCase.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val coroutineContext: CoroutineContext
):ViewModel() {

    private val _weatherData : MutableLiveData<Weather> = MutableLiveData()
    val weatherData: LiveData<Weather> get() = _weatherData

    fun getWeather(lat: Double, lon:Double){
        viewModelScope.launch(coroutineContext){
            val response =getWeatherUseCase(lat, lon)
            withContext(Dispatchers.Main){
                if (response!=null){
                    _weatherData.value = response
                }
            }
        }
    }
}