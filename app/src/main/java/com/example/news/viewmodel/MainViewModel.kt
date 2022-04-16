package com.example.news.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DomainNewsResponse
import com.example.domain.usecase.GetNewsUseCase
import com.example.domain.utils.ErrorType
import com.example.domain.utils.ScreenState
import com.example.news.base.BaseViewModel
import com.example.news.widget.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// UseCase를 Hilt를 이용해 주입받아 사용
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
): BaseViewModel() {
    val apiCallEvent: LiveData<ScreenState> get() = _apiCallEvent
    private var _apiCallEvent = SingleLiveEvent<ScreenState>()
    val newsList = arrayListOf<DomainNewsResponse>()

    var apiErrorType = ErrorType.UNKNOWN
    var apiErrorMessage = "none"
    var apiCallResult = DomainNewsResponse("","" , "", "", "", "")

    // api 받아오기
    fun getNewsRepo(apiKey: String) {
        viewModelScope.launch {
            getNewsUseCase.execute(this@MainViewModel, apiKey).let { response ->
                if (response != null) {
                    apiCallResult = response
                    Log.d("로그", "$response")
                    _apiCallEvent.postValue(ScreenState.LOADING)
                } else {
                    _apiCallEvent.postValue(ScreenState.ERROR)
                }
            }
        }
    }
}