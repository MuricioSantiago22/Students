package com.mauricioJimenez.students.data.remote.entities

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("current")
     val current : WeatherDto
)
