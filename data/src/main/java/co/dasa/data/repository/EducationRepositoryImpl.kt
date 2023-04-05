package co.dasa.data.repository

import co.dasa.data.database.entity.AccountEntity
import co.dasa.data.datasource.AccountDataSource
import co.dasa.data.datasource.AuthDataSource
import co.dasa.data.datasource.EducationDataSource
import co.dasa.data.datasource.TokenDataSource
import co.dasa.domain.model.education.EducationDatas
import co.dasa.domain.model.token.Token
import co.dasa.domain.repository.AuthRepository
import co.dasa.domain.repository.EducationRepository
import co.dasa.domain.request.auth.JoinOwnerRequest
import co.dasa.domain.request.auth.JoinUserRequest
import co.dasa.domain.request.auth.LoginRequest
import javax.inject.Inject

class EducationRepositoryImpl @Inject constructor(
    private val educationDataSource: EducationDataSource
) : EducationRepository {


    override suspend fun getEducationAll(page: Int): EducationDatas {
        return educationDataSource.getEducationAll(page)
    }
}