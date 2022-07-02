package com.example.news.di

import com.example.data.repository.remote.MainWeatherRepositoryImpl
import com.example.data.repository.remote.NewsRepositoryImpl
import com.example.data.repository.remote.WeatherRepositoryImpl
import com.example.data.repository.remote.datasourceimpl.NewsDataSourceImpl
import com.example.data.repository.remote.weather.WeatherDataSourceImpl
import com.example.data.repository.remote.weather.WeatherMainDataSourceImpl
import com.example.domain.repository.MainWeatherRepository
import com.example.domain.repository.NewsRepository
import com.example.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(newsRepositoryImpl: NewsDataSourceImpl): NewsRepository = NewsRepositoryImpl(newsRepositoryImpl)

    @Provides
    @Singleton
    fun provideWeatherRepository(weatherRepositoryImpl: WeatherDataSourceImpl): WeatherRepository = WeatherRepositoryImpl(weatherRepositoryImpl)

    @Provides
    @Singleton
    fun provideMainWeatherRepository(weatherMainRepositoryImpl: WeatherMainDataSourceImpl): MainWeatherRepository = MainWeatherRepositoryImpl(weatherMainRepositoryImpl)
}