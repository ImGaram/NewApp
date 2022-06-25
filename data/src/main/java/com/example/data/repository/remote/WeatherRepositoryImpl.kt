package com.example.data.repository.remote

import com.example.data.repository.remote.weather.WeatherDataSource
import com.example.domain.model.weather.DomainWeatherResponse
import com.example.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherDataSource: WeatherDataSource
): WeatherRepository{
    override suspend fun getWeather(
        lat: Double,
        lon: Double,
        key: String
    ): DomainWeatherResponse? {
        return weatherDataSource.getWeather(lat, lon, key)
    }
}