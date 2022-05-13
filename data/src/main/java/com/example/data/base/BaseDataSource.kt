package com.example.data.base

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

abstract class BaseDataSource<RE> {
    abstract val service: RE

    suspend inline fun<T> safeApiCall(crossinline callFunction: suspend () -> T): T? {
        return try {
            val myObj = withContext(Dispatchers.IO) { callFunction.invoke() }
            myObj
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                e.printStackTrace()
                Log.e("ERROR", "safeApiCall catch: ${e.localizedMessage}", e.cause)
                when(e) {
                    is HttpException -> {
                        val body = e.response()?.errorBody()
                        Log.e("ERROR", "HttpException error $body")
                    }
                    is SocketTimeoutException -> Log.e("ERROR", "timeout error")
                    is IOException -> Log.e("ERROR", "network error")
                    else -> Log.e("ERROR", "알수 없는 오류")
                }
            }
            null
        }
    }
}