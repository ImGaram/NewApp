package com.example.domain.repository

import com.example.domain.model.weather.DomainWeatherResponse

interface WeatherRepository {
    suspend fun getWeather(
        lat: Double,
        lon: Double,
        key: String
    ): DomainWeatherResponse?
}