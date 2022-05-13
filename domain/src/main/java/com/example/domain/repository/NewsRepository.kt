package com.example.domain.repository

import com.example.domain.model.DomainNewsResponse
import com.example.domain.model.DomainNewsResponseFirst
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

interface NewsRepository {
    suspend fun getNews(
        apiKey: String
    ): DomainNewsResponseFirst?
}