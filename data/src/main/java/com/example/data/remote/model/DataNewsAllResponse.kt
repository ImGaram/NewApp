package com.example.data.remote.model

import com.example.domain.model.DomainNewsAllResponse
import com.example.domain.model.DomainNewsResponse
import com.google.gson.annotations.SerializedName

data class DataNewsAllResponse(
    @SerializedName("status") val status: String,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("articles") val articles: List<DataNewsResponse>
): DomainNewsAllResponse {
    override val _status: String
        get() = status
    override val _totalResults: Int
        get() = totalResults
    override val _articles: List<DomainNewsResponse>
        get() = articles
}