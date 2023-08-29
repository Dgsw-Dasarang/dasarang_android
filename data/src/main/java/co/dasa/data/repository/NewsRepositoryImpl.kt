package co.dasa.data.repository

import co.dasa.data.datasource.EducationDataSource
import co.dasa.data.datasource.NewsDataSource
import co.dasa.data.datasource.TokenDataSource
import co.dasa.domain.model.comment.Comment
import co.dasa.domain.model.comment.CommentList
import co.dasa.domain.model.education.EducationDatas
import co.dasa.domain.model.news.NewsListData
import co.dasa.domain.repository.EducationRepository
import co.dasa.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsDataSource: NewsDataSource,
    private val tokenDataSource: TokenDataSource
) : NewsRepository {

    override suspend fun getNewsColumn(page: Int, category: String, content: String): NewsListData {
        return newsDataSource.getNewsColumn(page, category, content)
    }

    override suspend fun getCommentNews(id: Int, page: Int): CommentList {
        return newsDataSource.getCommentNews(id, page)
    }

    override suspend fun writeCommentNews(comment: String, id: Int) {
        val token = tokenDataSource.getToken().token
        return newsDataSource.writeCommentNews(comment, token, id)
    }


}
