package com.example.domain.model

data class DomainNewsResponse(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String
)

