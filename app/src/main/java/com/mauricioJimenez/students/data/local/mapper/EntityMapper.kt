package com.mauricioJimenez.students.data.local.mapper

import com.mauricioJimenez.students.data.local.entities.StudentEntity
import com.mauricioJimenez.students.domain.entities.Student

fun StudentEntity.toDomain()= Student(
    id = this.id,
    name = this.name,
    age = this.age
)