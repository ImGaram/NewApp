package com.example.news

import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.DomainNewsResponse
import com.example.domain.model.DomainNewsResponseFirst
import com.example.news.adapter.NewsRecyclerViewAdapter
import com.example.news.base.BaseActivity
import com.example.news.databinding.ActivityMainBinding
import com.example.news.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel by viewModels<MainViewModel>()
    private val list = mutableListOf<DomainNewsResponse>()

    override fun init() {
        binding.activity = this
        mainViewModel.getNews("709b04335e404b30a64045caf1d2dfde")
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        mainViewModel.apiCallResult.observe(this) {
            Log.d("성공", "subscribeToLiveData mainViewModel.apiCallResult: $it")
            initData(it, list)
        }
    }

    private fun initData(data: DomainNewsResponseFirst, list: MutableList<DomainNewsResponse>) {
        Log.d("RESULT", "total results: ${data.totalResults}")
        for (i:Int in 0 until 20) {
            list.add(data.articles[i])
        }
        (binding.recyclerviewNews.adapter as NewsRecyclerViewAdapter?)?.setNews(list)
        initRecycler()
    }

    private fun initRecycler() {
        binding.recyclerviewNews.adapter = NewsRecyclerViewAdapter()
        binding.recyclerviewNews.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}