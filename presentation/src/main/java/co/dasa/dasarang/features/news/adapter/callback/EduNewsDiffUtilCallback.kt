package co.dasa.dasarang.features.news.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import co.dasa.domain.model.news.EduNewsData

object EduNewsDiffUtilCallback : DiffUtil.ItemCallback<EduNewsData>() {
    override fun areItemsTheSame(oldItem: EduNewsData, newItem: EduNewsData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: EduNewsData, newItem: EduNewsData): Boolean {
        return oldItem.title == newItem.title
    }
}
