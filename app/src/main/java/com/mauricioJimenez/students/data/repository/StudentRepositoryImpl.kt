package com.mauricioJimenez.students.data.repository

import com.mauricioJimenez.students.data.local.dao.StudentDao
import com.mauricioJimenez.students.data.local.entities.StudentEntity
import com.mauricioJimenez.students.data.local.mapper.toDomain
import com.mauricioJimenez.students.domain.entities.Student
import com.mauricioJimenez.students.domain.repository.StudentRepository
import javax.inject.Inject

class StudentRepositoryImpl @Inject constructor(
    private  val studentDao: StudentDao
): StudentRepository {
    override suspend fun getStudentDataFromDB(): List<Student> {
        val response : List<StudentEntity> = studentDao.getAllStudents()
        return  response.map { it.toDomain()}
    }
}