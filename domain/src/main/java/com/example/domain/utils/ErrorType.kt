package com.example.domain.utils

// api 호출 에러 타입 class
enum class ErrorType {
    NETWORK,
    TIMEOUT,
    SESSION_EXPIRED,
    UNKNOWN
}