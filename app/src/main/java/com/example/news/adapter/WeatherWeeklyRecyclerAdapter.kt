package com.example.news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.weather.DomainWeatherListResponse
import com.example.news.R
import com.example.news.databinding.RecyclerItemWeatherWeeklyBinding
import kotlin.math.round

class WeatherWeeklyRecyclerAdapter(private val weatherList: List<DomainWeatherListResponse>): RecyclerView.Adapter<WeatherWeeklyRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerItemWeatherWeeklyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(weatherList[position])
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    inner class ViewHolder(private val binding: RecyclerItemWeatherWeeklyBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DomainWeatherListResponse) {
            val temp = data.main.temp-273
            val feelsLike = data.main.feelsLike-273
            data.weather.map {
                setImage(it.main, data.cloud.all)
            }
            binding.textMainTemp.text = (round(temp*1)/1f).toString() + "°C"
            binding.textFeelsLike.text = "체감 온도:" + round(feelsLike).toString() + "°C"
            binding.textWindSpeed.text = data.wind.speed.toString() + "m/s"
            binding.textHumidity.text = "습도:" + data.main.humidity.toString() + "%"
            binding.textDate.text = data.dtTxt
        }

        private fun setImage(main: String, all: Int) {
            when (main) {
                "Rain" -> binding.weatherImg.setImageResource(R.drawable.rainy)
                "Clouds" -> {
                    if (all in 1..50) binding.weatherImg.setImageResource(R.drawable.sun_cloud)
                    else if (all in 51..100) binding.weatherImg.setImageResource(R.drawable.cloud)
                }
                "Snow" -> binding.weatherImg.setImageResource(R.drawable.snow)
                "Clear" -> binding.weatherImg.setImageResource(R.drawable.sunny)
            }
        }
    }
}