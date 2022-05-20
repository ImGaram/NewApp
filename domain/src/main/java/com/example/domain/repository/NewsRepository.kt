package com.example.domain.repository

import com.example.domain.model.DomainNewsResponseFirst
import okhttp3.ResponseBody
import retrofit2.Response

interface NewsRepository {
    suspend fun getNews(
        apiKey: String
    ): DomainNewsResponseFirst?
}