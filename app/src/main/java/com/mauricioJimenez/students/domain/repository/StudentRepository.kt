package com.mauricioJimenez.students.domain.repository

import com.mauricioJimenez.students.domain.entities.Student

interface StudentRepository {

    suspend fun getStudentDataFromDB():List<Student>
}