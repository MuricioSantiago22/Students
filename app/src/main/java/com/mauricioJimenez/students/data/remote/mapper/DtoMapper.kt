package com.mauricioJimenez.students.data.remote.mapper

import com.mauricioJimenez.students.data.remote.entities.HourlyDto
import com.mauricioJimenez.students.data.remote.entities.WeatherDto
import com.mauricioJimenez.students.domain.entities.Hourly
import com.mauricioJimenez.students.domain.entities.Weather

fun WeatherDto.toDomain()= Weather(
    hourly = this.hourly.toDomain()
)
fun HourlyDto.toDomain()= Hourly(
    temperature = this.temperature ?: listOf()

)