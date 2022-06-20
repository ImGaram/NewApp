package com.example.news

import android.view.MenuItem
import androidx.activity.viewModels
import com.example.news.base.BaseActivity
import com.example.news.databinding.ActivityMainBinding
import com.example.news.view.NewsFragment
import com.example.news.view.WeatherFragment
import com.example.news.viewmodel.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding>(R.layout.activity_main), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun init() {
        binding.activity = this
        viewSetting()

        binding.bottomnavi.setOnNavigationItemSelectedListener(this)
        supportFragmentManager.beginTransaction().add(R.id.linear, NewsFragment()).commit()
    }

    private fun viewSetting() {
        val now = System.currentTimeMillis()
        val mDate = Date(now)
        val simpleDate = SimpleDateFormat("yyyy.MM.dd")
        val getTime = simpleDate.format(mDate)
        binding.textViewTodayDate.text = getTime
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.news -> {
                supportFragmentManager.beginTransaction().replace(R.id.linear, NewsFragment()).commitAllowingStateLoss()
                return true
            }
            R.id.weather -> {
                supportFragmentManager.beginTransaction().replace(R.id.linear, WeatherFragment()).commitAllowingStateLoss()
                return true
            }
        }
        return false
    }
}