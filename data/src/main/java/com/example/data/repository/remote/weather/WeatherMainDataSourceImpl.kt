package com.example.data.repository.remote.weather

import com.example.data.base.BaseDataSource
import com.example.data.remote.api.MainWeatherApi
import com.example.data.remote.model.weather.main.MainWeatherResponse
import javax.inject.Inject

class WeatherMainDataSourceImpl @Inject constructor(
    override val service: MainWeatherApi
): BaseDataSource<MainWeatherApi>(), WeatherMainDataSource {
    override suspend fun getMainWeather(
        lat: Double,
        lon: Double,
        key: String
    ): MainWeatherResponse? {
        return safeApiCall {
            service.getMainWeather(lat, lon, key)
        }?.body()
    }
}