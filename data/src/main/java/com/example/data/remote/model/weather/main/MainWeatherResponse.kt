package com.example.data.remote.model.weather.main

import com.example.data.remote.model.weather.Weather2Response
import com.example.data.remote.model.weather.WeatherCloudResponse
import com.example.data.remote.model.weather.WeatherMainResponse
import com.example.data.remote.model.weather.WeatherWindResponse
import com.example.domain.model.weather.DomainWeather2Response
import com.example.domain.model.weather.DomainWeatherCloudResponse
import com.example.domain.model.weather.DomainWeatherMainResponse
import com.example.domain.model.weather.DomainWeatherWindResponse
import com.example.domain.model.weather.main.DomainMainWeatherResponse
import com.google.gson.annotations.SerializedName

data class MainWeatherResponse(
    @SerializedName("weather") val _weather: Weather2Response,
    @SerializedName("main") val _main: WeatherMainResponse,
    @SerializedName("wind") val _wind: WeatherWindResponse,
    @SerializedName("clouds") val _cloud: WeatherCloudResponse
): DomainMainWeatherResponse {
    override val weather: DomainWeather2Response
        get() = _weather
    override val main: DomainWeatherMainResponse
        get() = _main
    override val wind: DomainWeatherWindResponse
        get() = _wind
    override val cloud: DomainWeatherCloudResponse
        get() = _cloud
}
