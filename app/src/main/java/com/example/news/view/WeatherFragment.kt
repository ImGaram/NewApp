package com.example.news.view

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.weather.*
import com.example.news.R
import com.example.news.adapter.WeatherWeeklyRecyclerAdapter
import com.example.news.base.BaseFragment
import com.example.news.databinding.FragmentWeatherBinding
import com.example.news.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.round

@AndroidEntryPoint
class WeatherFragment : BaseFragment<FragmentWeatherBinding>(R.layout.fragment_weather) {
    private val viewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.weather = this
        val lat = arguments?.getDouble("lat")
        val lon = arguments?.getDouble("lot")

        getWeatherApi(lat, lon)
        getMainWeatherApi(lat, lon)
        viewSetting()
    }

    private fun getWeatherApi(lat: Double?, lon: Double?) {
        viewModel.getWeather(lat!!, lon!!, "95dabcdab4c88faa10d407fc8d42cced")
        viewModel.weatherApiCallResult.observe(viewLifecycleOwner) {
            Log.d("SUCCESS", "getWeatherApi result: $it")
            initWeeklyRecycler(it.list)
        }
    }

    private fun getMainWeatherApi(lat: Double?, lon: Double?) {
        viewModel.getMainWeather(lat!!, lon!!, "95dabcdab4c88faa10d407fc8d42cced")
        viewModel.mainWeatherApiCallResult.observe(viewLifecycleOwner) {
            Log.d("TAG", "getMainWeatherApi: $it")
            setView(it.weather, it.main, it.cloud, it.wind)
        }
    }

    private fun setView(
        weather: List<DomainWeather2Response>,
        main: DomainWeatherMainResponse,
        cloud: DomainWeatherCloudResponse,
        wind: DomainWeatherWindResponse
    ) {
        val temp = main.temp - 273
        val feelsLike = main.feelsLike - 273
        setMainWeatherImage(weather[0].main, cloud.all)
        binding.mainWeatherTextMainTemp.text = (round(temp*1) /1f).toString() + "°C"
        binding.mainWeatherTextFeelsLike.text = "체감 온도:" + round(feelsLike).toString() + "°C"
        binding.mainWeatherTextHumidity.text = "습도:" + main.humidity.toString() + "%"
        binding.mainWeatherTextWindSpeed.text = wind.speed.toString() + "m/s"
    }

    private fun setMainWeatherImage(main: String, all: Int) {
        when (main) {
            "Rain" -> binding.mainWeatherImage.setImageResource(R.drawable.rainy)
            "Clouds" -> {
                if (all in 1..50) binding.mainWeatherImage.setImageResource(R.drawable.sun_cloud)
                else if (all in 51..100) binding.mainWeatherImage.setImageResource(R.drawable.cloud)
            }
            "Snow" -> binding.mainWeatherImage.setImageResource(R.drawable.snow)
            "Clear" -> binding.mainWeatherImage.setImageResource(R.drawable.sunny)
        }
    }

    private fun initWeeklyRecycler(item: List<DomainWeatherListResponse>) {
        binding.weatherWeeklyRecyclerView.adapter = WeatherWeeklyRecyclerAdapter(item)
        binding.weatherWeeklyRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun viewSetting() {

    }
}