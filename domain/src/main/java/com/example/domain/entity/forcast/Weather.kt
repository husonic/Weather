package com.example.domain.entity.forcast

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)