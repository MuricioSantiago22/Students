package com.mauricioJimenez.students.presentation.ui.home

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.mauricioJimenez.students.R
import com.mauricioJimenez.students.databinding.ActivityHomeBinding
import com.mauricioJimenez.students.presentation.ui.base.BaseActivity
import com.mauricioJimenez.students.presentation.ui.register.RegisterStudentActivity
import com.mauricioJimenez.students.presentation.ui.home.adapter.StudentAdapter
import com.mauricioJimenez.students.presentation.ui.home.adapter.SwipeGesture
import com.mauricioJimenez.students.presentation.ui.update.UpdateActivity
import com.mauricioJimenez.students.presentation.ui.weather.WeatherActivity
import com.mauricioJimenez.students.presentation.viewModel.StudentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity() {

    private lateinit var  binding: ActivityHomeBinding
    private lateinit var adapter: StudentAdapter
    private val studentViewModel: StudentViewModel by viewModels()
    private var weather = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()
        observeViewModel()
        studentViewModel.getStudentData()
        binding.bottomAdd.setOnClickListener {
            navigate(RegisterStudentActivity())
        }
        binding.bottomExit.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            finish()
        }


    }
    private fun setFavoriteIcon(menuItem: MenuItem) {
        val id = if (weather) R.drawable.baseline_device_thermostat_24
        else R.drawable.baseline_device_thermostat_24
        menuItem.icon = ContextCompat.getDrawable(this, id)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar_menu, menu)
        setFavoriteIcon(menu?.findItem(R.id.weather)!!)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Presiona  el botón -> para  salir")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun setUpRecyclerView() {
        val intent = Intent(this, UpdateActivity::class.java)
        val swipeGesture = object :SwipeGesture(this){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                when(direction){
                    ItemTouchHelper.RIGHT -> {
                        val position = viewHolder.adapterPosition
                        val student = adapter.getStudentAtPosition(position)
                        adapter.deleteItem(position)
                        studentViewModel.deleteStudent(student.id)
                    }
                    ItemTouchHelper.LEFT -> {
                        val position = viewHolder.adapterPosition
                        val student = adapter.getStudentAtPosition(position)
                        intent.putExtra("STUDENT_ID", student.id)
                        intent.putExtra("STUDENT_AGE", student.age)
                        intent.putExtra("STUDENT_NAME", student.name)
                        startActivity(intent)
                        finish()
                    }
                }

            }

        }

        val touchHelper= ItemTouchHelper(swipeGesture)
        touchHelper.attachToRecyclerView(binding.recyclerView)
        val manager = LinearLayoutManager(this)
        val decoration= DividerItemDecoration(this, manager.orientation )
        binding.recyclerView.layoutManager = manager
        adapter = StudentAdapter(emptyList())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(decoration)
        binding.topAppBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.weather ->{
                    navigate(WeatherActivity())
                     true
                }

                else -> {false}
            }
        }
    }

    private fun observeViewModel() {
        studentViewModel.studentDataList.observe(this) { students ->
            students?.let {
                adapter.updateData(students)
            }
        }
    }


}