package com.example.domain.model

data class DomainNewsResponse(
    var author: String?,
    var title: String?,
    var description: String?,
    var url: String?,
    var urlToImage: String?,
    var publishedAt: String?
)
