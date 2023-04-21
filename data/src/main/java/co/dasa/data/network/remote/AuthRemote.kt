package co.dasa.data.network.remote

import co.dasa.data.network.api.AuthApi
import co.dasa.data.network.response.LoginData
import co.dasa.domain.request.auth.JoinOwnerRequest
import co.dasa.domain.request.auth.JoinUserRequest
import co.dasa.domain.request.auth.LoginRequest
import co.dasa.data.base.remote.RetrofitRemote
import co.dasa.data.network.response.User

class AuthRemote : RetrofitRemote<AuthApi>() {
    override val api: AuthApi
        get() = createApi(AuthApi::class.java)

    suspend fun login(loginRequest: LoginRequest): LoginData {
        return api.login(loginRequest)
    }

    suspend fun joinUser(joinUserRequest: JoinUserRequest) {
        return api.joinUser(joinUserRequest)
    }

    suspend fun joinOwner(joinOwnerRequest: JoinOwnerRequest) {
        return api.joinOwner(joinOwnerRequest)
    }

    suspend fun getUser(token: String) : User {
        return api.getUser("Bearer $token")
    }
}
