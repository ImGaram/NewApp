package com.example.domain.repository

import com.example.domain.model.DomainNewsResponse
import io.reactivex.rxjava3.core.Single

interface NewsRepository {
    suspend fun getNews(
        apiKey: String
    ): List<DomainNewsResponse>
}