package com.example.data.remote.api

import com.example.data.remote.model.weather.main.MainWeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MainWeatherApi {
    // https://api.openweathermap.org/data/2.5/weather?lat=35.1852649&lon=126.8240808&appid=95dabcdab4c88faa10d407fc8d42cced
    @GET("/data/2.5/weather")
    suspend fun getMainWeather(
        @Query("lat") lat: Double,
        @Query("lon") lot: Double,
        @Query("appid") key: String
    ): Response<MainWeatherResponse>
}