package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.ItemViewBinding

class MyAdapter(private val newsItems: MutableList<NewsData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun getItemCount(): Int {
        return newsItems.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        (holder as ViewHolder).bind(newsItems[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}

class ViewHolder(binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
    val itemTitle = binding.itemViewTvTitle
    val itemTitleImg = binding.itemViewItemImg
    val itemDesc = binding.itemViewTvItemDesc
    val itemDate = binding.itemViewTvDate
    val itemCompany = binding.itemViewTvCompany
    fun bind(item: NewsData) {
        itemTitle.text = item.newsTitle
        itemTitleImg.setImageResource(item.newsTitleImage)
        itemDesc.text = item.newsArticle
        itemDate.text = item.newsAddDate
        itemCompany.text = item.newsCompany
    }
}