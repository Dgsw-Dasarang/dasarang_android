package co.dasa.domain.repository

import co.dasa.domain.model.education.EducationDatas
import co.dasa.domain.request.auth.JoinOwnerRequest
import co.dasa.domain.request.auth.JoinUserRequest
import co.dasa.domain.request.auth.LoginRequest

interface EducationRepository {

    suspend fun getEducationAll(page: Int) : EducationDatas
}