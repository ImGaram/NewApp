package com.example.data.repository.remote

import com.example.data.mapper.Mapper
import com.example.data.repository.remote.datasource.NewsDataSource
import com.example.domain.model.DomainNewsResponse
import com.example.domain.model.DomainNewsResponseFirst
import com.example.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsDataSource: NewsDataSource
): NewsRepository {
    override suspend fun getNews(
        apiKey: String
    ): DomainNewsResponseFirst? {
        return Mapper.mapperNewsFirst(newsDataSource.getNews(apiKey))
    }
}