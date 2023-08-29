package co.dasa.domain.repository

import co.dasa.domain.model.comment.Comment
import co.dasa.domain.model.comment.CommentList
import co.dasa.domain.model.education.EducationDatas
import co.dasa.domain.model.news.NewsListData

interface NewsRepository {

    suspend fun getNewsColumn(page: Int, category: String, content: String): NewsListData

    suspend fun getCommentNews(id: Int, page: Int): CommentList

    suspend fun writeCommentNews(comment: String, id: Int)
}
