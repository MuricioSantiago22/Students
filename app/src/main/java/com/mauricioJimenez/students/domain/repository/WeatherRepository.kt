package com.mauricioJimenez.students.domain.repository

import com.mauricioJimenez.students.domain.entities.Weather

interface WeatherRepository {

    suspend fun getWeather(lat: Double, lon: Double):Weather
}