package com.example.data.repository.remote.weather

import com.example.data.remote.model.weather.main.MainWeatherResponse

interface WeatherMainDataSource {
    suspend fun getMainWeather(
        lat: Double,
        lon: Double,
        key: String
    ): MainWeatherResponse?
}