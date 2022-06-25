package com.example.data.repository.remote.weather

import com.example.data.base.BaseDataSource
import com.example.data.remote.api.WeatherApi
import com.example.data.remote.model.weather.WeatherResponse
import retrofit2.Response
import javax.inject.Inject

class WeatherDataSourceImpl @Inject constructor(
    override val service: WeatherApi
): BaseDataSource<WeatherApi>(), WeatherDataSource {
    override suspend fun getWeather(
        lat: Double,
        lon: Double,
        key: String
    ): WeatherResponse? {
        return safeApiCall {
            service.getWeather(lat, lon, key)
        }?.body()
    }
}