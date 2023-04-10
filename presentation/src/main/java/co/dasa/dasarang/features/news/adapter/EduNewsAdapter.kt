package co.dasa.dasarang.features.news.adapter

import android.content.Intent
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseListAdapter
import co.dasa.dasarang.databinding.ItemNewsBinding
import co.dasa.dasarang.features.news.activity.DetailActivity
import co.dasa.dasarang.features.news.adapter.callback.NewsDiffUtilCallback
import co.dasa.domain.model.news.NewsData

class NewsAdapter() : BaseListAdapter<NewsData, ItemNewsBinding>(R.layout.item_news, NewsDiffUtilCallback) {
    override fun action(item: NewsData, binding: ItemNewsBinding) {
        binding.news = item
        binding.root.setOnClickListener {
            val intent = Intent(binding.root.context, DetailActivity::class.java)
            binding.root.context.startActivity(intent)
        }
    }
}
