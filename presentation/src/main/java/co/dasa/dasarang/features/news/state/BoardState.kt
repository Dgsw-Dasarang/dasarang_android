package co.dasa.dasarang.features.news.state

import co.dasa.domain.model.education.BoardDatas

data class BoardState(
    val isUpdate: Boolean = false,
    val result: BoardDatas? = null,
    val error: String = ""
)
