package com.mauricioJimenez.students.presentation.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mauricioJimenez.students.R
import com.mauricioJimenez.students.databinding.ActivityRegisterStudentBinding

class RegisterStudentActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityRegisterStudentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}