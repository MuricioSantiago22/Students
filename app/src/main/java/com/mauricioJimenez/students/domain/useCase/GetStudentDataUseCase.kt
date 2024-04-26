package com.mauricioJimenez.students.domain.useCase

import com.mauricioJimenez.students.domain.entities.Student
import com.mauricioJimenez.students.domain.repository.StudentRepository
import javax.inject.Inject

class GetStudentDataUseCase @Inject constructor(
    private val studentRepository: StudentRepository
) {

    suspend operator fun invoke():List<Student>{
        return studentRepository.getStudentDataFromDB()
    }
}