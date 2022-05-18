package com.example.domain.repository

import com.example.domain.model.DomainNewsResponseFirst

interface NewsRepository {
    suspend fun getNews(
        apiKey: String
    ): DomainNewsResponseFirst?
}