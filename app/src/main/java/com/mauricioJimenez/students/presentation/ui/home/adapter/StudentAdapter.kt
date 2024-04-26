package com.mauricioJimenez.students.presentation.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mauricioJimenez.students.R
import com.mauricioJimenez.students.domain.entities.Student

class StudentAdapter(private var students: List<Student>) : RecyclerView.Adapter<StudentViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val currentStudent = students[position]
        holder.render(currentStudent)
    }

    override fun getItemCount() = students.size

    fun updateData(newStudents: List<Student>) {
        students = newStudents
        notifyDataSetChanged()
    }
}