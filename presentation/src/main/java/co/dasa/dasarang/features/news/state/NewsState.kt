package co.dasa.dasarang.features.news.state

import co.dasa.domain.model.education.BoardDatas
import co.dasa.domain.model.education.EducationData
import co.dasa.domain.model.education.EducationDatas
import co.dasa.domain.model.news.NewsListData

data class NewsState(
    val isUpdate: Boolean = false,
    val result: NewsListData? = null,
    val error: String = ""
)
