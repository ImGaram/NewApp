package com.example.data.repository.remote.datasourceimpl

import com.example.data.remote.api.NewsApi
import com.example.data.remote.model.DataNewsResponse
import com.example.data.repository.remote.datasource.NewsDataSource
import com.example.data.utils.base.BaseRepository
import com.example.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

// newsDataSource 의 구현체
// api 호출 로직
class NewsDataSourceImpl @Inject constructor(
    private val newsApi: NewsApi
): BaseRepository(), NewsDataSource {
    override suspend fun getNews(
        remoteErrorEmitter: RemoteErrorEmitter,
        apiKey: String
    ): DataNewsResponse? {
        return safeApiCall(remoteErrorEmitter) {
            newsApi.getNews(apiKey = apiKey)
        }?.body()
    }
}