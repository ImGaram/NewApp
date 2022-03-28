package com.example.domain.utils

// 에러 타입과 메시지를 받기 위한 interface
interface RemoteErrorEmitter {
    fun onError(msg: String)
    fun onError(errorType: ErrorType)
}