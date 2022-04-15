package com.example.domain.model

import com.google.gson.annotations.SerializedName

data class DomainNewsResponse(
    var author: String?,
    var title: String?,
    var description: String?,
    var url: String?,
    var urlToImage: String?,
    var publishedAt: String?
)
