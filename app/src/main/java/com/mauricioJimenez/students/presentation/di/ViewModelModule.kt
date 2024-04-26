package com.mauricioJimenez.students.presentation.di

import com.mauricioJimenez.students.domain.useCase.DeleteStudentUseCase
import com.mauricioJimenez.students.domain.useCase.GetStudentDataUseCase
import com.mauricioJimenez.students.domain.useCase.GetWeatherUseCase
import com.mauricioJimenez.students.domain.useCase.InsertStudentDataUseCase
import com.mauricioJimenez.students.domain.useCase.UpdateStudentUseCase
import com.mauricioJimenez.students.presentation.di.CoroutineScopeModule.provideIOCoroutineContext
import com.mauricioJimenez.students.presentation.viewModel.StudentViewModel
import com.mauricioJimenez.students.presentation.viewModel.WeatherViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ViewModelModule {

    @Provides
    fun providerStudentViewModel(
        getStudentUseCase: GetStudentDataUseCase,
        insertStudentDataUseCase: InsertStudentDataUseCase,
        deleteStudentUseCase: DeleteStudentUseCase,
        updateStudentUseCase: UpdateStudentUseCase
    ): StudentViewModel {
        return StudentViewModel(
            getStudentUseCase,
            insertStudentDataUseCase,
            deleteStudentUseCase,
            updateStudentUseCase,
            provideIOCoroutineContext()
        )
    }

    @Provides
    fun providerWeatherViewModel(
        getWeatherUseCase: GetWeatherUseCase
    ):WeatherViewModel{
        return WeatherViewModel(getWeatherUseCase, provideIOCoroutineContext())
    }
}