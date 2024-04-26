package com.mauricioJimenez.students.presentation.ui.update

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import com.mauricioJimenez.students.R
import com.mauricioJimenez.students.databinding.ActivityUpdateBinding
import com.mauricioJimenez.students.presentation.ui.home.HomeActivity
import com.mauricioJimenez.students.presentation.viewModel.StudentViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UpdateActivity : AppCompatActivity() {
    private val studentViewModel: StudentViewModel by viewModels()

    private lateinit var binding: ActivityUpdateBinding
    private var name = ""
    private var age = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupFormValidation()

    }


    private fun setupFormValidation() {
        val id = intent.getIntExtra("STUDENT_ID", 0)
        name = intent.getStringExtra("STUDENT_NAME") ?:""
        age = intent.getStringExtra("STUDENT_AGE") ?: ""
        binding.nameEdit.setText(name)
        binding.ageEdit.setText(age)
        binding.nameEdit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                 name = s.toString()
                if (name.isEmpty()) {
                    binding.nameInput.error = getString(R.string.name_must_not_be_empty)
                } else if (!name.matches(Regex("^[a-zA-Z ]+\$"))) {
                    binding.nameInput.error = getString(R.string.name_only_letters)
                } else {
                    binding.nameInput.error = null
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        binding.ageEdit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                 age = s.toString()
                if (age.isEmpty()) {
                    binding.ageInput.error = getString(R.string.age_must_not_be_empty)
                } else if (!age.matches(Regex("^[0-9]+\$"))) {
                    binding.ageInput.error = getString(R.string.age_only_numbers)
                } else {
                    binding.ageInput.error = null // Clear error
                }

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        register(id)
    }

    private fun register(id:Int){
        binding.updateButton.setOnClickListener {
            studentViewModel.updateStudent(id,name,age)
            navigate()
            finish()
        }
    }


    private fun navigate(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}