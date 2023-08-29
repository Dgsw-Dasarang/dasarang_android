package co.dasa.domain.usecases.news

import co.dasa.domain.base.UseCase
import co.dasa.domain.model.education.EducationDatas
import co.dasa.domain.model.news.NewsListData
import co.dasa.domain.repository.EducationRepository
import co.dasa.domain.repository.NewsRepository
import co.dasa.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewsColumn @Inject constructor(
    private val newsRepository: NewsRepository
) : UseCase<GetNewsColumn.Params, NewsListData>() {

    override fun invoke(params: Params): Flow<Resource<NewsListData>> = execute {
        newsRepository.getNewsColumn(params.page, params.category, params.content)
    }

    data class Params(
        val page: Int,
        val category: String,
        val content: String
    )
}
