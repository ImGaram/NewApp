package com.example.data.remote.model.weather

import com.example.domain.model.weather.DomainWeatherWindResponse
import com.google.gson.annotations.SerializedName

data class WeatherWindResponse(
    @SerializedName("speed") val _speed: Double     // 풍속
): DomainWeatherWindResponse {
    override val speed: Double
        get() = _speed
}
