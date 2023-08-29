package co.dasa.domain.usecases.news

import co.dasa.domain.base.UseCase
import co.dasa.domain.model.comment.Comment
import co.dasa.domain.model.comment.CommentList
import co.dasa.domain.model.education.EducationDatas
import co.dasa.domain.model.news.NewsListData
import co.dasa.domain.repository.EducationRepository
import co.dasa.domain.repository.NewsRepository
import co.dasa.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCommentNews @Inject constructor(
    private val newsRepository: NewsRepository
) : UseCase<GetCommentNews.Params, CommentList>() {

    override fun invoke(params: Params): Flow<Resource<CommentList>> = execute {
        newsRepository.getCommentNews(params.id, params.page)
    }

    data class Params(
        val id: Int,
        val page: Int
    )
}
