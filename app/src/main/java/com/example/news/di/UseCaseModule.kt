package com.example.news.di

import com.example.domain.repository.NewsRepository
import com.example.domain.usecase.GetNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Hilt로 UseCase관련 의존성 주입을 해주기 위한 파일
@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetUserRepoUseCase(repository: NewsRepository) = GetNewsUseCase(repository)
}