package com.mauricioJimenez.students.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mauricioJimenez.students.data.local.entities.StudentEntity

@Dao
interface StudentDao {
    @Insert
    suspend fun insertStudent(student: StudentEntity)

    @Query("SELECT * FROM student_table")
    suspend fun getAllStudents(): List<StudentEntity>
}