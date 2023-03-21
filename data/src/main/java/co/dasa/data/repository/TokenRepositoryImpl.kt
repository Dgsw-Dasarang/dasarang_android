package co.dasa.data.repository

import co.dasa.data.datasource.TokenDataSource
import co.dasa.data.mapper.toModel
import co.dasa.domain.model.token.Token
import co.dasa.domain.repository.TokenRepository
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(
    private val tokenDataSource: TokenDataSource
) : TokenRepository {

    override suspend fun getToken(): Token =
        tokenDataSource.getToken().toModel()

    override suspend fun updateNewToken(): Token =
        tokenDataSource.updateNewToken().toModel()

    override suspend fun deleteToken() =
        tokenDataSource.deleteToken()
}