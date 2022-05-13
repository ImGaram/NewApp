package com.example.domain.model

import com.google.gson.annotations.SerializedName

data class DomainNewsResponse(
    @SerializedName("author") var _author: String,
    @SerializedName("title") var _title: String,
    @SerializedName("description") var _description: String,
    @SerializedName("url") var _url: String,
    @SerializedName("urlToImage") var _urlToImage: String,
    @SerializedName("publishedAt") var _publishedAt: String
)

