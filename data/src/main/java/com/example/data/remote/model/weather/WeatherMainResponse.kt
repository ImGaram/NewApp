package com.example.data.remote.model.weather

import com.example.domain.model.weather.DomainWeatherMainResponse
import com.google.gson.annotations.SerializedName

data class WeatherMainResponse(
    @SerializedName("temp") val _temp: Double,   // 현재 기온
    @SerializedName("feels_like") val _feelsLike: Double,    // 체감 기온
    @SerializedName("humidity") val _humidity: Int   // 습도
): DomainWeatherMainResponse {
    override val temp: Double
        get() = _temp
    override val feelsLike: Double
        get() = _feelsLike
    override val humidity: Int
        get() = _humidity
}
