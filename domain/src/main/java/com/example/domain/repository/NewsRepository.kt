package com.example.domain.repository

import com.example.domain.model.DomainNewsAllResponse

interface NewsRepository {
    suspend fun getNews(
        apiKey: String
    ): DomainNewsAllResponse?
}