package co.dasa.domain.repository

import co.dasa.domain.model.education.EducationData
import co.dasa.domain.model.education.EducationDatas

interface EducationRepository {

    suspend fun getEducationAll(page: Int): EducationDatas

    suspend fun getEducationByNum(num: String): EducationData
}
