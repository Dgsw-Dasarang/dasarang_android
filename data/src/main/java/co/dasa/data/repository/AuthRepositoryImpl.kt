package co.dasa.data.repository

import co.dasa.data.database.entity.AccountEntity
import co.dasa.data.datasource.AccountDataSource
import co.dasa.data.datasource.AuthDataSource
import co.dasa.data.datasource.TokenDataSource
import co.dasa.domain.model.token.Token
import co.dasa.domain.repository.AuthRepository
import co.dasa.domain.request.auth.JoinOwnerRequest
import co.dasa.domain.request.auth.JoinUserRequest
import co.dasa.domain.request.auth.LoginRequest
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource,
    private val accountDataSource: AccountDataSource,
    private val tokenDataSource: TokenDataSource
) : AuthRepository {

    override suspend fun login(loginRequest: LoginRequest) {
        authDataSource.login(loginRequest).also {
            accountDataSource.insertAccount(AccountEntity(loginRequest.userId!!, loginRequest.password!!))
            tokenDataSource.insertToken(Token(it.accessToken, it.refreshToken))
        }
    }

    override suspend fun joinUser(joinUserRequest: JoinUserRequest) {
        authDataSource.joinUser(joinUserRequest)
    }

    override suspend fun joinOwner(joinOwnerRequest: JoinOwnerRequest) {
        authDataSource.joinOwner(joinOwnerRequest)
    }
}
