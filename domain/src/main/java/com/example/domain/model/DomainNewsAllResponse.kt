package com.example.domain.model

interface DomainNewsAllResponse {
    val _status: String
    val _totalResults: Int
    val _articles: List<DomainNewsResponse>
}