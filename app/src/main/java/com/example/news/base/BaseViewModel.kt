package com.example.news.base

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.utils.ErrorType
import com.example.domain.utils.RemoteErrorEmitter
import com.example.domain.utils.ScreenState
import com.example.news.widget.utils.SingleLiveEvent

abstract class BaseViewModel: ViewModel(), RemoteErrorEmitter {
    val mutableProgress = MutableLiveData<Int>(View.GONE)
    val mutableScreenState = SingleLiveEvent<ScreenState>()
    val mutableErrorMessage = SingleLiveEvent<String>()
    val mutableSuccessMessage = MutableLiveData<String>()
    val mutableErrorType = SingleLiveEvent<ErrorType>()

    override fun onError(errorType: ErrorType) {
        mutableErrorType.postValue(errorType)
    }

    override fun onError(msg: String) {
        mutableErrorMessage.postValue(msg)
    }
}