package com.example.news

import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.DomainNewsResponse
import com.example.news.adapter.NewsRecyclerViewAdapter
import com.example.news.base.BaseActivity
import com.example.news.databinding.ActivityMainBinding
import com.example.news.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun init() {
        binding.activity = this
        mainViewModel.getNews("709b04335e404b30a64045caf1d2dfde")
        subscribeToLiveData()
        viewSetting()
    }

    private fun subscribeToLiveData() {
        mainViewModel.apiCallResult.observe(this) {
            Log.d("성공", "subscribeToLiveData mainViewModel.apiCallResult: $it")
            initRecycler(it._articles)
        }
    }

    private fun initRecycler(list: List<DomainNewsResponse>) {
        binding.recyclerviewNews.adapter = NewsRecyclerViewAdapter(list)
        binding.recyclerviewNews.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun viewSetting() {
        val now = System.currentTimeMillis()
        val mDate = Date(now)
        val simpleDate = SimpleDateFormat("yyyy.MM.dd")
        val getTime = simpleDate.format(mDate)
        binding.textViewTodayDate.text = getTime
    }
}