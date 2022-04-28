package com.example.data.mapper

import com.example.data.remote.model.DataNewsResponse
import com.example.domain.model.DomainNewsResponse

// domain layer는 data layer를 모르기 때문에 data에서 domain layer의 response data class로 자료형을 변환해 보내줘야 한다
object Mapper {
    fun DataNewsResponse.mapperNews(): DomainNewsResponse {
        return DomainNewsResponse(
            this._author,
            this._title,
            this._description,
            this._url,
            this._urlToImage,
            this._publishedAt
        )
    }

}