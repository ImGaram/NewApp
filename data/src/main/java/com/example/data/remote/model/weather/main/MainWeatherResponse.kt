package com.example.data.remote.model.weather.main

import com.example.data.remote.model.weather.Weather2Response
import com.example.data.remote.model.weather.WeatherCloudResponse
import com.example.data.remote.model.weather.WeatherMainResponse
import com.example.data.remote.model.weather.WeatherWindResponse
import com.google.gson.annotations.SerializedName

data class MainWeatherResponse(
    @SerializedName("weather") val weather: Weather2Response,
    @SerializedName("main") val main: WeatherMainResponse,
    @SerializedName("wind") val wind: WeatherWindResponse,
    @SerializedName("clouds") val cloud: WeatherCloudResponse
)
