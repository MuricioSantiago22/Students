package com.mauricioJimenez.students.domain.useCase

import com.mauricioJimenez.students.domain.entities.Student
import com.mauricioJimenez.students.domain.mapper.toEntity
import com.mauricioJimenez.students.domain.repository.StudentRepository
import javax.inject.Inject

class InsertStudentDataUseCase @Inject constructor(
    private val studentRepository: StudentRepository
) {
    suspend operator fun invoke(name: String, age: String){
        val studentEntity = Student(id= 0, name = name, age = age).toEntity()
         studentRepository.insertAuditData(studentEntity)
    }
}