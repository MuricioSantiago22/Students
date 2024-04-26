package com.mauricioJimenez.students.domain.mapper

import com.mauricioJimenez.students.data.local.entities.StudentEntity
import com.mauricioJimenez.students.domain.entities.Student

fun Student.toEntity()= StudentEntity(
    id = this.id,
    name= this.name,
    age = this.age
)