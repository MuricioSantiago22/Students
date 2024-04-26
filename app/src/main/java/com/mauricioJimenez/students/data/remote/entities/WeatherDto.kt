package com.mauricioJimenez.students.data.remote.entities

import com.google.gson.annotations.SerializedName

data class WeatherDto(
     @SerializedName("hourly")
     val hourly: HourlyDto
)
