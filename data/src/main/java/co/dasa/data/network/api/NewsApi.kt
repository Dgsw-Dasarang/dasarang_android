package co.dasa.data.network.api

import co.dasa.data.network.url.DasaUrl
import co.dasa.domain.model.comment.Comment
import co.dasa.domain.model.comment.CommentList
import co.dasa.domain.model.news.NewsListData
import co.dasa.domain.request.comment.CommentRequest
import retrofit2.http.*

interface NewsApi {

    @GET(DasaUrl.NEWS_COLUMN)
    suspend fun getNewsColumn(
        @Query("page") page: Int,
        @Query("size") size: Int,
        @Query("category") category: String,
        @Query("content") content: String
    ): NewsListData

    @GET(DasaUrl.GET_COMMENT_NEWS)
    suspend fun getCommentNews(
        @Path("id") id: Int,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): CommentList

    @POST(DasaUrl.WRITE_COMMENT_NEWS)
    suspend fun writeCommentNews(
        @Header("Authorization") token: String,
        @Path("id") id: Int,
        @Body commentRequest: CommentRequest
    )
}