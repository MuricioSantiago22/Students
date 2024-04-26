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

    @Query("DELETE FROM student_table WHERE id = :studentId")
    suspend fun deleteStudentById(studentId: Int)

    @Query("UPDATE student_table SET name = :name, age = :age WHERE id = :studentId")
    suspend fun updateStudentById(studentId: Int, name: String, age: String)
}