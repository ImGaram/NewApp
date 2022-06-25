package com.example.domain.model.weather

interface DomainWeatherMainResponse {
    val temp: Double
    val feelsLike: Double
    val humidity: Int
}