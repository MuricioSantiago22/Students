package com.mauricioJimenez.students.domain.useCase

import com.mauricioJimenez.students.domain.repository.StudentRepository
import javax.inject.Inject

class DeleteStudentUseCase @Inject constructor(
    private val studentRepository: StudentRepository
) {

    suspend operator fun invoke(id:Int){
        studentRepository.deleteStudent(id)
    }
}