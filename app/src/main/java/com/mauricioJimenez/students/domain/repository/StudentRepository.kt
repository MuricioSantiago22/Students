package com.mauricioJimenez.students.domain.repository

import com.mauricioJimenez.students.data.local.entities.StudentEntity
import com.mauricioJimenez.students.domain.entities.Student

interface StudentRepository {

    suspend fun getStudentDataFromDB():List<Student>
    suspend fun  insertStudentData(student: StudentEntity)
    suspend fun  deleteStudent(id:Int)
    suspend fun updateStudentById(studentId: Int, name: String, age: String)
}