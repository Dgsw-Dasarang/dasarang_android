package co.dasa.dasarang.features.news.adapter

import android.util.Log
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseListAdapter
import co.dasa.dasarang.databinding.ItemCommentBinding
import co.dasa.dasarang.features.news.adapter.callback.CommentDiffUtilCallback
import co.dasa.domain.model.comment.Comment

class CommentAdapter : BaseListAdapter<Comment, ItemCommentBinding>(R.layout.item_comment, CommentDiffUtilCallback) {
    override fun action(item: Comment, binding: ItemCommentBinding) {
        binding.comment = item
    }
}