package co.dasa.domain.repository

import co.dasa.domain.model.token.Token

interface TokenRepository {
    suspend fun getToken(): Token

    suspend fun updateNewToken(): Token

    suspend fun deleteToken()
}
