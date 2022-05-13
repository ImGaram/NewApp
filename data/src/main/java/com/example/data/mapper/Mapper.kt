package com.example.data.mapper

import com.example.data.remote.model.DataNewsResponse
import com.example.data.remote.model.NewsResponseFirst
import com.example.domain.model.DomainNewsResponse
import com.example.domain.model.DomainNewsResponseFirst

// domain layer는 data layer를 모르기 때문에 data에서 domain layer의 response data class로 자료형을 변환해 보내줘야 한다
object Mapper {
    fun mapperNewsFirst(
        newsResponseFirst: NewsResponseFirst?
    ): DomainNewsResponseFirst? {
        return if (newsResponseFirst != null) {
            DomainNewsResponseFirst(
                status = newsResponseFirst.status,
                totalResults = newsResponseFirst.totalResults,
                articles = newsResponseFirst.articles
            )
        } else newsResponseFirst
    }

//    fun mapperNews(
//        dataNewsResponse: DataNewsResponse?
//    ): DomainNewsResponse? {
//        return if (dataNewsResponse != null) {
//            DomainNewsResponse(
//                author = dataNewsResponse._author,
//                description = dataNewsResponse._description,
//                title = dataNewsResponse._title,
//                url = dataNewsResponse._url,
//                urlToImage = dataNewsResponse._urlToImage,
//                publishedAt = dataNewsResponse._publishedAt
//            )
//        } else dataNewsResponse
//    }

}