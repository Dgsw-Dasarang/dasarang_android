package co.dasa.data.repository

import co.dasa.data.datasource.EducationDataSource
import co.dasa.data.datasource.TokenDataSource
import co.dasa.domain.model.education.EducationData
import co.dasa.domain.model.education.EducationDatas
import co.dasa.domain.repository.EducationRepository
import javax.inject.Inject

class EducationRepositoryImpl @Inject constructor(
    private val educationDataSource: EducationDataSource,
    private val tokenDataSource: TokenDataSource
) : EducationRepository {

    override suspend fun getEducationAll(page: Int): EducationDatas {
        return educationDataSource.getEducationAll(page)
    }

    override suspend fun getEducationByNum(num: String): EducationData {
        val token = tokenDataSource.getToken().token
        return educationDataSource.getEducationByNum(num, token)
    }


}
