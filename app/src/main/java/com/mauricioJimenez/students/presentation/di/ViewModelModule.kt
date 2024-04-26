package com.mauricioJimenez.students.presentation.di

import com.mauricioJimenez.students.domain.useCase.GetStudentDataUseCase
import com.mauricioJimenez.students.presentation.di.CoroutineScopeModule.provideIOCoroutineContext
import com.mauricioJimenez.students.presentation.viewModel.StudentViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ViewModelModule {

    @Provides
    fun providerStudentViewModel(
        getStudentUseCase: GetStudentDataUseCase
    ): StudentViewModel {
        return StudentViewModel(getStudentUseCase, provideIOCoroutineContext())
    }
}