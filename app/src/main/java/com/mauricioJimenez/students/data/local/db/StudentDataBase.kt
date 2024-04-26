package com.mauricioJimenez.students.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mauricioJimenez.students.data.local.dao.StudentDao
import com.mauricioJimenez.students.data.local.entities.StudentEntity


@Database(entities = [StudentEntity::class], version = 1)
abstract class StudentDataBase : RoomDatabase(){
    abstract fun getStudentDataDao(): StudentDao
}