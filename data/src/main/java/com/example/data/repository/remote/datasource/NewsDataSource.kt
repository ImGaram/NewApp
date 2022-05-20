package com.example.data.repository.remote.datasource

import com.example.data.remote.model.DataNewsResponse
import com.example.data.remote.model.NewsResponseFirst
import io.reactivex.rxjava3.core.Single
import okhttp3.ResponseBody
import retrofit2.Response

interface NewsDataSource {
    suspend fun getNews(
        apiKey: String
    ): NewsResponseFirst?
}