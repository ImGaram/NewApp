package com.example.data.remote.model.weather

import com.example.domain.model.weather.DomainWeatherListResponse
import com.example.domain.model.weather.DomainWeatherResponse
import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("cod") val _cod: Int,
    @SerializedName("message") val _message: Int,
    @SerializedName("cnt") val _cnt: Int,
    @SerializedName("list") val _list: List<WeatherListResponse>
): DomainWeatherResponse {
    override val cod: Int
        get() = _cod
    override val message: Int
        get() = _message
    override val cnt: Int
        get() = _cnt
    override val list: List<DomainWeatherListResponse>
        get() = _list
}
