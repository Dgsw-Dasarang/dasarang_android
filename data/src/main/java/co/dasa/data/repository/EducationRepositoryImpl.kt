package co.dasa.data.repository

import co.dasa.data.datasource.EducationDataSource
import co.dasa.domain.model.education.EducationDatas
import co.dasa.domain.repository.EducationRepository
import javax.inject.Inject

class EducationRepositoryImpl @Inject constructor(
    private val educationDataSource: EducationDataSource
) : EducationRepository {

    override suspend fun getEducationAll(page: Int): EducationDatas {
        return educationDataSource.getEducationAll(page)
    }


}
