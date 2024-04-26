package com.mauricioJimenez.students.data.remote.network

import com.mauricioJimenez.students.data.remote.entities.WeatherDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiClient {

    @GET("forecast")
    suspend fun getWeather(
        @Query("latitude") lat: Double,
        @Query("longitude") lon: Double,
        @Query("hourly") hourly: String
    ): Response<WeatherDto>
}