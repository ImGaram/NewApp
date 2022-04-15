package com.example.data.repository.remote.datasource

import com.example.data.remote.model.DataNewsResponse
import com.example.domain.utils.RemoteErrorEmitter

interface NewsDataSource {
    suspend fun getNews(remoteErrorEmitter: RemoteErrorEmitter, apiKey: String): DataNewsResponse?
}