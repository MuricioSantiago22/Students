package com.mauricioJimenez.students.presentation.ui.home.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mauricioJimenez.students.databinding.ItemStudentBinding
import com.mauricioJimenez.students.domain.entities.Student

class StudentViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemStudentBinding.bind(view)
    fun render(student: Student){
        binding.nameTV.text = "Name:${student.name}"
        binding.ageTV.text = "Age:${student.age}"
    }
}