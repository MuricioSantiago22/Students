package com.mauricioJimenez.students.data.remote.entities

import com.google.gson.annotations.SerializedName

data class WeatherDto(



@SerializedName("temp")
val temp: Double? = null,
@SerializedName("pressure")
val pressure: Int? = null,
@SerializedName("humidity")
val humidity: Int? = null,
@SerializedName("sunrise")
val sunrise:Long?= null,
@SerializedName("sunset")
val sunset: Long? = null,
@SerializedName("wind_speed")
val wind_speed: Double? = null,
val wind_deg: Int? = null,
val wind_gust: Double? = null,
@SerializedName("weather")
val weather: List<DescriptionDto>
)
