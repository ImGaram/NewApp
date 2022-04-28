package com.example.data.remote.api

import com.example.data.remote.model.DataNewsResponse
import com.google.gson.annotations.SerializedName
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    // https://newsapi.org/v2/top-headlines?country=kr&apiKey=709b04335e404b30a64045caf1d2dfde
    @GET("v2/top-headlines?country=kr")
    suspend fun getNews(@Query("apikey") apiKey: String): List<DataNewsResponse>
}