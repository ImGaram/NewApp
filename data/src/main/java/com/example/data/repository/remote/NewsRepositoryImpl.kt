package com.example.data.repository.remote

import com.example.data.mapper.Mapper
import com.example.data.repository.remote.datasource.NewsDataSource
import com.example.domain.model.DomainNewsResponse
import com.example.domain.repository.NewsRepository
import com.example.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsDataSource: NewsDataSource
): NewsRepository {
    override suspend fun getNews(
        remoteErrorEmitter: RemoteErrorEmitter,
        apiKey: String
    ): DomainNewsResponse? {
        return Mapper.mapperNews(newsDataSource.getNews(remoteErrorEmitter, apiKey))
    }
}