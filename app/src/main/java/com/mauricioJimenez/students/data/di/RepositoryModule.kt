package com.mauricioJimenez.students.data.di

import com.mauricioJimenez.students.data.repository.StudentRepositoryImpl
import com.mauricioJimenez.students.data.repository.WeatherRepositoryImpl
import com.mauricioJimenez.students.domain.repository.StudentRepository
import com.mauricioJimenez.students.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideStudentRepository(
        studentRepositoryImpl: StudentRepositoryImpl
    ): StudentRepository

    @Binds
    abstract fun provideWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ):WeatherRepository
}