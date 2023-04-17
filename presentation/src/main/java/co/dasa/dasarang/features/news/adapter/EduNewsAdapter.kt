package co.dasa.dasarang.features.news.adapter

import android.content.Intent
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseListAdapter
import co.dasa.dasarang.databinding.ItemEduNewsBinding
import co.dasa.dasarang.features.news.activity.DetailActivity
import co.dasa.dasarang.features.news.adapter.callback.EduNewsDiffUtilCallback
import co.dasa.domain.model.education.EducationData
import co.dasa.domain.model.education.EducationDatas
import co.dasa.domain.model.news.EduNewsData

class EduNewsAdapter : BaseListAdapter<EducationData, ItemEduNewsBinding>(R.layout.item_edu_news, EduNewsDiffUtilCallback) {
    override fun action(item: EducationData, binding: ItemEduNewsBinding) {
        binding.enews = item
        binding.root.setOnClickListener {
            val intent = Intent(binding.root.context, DetailActivity::class.java)
            intent.putExtra("item", item)
            binding.root.context.startActivity(intent)
        }
    }
}
