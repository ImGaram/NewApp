package com.example.news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.DomainNewsResponse
import com.example.news.databinding.NewsRecyclerItemBinding
import com.example.news.di.App

class NewsRecyclerViewAdapter(val newsList: List<DomainNewsResponse>):
    RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsRecyclerViewHolder {
        return NewsRecyclerViewHolder(NewsRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: NewsRecyclerViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class NewsRecyclerViewHolder(
        private val binding: NewsRecyclerItemBinding
        ): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DomainNewsResponse) {
            binding.textViewPublishedAt.text = data._publishedAt
            binding.textViewTitle.text = data._title
            binding.textViewAuthor.text = data._author
            binding.textViewDescription.text = data._description
            Glide.with(App.getInstance())
                .load(data._urlToImage)
                .into(binding.imageViewUriToImage)
        }
    }
}
