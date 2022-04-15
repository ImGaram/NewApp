package com.example.news.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DomainNewsResponse
import com.example.domain.usecase.GetNewsUseCase
import com.example.domain.utils.ErrorType
import com.example.domain.utils.RemoteErrorEmitter
import com.example.news.base.BaseViewModel
import com.example.domain.utils.ScreenState
import com.example.news.widget.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// UseCase를 Hilt를 이용해 주입받아 사용
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
): ViewModel(), RemoteErrorEmitter {
    val apiCallEvent: LiveData<ScreenState> get() = _apiCallEvent
    private var _apiCallEvent = SingleLiveEvent<ScreenState>()
    val newsList = arrayListOf<DomainNewsResponse>()

    var apiErrorType = ErrorType.UNKNOWN
    var apiErrorMessage = "none"
    var apiCallResult = DomainNewsResponse("","" , "", "", "", "")

    fun getNewsRepo(apiKey: String) {
        viewModelScope.launch {
            getNewsUseCase.execute(this@MainViewModel, apiKey).let { response ->
                if (response != null) {
                    apiCallResult = response
                    _apiCallEvent.postValue(ScreenState.LOADING)
                } else {
                    _apiCallEvent.postValue(ScreenState.ERROR)
                }
            }
        }
    }

    override fun onError(msg: String) {
        apiErrorMessage = msg
    }

    override fun onError(errorType: ErrorType) {
        apiErrorType = errorType
    }
}