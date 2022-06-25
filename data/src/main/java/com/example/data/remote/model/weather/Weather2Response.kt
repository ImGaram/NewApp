package com.example.data.remote.model.weather

import com.example.domain.model.weather.DomainWeather2Response
import com.google.gson.annotations.SerializedName

data class Weather2Response(
    @SerializedName("main") val _main: String,      // 날씨
    @SerializedName("description") val _description: String // 날씨 세부정보
): DomainWeather2Response {
    override val main: String
        get() = _main
    override val description: String
        get() = _description
}
