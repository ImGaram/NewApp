package com.example.domain.usecase

import com.example.domain.model.weather.DomainWeatherResponse
import com.example.domain.repository.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    operator fun invoke(
        lat: Double,
        lon: Double,
        key: String,
        scope: CoroutineScope,
        onResult: (DomainWeatherResponse?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                weatherRepository.getWeather(lat, lon, key)
            }
            onResult(deferred.await())
        }
    }
}