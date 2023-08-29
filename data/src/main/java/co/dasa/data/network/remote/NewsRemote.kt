package co.dasa.data.network.remote

import co.dasa.data.network.api.EducationApi
import co.dasa.data.base.remote.RetrofitRemote
import co.dasa.data.network.api.NewsApi
import co.dasa.domain.model.comment.Comment
import co.dasa.domain.model.comment.CommentList
import co.dasa.domain.model.education.EducationDatas
import co.dasa.domain.model.news.NewsListData
import co.dasa.domain.request.comment.CommentRequest

class NewsRemote : RetrofitRemote<NewsApi>() {
    override val api: NewsApi
        get() = createApi(NewsApi::class.java)

    suspend fun getNewsColumn(page: Int, category: String, content: String): NewsListData {
        return api.getNewsColumn(page, 10, category, content)
    }

    suspend fun getCommentNews(id: Int, page: Int): CommentList {
        return api.getCommentNews(id, page, 10)
    }

    suspend fun writeCommentNews(comment: String, token: String, id: Int) {
        api.writeCommentNews("Bearer $token", id, CommentRequest(comment))
    }
}
