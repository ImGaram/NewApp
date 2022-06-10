package com.example.domain.model

import com.google.gson.annotations.SerializedName

interface DomainNewsResponse {
    val _author: String
    val _title: String
    val _description: String
    val _url: String
    val _urlToImage: String
    val _publishedAt: String
}

