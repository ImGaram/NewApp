package com.example.domain.model.weather

interface DomainWeatherResponse {
    val cod: Int
    val message: Int
    val cnt: Int
    val list: List<DomainWeatherListResponse>
}