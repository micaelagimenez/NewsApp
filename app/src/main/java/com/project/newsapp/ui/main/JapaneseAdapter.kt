package com.project.newsapp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.newsapp.R
import com.project.newsapp.data.jp.ArticlesData
import com.project.newsapp.databinding.NewsItemsBinding
import com.squareup.picasso.Picasso

class JapaneseAdapter(
    private var japaneseResponse: List<ArticlesData>,
    private val onClick: (clickedArticles: ArticlesData) -> Unit
) :
    RecyclerView.Adapter<JapaneseAdapter.ViewHolder>() {

    inner class ViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view) {
        private val binding = NewsItemsBinding.bind(view)

        private val itemTitle: TextView = binding.tvTitle
        val itemImage: ImageView = binding.ivNews

        fun bind(response: ArticlesData) {
            Picasso.get().load(response.urlToImage).into(itemImage)
            itemTitle.text = response.Title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.news_items, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(japaneseResponse[position])

        holder.itemImage.setOnClickListener {
            onClick.invoke(japaneseResponse[position])
        }
    }

    override fun getItemCount(): Int {
        return japaneseResponse.size
    }

}