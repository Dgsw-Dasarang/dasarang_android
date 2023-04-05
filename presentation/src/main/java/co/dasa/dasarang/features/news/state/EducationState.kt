package co.dasa.dasarang.features.news.state

import co.dasa.domain.model.education.EducationDatas

data class EducationState (
    val isUpdate: Boolean = false,
    val result: EducationDatas? = null,
    val error: String = ""
)