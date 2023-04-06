package co.dasa.data.datasource

import co.dasa.data.base.BaseDataSource
import co.dasa.data.network.remote.AuthRemote
import co.dasa.data.network.response.LoginData
import co.dasa.domain.request.auth.JoinOwnerRequest
import co.dasa.domain.request.auth.JoinUserRequest
import co.dasa.domain.request.auth.LoginRequest
import javax.inject.Inject

class AuthDataSource @Inject constructor(
    override val remote: AuthRemote,
    override val cache: Any
) : BaseDataSource<AuthRemote, Any> {

    suspend fun login(loginRequest: LoginRequest): LoginData = remote.login(loginRequest)

    suspend fun joinUser(joinUserRequest: JoinUserRequest) = remote.joinUser(joinUserRequest)

    suspend fun joinOwner(joinOwnerRequest: JoinOwnerRequest) = remote.joinOwner(joinOwnerRequest)
}
