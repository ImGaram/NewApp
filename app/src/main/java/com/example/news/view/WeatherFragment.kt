package com.example.news.view

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.weather.DomainWeatherListResponse
import com.example.domain.model.weather.DomainWeatherResponse
import com.example.news.R
import com.example.news.adapter.WeatherWeeklyRecyclerAdapter
import com.example.news.base.BaseFragment
import com.example.news.databinding.FragmentWeatherBinding
import com.example.news.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : BaseFragment<FragmentWeatherBinding>(R.layout.fragment_weather) {
    private val viewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.weather = this

        getWeatherApi()
        viewSetting()
    }

    private fun getWeatherApi() {
        val lat = arguments?.getDouble("lat")
        val lon = arguments?.getDouble("lot")
        viewModel.getWeather(lat!!, lon!!, "95dabcdab4c88faa10d407fc8d42cced")
        viewModel.weatherApiCallResult.observe(viewLifecycleOwner) {
            Log.d("SUCCESS", "getWeatherApi result: $it")
            initWeeklyRecycler(it.list)
        }
    }

    private fun initWeeklyRecycler(item: List<DomainWeatherListResponse>) {
        binding.weatherWeeklyRecyclerView.adapter = WeatherWeeklyRecyclerAdapter(item)
        binding.weatherWeeklyRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun viewSetting() {

    }
}