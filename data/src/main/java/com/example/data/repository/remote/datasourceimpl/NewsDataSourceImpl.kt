package com.example.data.repository.remote.datasourceimpl

import com.example.data.base.BaseDataSource
import com.example.data.remote.api.NewsApi
import com.example.data.remote.model.DataNewsResponse
import com.example.data.remote.model.NewsResponseFirst
import com.example.data.repository.remote.datasource.NewsDataSource
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import javax.inject.Inject

// newsDataSource 의 구현체
// api 호출 로직
class NewsDataSourceImpl @Inject constructor(
    override val service: NewsApi
): BaseDataSource<NewsApi>(), NewsDataSource {
    override suspend fun getNews(
        apiKey: String
    ): NewsResponseFirst? {
        return safeApiCall {
            service.getNews(apiKey)
        }?.body()
    }
}