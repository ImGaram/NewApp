package com.example.data.repository.remote.datasource

import com.example.data.remote.model.DataNewsResponse
import io.reactivex.rxjava3.core.Single

interface NewsDataSource {
    suspend fun getNews(
        apiKey: String
    ): List<DataNewsResponse>
}