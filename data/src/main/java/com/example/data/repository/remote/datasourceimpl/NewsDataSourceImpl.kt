package com.example.data.repository.remote.datasourceimpl

import com.example.data.remote.api.NewsApi
import com.example.data.remote.model.DataNewsResponse
import com.example.data.repository.remote.datasource.NewsDataSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

// newsDataSource 의 구현체
// api 호출 로직
class NewsDataSourceImpl @Inject constructor(
    private val newsApi: NewsApi
): NewsDataSource {
    override suspend fun getNews(
        apiKey: String
    ): List<DataNewsResponse> {
        return newsApi.getNews(apiKey)
    }
}