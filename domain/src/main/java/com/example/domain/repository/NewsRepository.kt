package com.example.domain.repository

import com.example.domain.model.DomainNewsResponse
import com.example.domain.utils.RemoteErrorEmitter

interface NewsRepository {
    suspend fun getNews(
        remoteErrorEmitter: RemoteErrorEmitter,
        apiKey: String)
    : DomainNewsResponse?
}