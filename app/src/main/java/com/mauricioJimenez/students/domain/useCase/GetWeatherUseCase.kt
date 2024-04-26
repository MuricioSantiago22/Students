package com.mauricioJimenez.students.domain.useCase
import com.mauricioJimenez.students.domain.entities.Weather
import com.mauricioJimenez.students.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
){

    suspend operator fun invoke(lat: Double, lon: Double): Weather {
        return weatherRepository.getWeather(lat, lon)
    }
}