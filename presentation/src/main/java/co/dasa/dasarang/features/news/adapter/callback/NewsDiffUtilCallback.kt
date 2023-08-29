package co.dasa.dasarang.features.news.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import co.dasa.domain.model.news.NewsData
import co.dasa.domain.model.news.OtherNewsData

object NewsDiffUtilCallback : DiffUtil.ItemCallback<OtherNewsData>() {
    override fun areItemsTheSame(oldItem: OtherNewsData, newItem: OtherNewsData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: OtherNewsData, newItem: OtherNewsData): Boolean {
        return oldItem.title == newItem.title
    }
}
