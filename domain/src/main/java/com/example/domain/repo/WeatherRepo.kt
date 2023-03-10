package com.example.domain.repo

import com.example.domain.entity.fakeentity.FavDomainEntity
import com.example.domain.entity.fakeentity.HomeFake
import com.example.domain.entity.forcast.ForcastResponse
import com.example.domain.entity.weather.WeatherResponse


interface WeatherRepo {
    suspend fun getWeatherFromRemote(lat:Double,lon:Double,lang:String,apiKey:String): WeatherResponse
    suspend fun getForcastFromRemote(lat:Double,lon:Double,apiKey:String):ForcastResponse
    suspend fun getFavFromLocal():List<FavDomainEntity>
    suspend fun addFav(fav:FavDomainEntity)
    suspend fun deleteFav(fav:FavDomainEntity)
    suspend fun getHomeFromLocal():List<HomeFake>
    suspend fun addHome(homeFake: HomeFake)

}