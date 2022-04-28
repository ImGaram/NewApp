package com.example.news.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// hilt 를 시작하기 위해 @HiltAndroidApp 어노테이션이 달린 Application()을 상속받는 파일
@HiltAndroidApp
open class App: Application() {
    companion object {
        private lateinit var instance: App
        fun getInstance() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}