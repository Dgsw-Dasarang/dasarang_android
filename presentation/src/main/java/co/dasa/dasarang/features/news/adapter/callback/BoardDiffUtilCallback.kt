package co.dasa.dasarang.features.news.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import co.dasa.domain.model.education.BoardData
import co.dasa.domain.model.education.EducationData

object BoardDiffUtilCallback : DiffUtil.ItemCallback<BoardData>() {
    override fun areItemsTheSame(oldItem: BoardData, newItem: BoardData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: BoardData, newItem: BoardData): Boolean {
        return oldItem.title == newItem.title
    }
}
