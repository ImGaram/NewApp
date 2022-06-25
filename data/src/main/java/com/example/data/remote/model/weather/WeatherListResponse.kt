package com.example.data.remote.model.weather

import com.example.domain.model.weather.DomainWeather2Response
import com.example.domain.model.weather.DomainWeatherListResponse
import com.example.domain.model.weather.DomainWeatherMainResponse
import com.example.domain.model.weather.DomainWeatherWindResponse
import com.google.gson.annotations.SerializedName

data class WeatherListResponse(
    @SerializedName("main") val _main: WeatherMainResponse,   // 기온 리스트
    @SerializedName("weather") val _weather: List<Weather2Response>, // 날씨 리스트
    @SerializedName("wind") val _wind: WeatherWindResponse,   // 바람 리스트
    @SerializedName("dt_txt") val _dtTxt: String     // 날짜
): DomainWeatherListResponse {
    override val main: DomainWeatherMainResponse
        get() = _main
    override val weather: List<DomainWeather2Response>
        get() = _weather
    override val wind: DomainWeatherWindResponse
        get() = _wind
    override val dtTxt: String
        get() = _dtTxt
}
