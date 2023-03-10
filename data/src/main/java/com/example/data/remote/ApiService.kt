package com.example.data.remote

import com.example.domain.entity.forcast.ForcastResponse
import com.example.domain.entity.weather.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    suspend fun getWeather(@Query("lat")lat:Double,@Query("lon")lon:Double,
    @Query("lang")lang:String,@Query("appid")apiKey:String):WeatherResponse
    @GET("forecast")
    suspend fun getForcast(@Query("lat")lat:Double,@Query("lon")lon:Double,@Query("appid")apiKey:String):ForcastResponse
}