package com.example.data.repository.remote.datasourceimpl

import com.example.data.remote.api.NewsApi
import com.example.data.remote.model.NewsResponse
import com.example.data.repository.remote.datasource.NewsDataSource
import com.example.data.utils.base.BaseRepository
import com.example.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
): BaseRepository(), NewsDataSource {
    override suspend fun getNews(
        remoteErrorEmitter: RemoteErrorEmitter,
        apiKey: String
    ): List<NewsResponse>? {
        return safeApiCall(remoteErrorEmitter) {
            newsApi.getNews(apiKey).body()
        }
    }
}