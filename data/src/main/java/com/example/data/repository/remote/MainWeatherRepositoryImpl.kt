package com.example.data.repository.remote

import com.example.data.repository.remote.weather.WeatherMainDataSource
import com.example.domain.model.weather.main.DomainMainWeatherResponse
import com.example.domain.repository.MainWeatherRepository
import javax.inject.Inject

class MainWeatherRepositoryImpl @Inject constructor(
    private val dataSource: WeatherMainDataSource
): MainWeatherRepository {
    override suspend fun getMainWeather(
        lat: Double,
        lon: Double,
        key: String
    ): DomainMainWeatherResponse? {
        return dataSource.getMainWeather(lat, lon, key)
    }
}