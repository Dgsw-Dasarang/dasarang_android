package co.dasa.domain.usecases.education

import co.dasa.domain.base.UseCase
import co.dasa.domain.model.education.EducationData
import co.dasa.domain.repository.EducationRepository
import co.dasa.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEducationByNum @Inject constructor(
    private val educationRepository: EducationRepository
) : UseCase<String, EducationData>() {

    override fun invoke(num: String): Flow<Resource<EducationData>> = execute {
        educationRepository.getEducationByNum(num)
    }
}
