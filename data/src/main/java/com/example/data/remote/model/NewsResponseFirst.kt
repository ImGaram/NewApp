package com.example.data.remote.model

import com.example.domain.model.DomainNewsResponse
import com.google.gson.annotations.SerializedName

data class NewsResponseFirst(
    @SerializedName("status") val status: String,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("articles") val articles: List<DomainNewsResponse>
)