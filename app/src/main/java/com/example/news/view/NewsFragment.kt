package com.example.news.view

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.DomainNewsResponse
import com.example.news.R
import com.example.news.adapter.NewsRecyclerViewAdapter
import com.example.news.base.BaseFragment
import com.example.news.databinding.FragmentNewsBinding
import com.example.news.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding>(R.layout.fragment_news) {
    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.news = this
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        mainViewModel.getNews("709b04335e404b30a64045caf1d2dfde")
        mainViewModel.apiCallResult.observe(viewLifecycleOwner) {
            Log.d("성공", "subscribeToLiveData mainViewModel.apiCallResult: $it")
            initRecycler(it._articles)
        }
    }

    private fun initRecycler(list: List<DomainNewsResponse>) {
        binding.recyclerviewNews.adapter = NewsRecyclerViewAdapter(list)
        binding.recyclerviewNews.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}