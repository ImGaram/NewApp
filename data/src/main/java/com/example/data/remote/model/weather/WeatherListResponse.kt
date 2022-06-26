package com.example.data.remote.model.weather

import com.example.domain.model.weather.*
import com.google.gson.annotations.SerializedName

data class WeatherListResponse(
    @SerializedName("main") val _main: WeatherMainResponse,   // 기온 리스트
    @SerializedName("weather") val _weather: List<Weather2Response>, // 날씨 리스트
    @SerializedName("wind") val _wind: WeatherWindResponse,   // 바람 리스트
    @SerializedName("clouds") val _clouds: WeatherCloudResponse,
    @SerializedName("dt_txt") val _dtTxt: String     // 날짜
): DomainWeatherListResponse {
    override val main: DomainWeatherMainResponse
        get() = _main
    override val weather: List<DomainWeather2Response>
        get() = _weather
    override val cloud: DomainWeatherCloudResponse
        get() = _clouds
    override val wind: DomainWeatherWindResponse
        get() = _wind
    override val dtTxt: String
        get() = _dtTxt
}
