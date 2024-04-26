package com.mauricioJimenez.students.domain.useCase

import com.mauricioJimenez.students.domain.repository.StudentRepository
import javax.inject.Inject

class UpdateStudentUseCase @Inject constructor(
    private val studentRepository: StudentRepository
) {
    suspend operator fun invoke(studentId: Int, name: String, age: String){
        studentRepository.updateStudentById(studentId, name, age)
    }
}