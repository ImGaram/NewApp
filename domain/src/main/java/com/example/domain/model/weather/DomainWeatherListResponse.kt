package com.example.domain.model.weather

interface DomainWeatherListResponse {
    val main: DomainWeatherMainResponse
    val weather: List<DomainWeather2Response>
    val wind: DomainWeatherWindResponse
    val cloud: DomainWeatherCloudResponse
    val dtTxt: String
}