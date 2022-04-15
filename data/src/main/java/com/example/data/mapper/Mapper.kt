package com.example.data.mapper

import com.example.data.remote.model.DataNewsResponse
import com.example.domain.model.DomainNewsResponse

// domain layer는 data layer를 모르기 때문에 data에서 domain layer의 response data class로 자료형을 변환해 보내줘야 한다
object Mapper {
    fun mapperNews(responseData: DataNewsResponse?): DomainNewsResponse? {
        return if (responseData != null) {
            DomainNewsResponse(
                author = responseData.author,
                title = responseData.title,
                description = responseData.description,
                url = responseData.url,
                urlToImage = responseData.urlToImage,
                publishedAt = responseData.publishedAt
            )
        } else responseData
    }
}