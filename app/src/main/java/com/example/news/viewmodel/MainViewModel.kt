package com.example.news.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DomainNewsResponse
import com.example.domain.model.DomainNewsResponseFirst
import com.example.domain.usecase.GetNewsUseCase
import com.example.news.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

// UseCase를 Hilt를 이용해 주입받아 사용
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
): BaseViewModel() {

//    private val _news = MutableLiveData<List<DomainNewsResponse>>()
//    val news: LiveData<List<DomainNewsResponse>> = _news

    private val _apiCallResult = MutableLiveData<DomainNewsResponseFirst>()
    val apiCallResult: LiveData<DomainNewsResponseFirst> = _apiCallResult

    fun getNews(apiKey: String) {
        getNewsUseCase(apiKey, viewModelScope) {
            _apiCallResult.value = it
//            _news.value = _apiCallResult.value?.articles
        }
    }
}