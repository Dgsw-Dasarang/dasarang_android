package co.dasa.dasarang.features.news.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import co.dasa.domain.model.comment.Comment

object CommentDiffUtilCallback : DiffUtil.ItemCallback<Comment>() {
    override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
        return oldItem.comment == newItem.comment
    }
}
