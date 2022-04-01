package com.example.news.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// hilt 를 시작하기 위해 @HiltAndroidApp 어노테이션이 달린 Application()을 상속받는 파일
@HiltAndroidApp
class App: Application() {
    companion object {
        private lateinit var application: App
        fun getInstance(): App = application
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}