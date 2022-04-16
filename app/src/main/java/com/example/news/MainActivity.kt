package com.example.news


import android.util.Log
import com.example.news.base.BaseActivity
import com.example.news.databinding.ActivityMainBinding
import com.example.news.viewmodel.MainViewModel
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.utils.ErrorType
import com.example.news.adapter.NewsRecyclerViewAdapter
import com.example.domain.utils.ScreenState
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Error

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun init() {
        binding.activity = this
        binding.textViewTodayDate.text = mainViewModel.apiCallResult.publishedAt
        observeViewModel()
        mainViewModel.getNewsRepo("709b04335e404b30a64045caf1d2dfde")
    }

    private fun initRecyclerView() {
        binding.recyclerviewNews.adapter = NewsRecyclerViewAdapter(mainViewModel)
        binding.recyclerviewNews.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun observeViewModel() {
        mainViewModel.apiCallEvent.observe(this) {
            Log.d("로그", "$it")
            when (it) {
                ScreenState.LOADING -> {
                    shortToast("성공!")
                    Log.d("로그", "${mainViewModel.apiCallResult}")
                }
                ScreenState.ERROR -> toastErrorMsg()
                else -> shortToast("알 수 없는 에러 발생!")
            }
        }

        mainViewModel.apiCallEvent.observe(this) {
            initRecyclerView()
        }
    }

    private fun toastErrorMsg() {
        when(mainViewModel.apiErrorType) {
            ErrorType.NETWORK -> {
                shortToast("네트워크 오류가 발생했습니다.")
                Log.d("ERROR", "네트워크 오류가 발생했습니다.")
            }
            ErrorType.SESSION_EXPIRED -> {
                shortToast("세션이 만료되었습니다.")
                Log.d("ERROR", "세션이 만료되었습니다.")
            }
            ErrorType.TIMEOUT -> {
                shortToast("호출 시간이 초과되었습니다.")
                Log.d("ERROR", "호출 시간이 초과되었습니다.")
            }
            ErrorType.UNKNOWN -> {
                shortToast("알 수 없는 오류가 발생했습니다.")
                Log.d("ERROR", "알 수 없는 오류가 발생했습니다.")
            }
        }
    }
}