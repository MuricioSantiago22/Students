package com.mauricioJimenez.students.data.remote.entities

import com.google.gson.annotations.SerializedName

data class HourlyDto(
    @SerializedName("temperature_2m")
    val temperature: List<Double>? = null
)
