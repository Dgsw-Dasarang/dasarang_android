package co.dasa.dasarang.features.news.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import co.dasa.domain.model.news.NewsData

object NewsDiffUtilCallback : DiffUtil.ItemCallback<NewsData>() {
    override fun areItemsTheSame(oldItem: NewsData, newItem: NewsData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: NewsData, newItem: NewsData): Boolean {
        return oldItem.title == newItem.title
    }


}