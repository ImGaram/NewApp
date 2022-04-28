package com.example.news.di

import com.example.data.remote.api.NewsApi
import com.example.data.repository.remote.datasourceimpl.NewsDataSourceImpl
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
}