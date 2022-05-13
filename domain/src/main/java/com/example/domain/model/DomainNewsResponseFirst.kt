package com.example.domain.model

data class DomainNewsResponseFirst(
    val status: String,
    val totalResults: Int,
    val articles: List<DomainNewsResponse>
)