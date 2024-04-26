package com.mauricioJimenez.students.data.repository

import com.mauricioJimenez.students.app.Strings
import com.mauricioJimenez.students.data.remote.network.WeatherApiClient
import com.mauricioJimenez.students.domain.entities.Weather
import com.mauricioJimenez.students.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apClient: WeatherApiClient
):WeatherRepository {
    override suspend fun getWeather(lat: Double, lon: Double): Weather {
        val response= apClient.getWeather(lat,lon, Strings.API_KEY)
        return response
    }


}