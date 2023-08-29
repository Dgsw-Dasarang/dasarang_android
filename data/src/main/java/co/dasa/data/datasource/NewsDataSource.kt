package co.dasa.data.datasource

import co.dasa.data.base.BaseDataSource
import co.dasa.data.network.remote.EducationRemote
import co.dasa.data.network.remote.NewsRemote
import co.dasa.domain.model.comment.Comment
import co.dasa.domain.model.comment.CommentList
import co.dasa.domain.model.education.EducationDatas
import co.dasa.domain.model.news.NewsListData
import javax.inject.Inject

class NewsDataSource @Inject constructor(
    override val remote: NewsRemote,
    override val cache: Any
) : BaseDataSource<NewsRemote, Any> {

    suspend fun getNewsColumn(page: Int, category: String, content: String): NewsListData = remote.getNewsColumn(page, category, content)

    suspend fun getCommentNews(id: Int, page: Int): CommentList = remote.getCommentNews(id, page)

    suspend fun writeCommentNews(comment: String, token: String, id: Int) = remote.writeCommentNews(comment, token, id)
}
