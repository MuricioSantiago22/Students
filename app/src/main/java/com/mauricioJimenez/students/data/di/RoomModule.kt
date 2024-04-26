package com.mauricioJimenez.students.data.di

import android.content.Context
import androidx.room.Room
import com.mauricioJimenez.students.data.local.db.StudentDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val STUDENT_DATABASE_NAME = "student_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context)=
        Room.databaseBuilder(context, StudentDataBase::class.java,STUDENT_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideGetStudentData(db: StudentDataBase)= db.getStudentDataDao()
}