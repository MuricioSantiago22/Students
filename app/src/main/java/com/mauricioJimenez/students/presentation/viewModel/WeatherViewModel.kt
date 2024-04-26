package com.mauricioJimenez.students.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mauricioJimenez.students.domain.useCase.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val coroutineContext: CoroutineContext
):ViewModel() {


    fun getWeather(city:String){
        viewModelScope.launch(coroutineContext){
            getWeatherUseCase
        }

    }
}