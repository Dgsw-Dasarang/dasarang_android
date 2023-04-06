package co.dasa.domain.usecases.education

import co.dasa.domain.base.UseCase
import co.dasa.domain.model.education.EducationDatas
import co.dasa.domain.repository.EducationRepository
import co.dasa.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEducationAll @Inject constructor(
    private val educationRepository: EducationRepository
) : UseCase<Int, EducationDatas>() {

    override fun invoke(page: Int): Flow<Resource<EducationDatas>> = execute {
        educationRepository.getEducationAll(page)
    }
}
