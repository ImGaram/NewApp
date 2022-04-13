package com.example.data.mapper

import com.example.data.remote.model.NewsResponse

// domain layer는 data layer를 모르기 때문에 data에서 domain layer의 response data class로 자료형을 변환해 보내줘야 한다
object Mapper {
    fun mapperNews(response: List<NewsResponse>?): List<com.example.domain.model.NewsResponse>? {
        return if (response != null) {
            response.toDomain()
        } else null
    }

    fun List<NewsResponse>.toDomain(): List<com.example.domain.model.NewsResponse> {
        return this.map {
            com.example.domain.model.NewsResponse(
                it.author,
                it.title,
                it.description,
                it.url,
                it.urlToImage,
                it.publishedAt
            )
        }
    }
}