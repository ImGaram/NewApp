package com.example.news.di

import com.example.data.repository.remote.NewsRepositoryImpl
import com.example.data.repository.remote.datasourceimpl.NewsDataSourceImpl
import com.example.domain.repository.NewsRepository
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
}