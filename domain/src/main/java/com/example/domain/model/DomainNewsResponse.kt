package com.example.domain.model

import com.google.gson.annotations.SerializedName

data class DomainNewsResponse(
    @SerializedName("author") var _author: String? = null,
    @SerializedName("title") var _title: String? = null,
    @SerializedName("description") var _description: String? = null,
    @SerializedName("url") var _url: String? = null,
    @SerializedName("urlToImage") var _urlToImage: String? = null,
    @SerializedName("publishedAt") var _publishedAt: String? = null
)

