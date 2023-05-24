package co.dasa.data.repository

import android.util.Log
import co.dasa.data.database.entity.AccountEntity
import co.dasa.data.datasource.AccountDataSource
import co.dasa.data.datasource.AuthDataSource
import co.dasa.data.datasource.TokenDataSource
import co.dasa.data.mapper.toModel
import co.dasa.domain.model.token.Token
import co.dasa.domain.model.user.User
import co.dasa.domain.model.user.UserInfo
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

    override suspend fun login(loginRequest: LoginRequest) : User {
        authDataSource.login(loginRequest).also {
            accountDataSource.insertAccount(AccountEntity(loginRequest.userId!!, loginRequest.password!!))
            tokenDataSource.insertToken(Token(it.accessToken, it.refreshToken))
            return User(it.name, it.type)
        }
    }

    override suspend fun joinUser(joinUserRequest: JoinUserRequest) {
        authDataSource.joinUser(joinUserRequest)
    }

    override suspend fun joinOwner(joinOwnerRequest: JoinOwnerRequest) {
        authDataSource.joinOwner(joinOwnerRequest)
    }

    override suspend fun getUser(): UserInfo {
        val token = tokenDataSource.getToken().token
        Log.d("token : ", token)
        return authDataSource.getUser(token).toModel()
    }

    override suspend fun logout() {
        tokenDataSource.deleteToken()
        accountDataSource.deleteAccount()
    }
}
