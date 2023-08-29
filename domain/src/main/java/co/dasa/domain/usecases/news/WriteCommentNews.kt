package co.dasa.domain.usecases.news

import co.dasa.domain.base.UseCase
import co.dasa.domain.model.comment.Comment
import co.dasa.domain.repository.NewsRepository
import co.dasa.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WriteCommentNews @Inject constructor(
    private val newsRepository: NewsRepository
) : UseCase<WriteCommentNews.Params, Unit>() {

    override fun invoke(params: Params): Flow<Resource<Unit>> = execute {
        newsRepository.writeCommentNews(params.comment, params.id)
    }

    data class Params(
        val id: Int,
        val comment: String
    )
}
