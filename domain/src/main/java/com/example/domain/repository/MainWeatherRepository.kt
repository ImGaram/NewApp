package com.example.domain.repository

import com.example.domain.model.weather.main.DomainMainWeatherResponse

interface MainWeatherRepository {
    suspend fun getMainWeather(
        lat: Double,
        lon: Double,
        key: String
    ): DomainMainWeatherResponse?
}