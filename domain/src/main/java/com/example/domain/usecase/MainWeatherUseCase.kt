package com.example.domain.usecase

import com.example.domain.model.weather.main.DomainMainWeatherResponse
import com.example.domain.repository.MainWeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainWeatherUseCase @Inject constructor(
    private val repository: MainWeatherRepository
) {
    operator fun invoke(
        lat: Double,
        lon: Double,
        key: String,
        scope: CoroutineScope,
        onResult: (DomainMainWeatherResponse?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.getMainWeather(lat, lon, key)
            }
            onResult(deferred.await())
        }
    }
}