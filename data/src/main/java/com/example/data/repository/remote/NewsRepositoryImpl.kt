package com.example.data.repository.remote

import com.example.data.mapper.Mapper.mapperNews
import com.example.data.repository.remote.datasource.NewsDataSource
import com.example.domain.model.DomainNewsResponse
import com.example.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsDataSource: NewsDataSource
): NewsRepository {
    override suspend fun getNews(
        apiKey: String
    ): List<DomainNewsResponse> {
        return newsDataSource.getNews(apiKey).map { it.mapperNews() }
    }
}