package com.example.data.remote.model.weather

import com.example.domain.model.weather.DomainWeatherCloudResponse
import com.google.gson.annotations.SerializedName

data class WeatherCloudResponse(
    @SerializedName("all") val _all: Int
): DomainWeatherCloudResponse {
    override val all: Int
        get() = _all
}