package co.dasa.dasarang.features.news.state

import co.dasa.domain.model.comment.Comment
import co.dasa.domain.model.comment.CommentList
import co.dasa.domain.model.education.BoardDatas
import co.dasa.domain.model.education.EducationData
import co.dasa.domain.model.education.EducationDatas

data class GetCommentState(
    val isUpdate: Boolean = false,
    val result: CommentList? = null,
    val error: String = ""
)
