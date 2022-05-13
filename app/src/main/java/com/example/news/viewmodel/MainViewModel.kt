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
import kotlinx.coroutines.launch
import javax.inject.Inject

// UseCase를 Hilt를 이용해 주입받아 사용
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
): BaseViewModel() {
    private val _news =MutableLiveData<DomainNewsResponseFirst>()
    val news: LiveData<DomainNewsResponseFirst> = _news

    var apiCallResult = DomainNewsResponse("","" , "", "", "", "")

    fun getNews(apiKey: String) {
        getNewsUseCase(apiKey, viewModelScope) {
            Log.d("성공", "getNews response: $it")
            _news.value = it
        }
    }
}