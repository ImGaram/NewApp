package com.example.news.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.DomainNewsResponse
import com.example.news.databinding.NewsRecyclerItemBinding
import com.example.news.di.App

class NewsRecyclerViewAdapter: RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsRecyclerViewHolder>() {

    private var news = listOf<DomainNewsResponse>()

    @SuppressLint("NotifyDataSetChanged")
    fun setNews(items: List<DomainNewsResponse>) {
        this.news = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsRecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NewsRecyclerViewHolder(NewsRecyclerItemBinding.inflate(layoutInflater))
    }

    override fun onBindViewHolder(holder: NewsRecyclerViewHolder, position: Int) {
        holder.bind(news[position])
        Log.d("TAG", news[0].toString())
    }

    override fun getItemCount(): Int {
        return news.size
    }

    inner class NewsRecyclerViewHolder(
        private val binding: NewsRecyclerItemBinding
        ): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DomainNewsResponse) {
            binding.textViewPublishedAt.text = data._publishedAt
            binding.textViewTitle.text = data._title
            binding.textViewAuthor.text = data._author
            Glide.with(App.getInstance())
                .load(data._urlToImage)
                .into(binding.imageViewUriToImage)
        }
    }
}
