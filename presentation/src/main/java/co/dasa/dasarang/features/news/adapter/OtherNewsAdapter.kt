package co.dasa.dasarang.features.news.adapter

import android.content.Intent
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseListAdapter
import co.dasa.dasarang.databinding.ItemNewsBinding
import co.dasa.dasarang.features.news.adapter.callback.NewsDiffUtilCallback
import co.dasa.dasarang.features.news.activity.OtherNewsActivity
import co.dasa.domain.model.news.OtherNewsData

class OtherNewsAdapter : BaseListAdapter<OtherNewsData, ItemNewsBinding>(R.layout.item_news, NewsDiffUtilCallback) {
    override fun action(item: OtherNewsData, binding: ItemNewsBinding) {
        binding.news = item
        binding.root.setOnClickListener {
            val intent = Intent(binding.root.context, OtherNewsActivity::class.java)
            intent.putExtra("data", item)
            binding.root.context.startActivity(intent)
        }
    }
}
