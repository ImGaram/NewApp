package com.example.domain.repository

import com.example.domain.model.NewsResponse
import com.example.domain.utils.RemoteErrorEmitter

interface NewsRepository {
    suspend fun getNews(remoteErrorEmitter: RemoteErrorEmitter, apiKey: String): List<NewsResponse?>
}