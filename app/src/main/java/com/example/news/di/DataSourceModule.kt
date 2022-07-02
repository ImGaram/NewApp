package com.example.news.di

import com.example.data.remote.api.MainWeatherApi
import com.example.data.remote.api.NewsApi
import com.example.data.remote.api.WeatherApi
import com.example.data.repository.remote.datasourceimpl.NewsDataSourceImpl
import com.example.data.repository.remote.weather.WeatherDataSourceImpl
import com.example.data.repository.remote.weather.WeatherMainDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun provideMainDataSource(api: NewsApi) = NewsDataSourceImpl(api)

    @Provides
    @Singleton
    fun provideWeatherDataSource(api: WeatherApi) = WeatherDataSourceImpl(api)

    @Provides
    @Singleton
    fun provideMainWeatherDataSource(api: MainWeatherApi) = WeatherMainDataSourceImpl(api)
}