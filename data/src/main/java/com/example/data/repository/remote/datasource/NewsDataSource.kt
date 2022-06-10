package com.example.data.repository.remote.datasource

import com.example.data.remote.model.DataNewsAllResponse

interface NewsDataSource {
    suspend fun getNews(
        apiKey: String
    ): DataNewsAllResponse?
}