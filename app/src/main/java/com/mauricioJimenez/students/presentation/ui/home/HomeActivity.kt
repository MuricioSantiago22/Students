package com.mauricioJimenez.students.presentation.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mauricioJimenez.students.databinding.ActivityHomeBinding
import com.mauricioJimenez.students.presentation.ui.register.RegisterStudentActivity
import com.mauricioJimenez.students.presentation.ui.home.adapter.StudentAdapter
import com.mauricioJimenez.students.presentation.viewModel.StudentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityHomeBinding
    private lateinit var adapter: StudentAdapter
    private val studentViewModel: StudentViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()
        observeViewModel()
        studentViewModel.getStudentData()
        binding.buttonF.setOnClickListener {
            val intent = Intent(this, RegisterStudentActivity::class.java)
            startActivity(intent)
        }
    }
    private fun setUpRecyclerView() {
        val manager = LinearLayoutManager(this)
        val decoration= DividerItemDecoration(this, manager.orientation )
        binding.recyclerView.layoutManager = manager
        adapter = StudentAdapter(emptyList())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(decoration)
    }
    private fun observeViewModel() {
        studentViewModel.studentDataList.observe(this) { students ->
            students?.let {
                adapter.updateData(students)
            }
        }
    }
}