package com.example.data.repository.remote.weather

import com.example.data.remote.model.weather.WeatherResponse

interface WeatherDataSource {
    suspend fun getWeather(
        lat: Double,
        lon: Double,
        key: String
    ): WeatherResponse?
}