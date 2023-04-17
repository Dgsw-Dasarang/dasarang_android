package co.dasa.dasarang.features.news.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import co.dasa.domain.model.education.EducationData
import co.dasa.domain.model.news.EduNewsData

object EduNewsDiffUtilCallback : DiffUtil.ItemCallback<EducationData>() {
    override fun areItemsTheSame(oldItem: EducationData, newItem: EducationData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: EducationData, newItem: EducationData): Boolean {
        return oldItem.academyName == newItem.academyName
    }
}
