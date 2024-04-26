package com.mauricioJimenez.students.presentation.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.mauricioJimenez.students.R
import com.mauricioJimenez.students.databinding.ActivityRegisterStudentBinding
import com.mauricioJimenez.students.presentation.ui.home.HomeActivity
import com.mauricioJimenez.students.presentation.viewModel.StudentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterStudentActivity : AppCompatActivity() {
    private val studentViewModel: StudentViewModel by viewModels()

    private lateinit var  binding: ActivityRegisterStudentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.registerButton.setOnClickListener {
            validateFields()
        }
    }

    private fun validateFields(){
        binding.nameInput.error = ""
        binding.ageInput.error = ""


        val name = binding.nameEdit.text.toString()
        if (name.isEmpty()){
            binding.nameInput.error = getString(R.string.name_must_not_be_empty)
            return
        } else if (!name.matches(Regex("^[a-zA-Z ]+\$"))) {
            binding.nameInput.error = getString(R.string.name_only_letters)
            return
        }

        val age = binding.ageEdit.text.toString()
        if (age.isEmpty()){
            binding.ageInput.error = getString(R.string.age_must_not_be_empty)
            return
        } else if (!age.matches(Regex("^[0-9]+\$"))) {
            binding.ageInput.error = getString(R.string.age_only_numbers)
            return
        }

        studentViewModel.insertStudentData(name, age)
        navigate()
    }
    private fun navigate(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}