package com.mauricioJimenez.students.data.remote.entities

import com.google.gson.annotations.SerializedName

data class DescriptionDto(
    @SerializedName("description")
    val description: String? = null
)
