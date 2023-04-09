package co.dasa.domain.repository

import co.dasa.domain.model.user.User
import co.dasa.domain.request.auth.JoinOwnerRequest
import co.dasa.domain.request.auth.JoinUserRequest
import co.dasa.domain.request.auth.LoginRequest

interface AuthRepository {

    suspend fun joinUser(joinUserRequest: JoinUserRequest)

    suspend fun joinOwner(joinOwnerRequest: JoinOwnerRequest)

    suspend fun login(loginRequest: LoginRequest) : User
}
