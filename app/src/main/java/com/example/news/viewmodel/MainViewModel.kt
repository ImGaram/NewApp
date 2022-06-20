package com.example.news.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DomainNewsAllResponse
import com.example.domain.model.DomainNewsResponse
import com.example.domain.usecase.GetNewsUseCase
import com.example.news.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// UseCase를 Hilt를 이용해 주입받아 사용
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
): BaseViewModel() {
    private val _apiCallResult = MutableLiveData<DomainNewsAllResponse>()
    val apiCallResult: LiveData<DomainNewsAllResponse> = _apiCallResult

    fun getNews(apiKey: String) {
        getNewsUseCase(apiKey, viewModelScope) {
            _apiCallResult.value = it
        }
    }
}