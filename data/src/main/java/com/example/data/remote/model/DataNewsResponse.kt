package com.example.data.remote.model

import com.example.domain.model.DomainNewsResponse
import com.google.gson.annotations.SerializedName

data class DataNewsResponse(
    @SerializedName("author") var author: String,
    @SerializedName("title") var title: String,
    @SerializedName("description") var description: String,
    @SerializedName("url") var url: String,
    @SerializedName("urlToImage") var urlToImage: String,
    @SerializedName("publishedAt") var publishedAt: String
): DomainNewsResponse {
    override val _author: String
        get() = author
    override val _title: String
        get() = title
    override val _description: String
        get() = description
    override val _url: String
        get() = url
    override val _urlToImage: String
        get() = urlToImage
    override val _publishedAt: String
        get() = publishedAt

}