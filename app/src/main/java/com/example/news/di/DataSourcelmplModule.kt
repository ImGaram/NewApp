package com.example.news.di

import com.example.data.remote.api.NewsApi
import com.example.data.repository.remote.datasource.NewsDataSource
import com.example.data.repository.remote.datasourceimpl.NewsDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourcelmplModule {

    @Provides
    @Singleton
    fun provideMainDataSource(
        newsApi: NewsApi
    ): NewsDataSource {
        return NewsDataSourceImpl(newsApi)
    }
}