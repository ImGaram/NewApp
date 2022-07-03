package com.example.domain.model.weather.main

import com.example.domain.model.weather.DomainWeather2Response
import com.example.domain.model.weather.DomainWeatherCloudResponse
import com.example.domain.model.weather.DomainWeatherMainResponse
import com.example.domain.model.weather.DomainWeatherWindResponse

interface DomainMainWeatherResponse {
    val weather: List<DomainWeather2Response>
    val main: DomainWeatherMainResponse
    val wind: DomainWeatherWindResponse
    val cloud: DomainWeatherCloudResponse
}