package com.example.data.remote.api

import com.example.data.remote.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    // https://newsapi.org/v2/top-headlines?country=kr&apiKey=709b04335e404b30a64045caf1d2dfde
    @GET("v2/top-headlines?country=kr")
    suspend fun getNews(@Query("apikey") apiKey: String):Response<List<NewsResponse>>
}