package co.dasa.data.network.remote

import co.dasa.data.network.api.AuthApi
import co.dasa.data.network.response.LoginData
import co.dasa.domain.request.auth.JoinOwnerRequest
import co.dasa.domain.request.auth.JoinUserRequest
import co.dasa.domain.request.auth.LoginRequest
import com.stac.data.base.remote.BaseRemote
import com.stac.data.base.remote.RetrofitRemote
import javax.inject.Inject

class AuthRemote : RetrofitRemote<AuthApi>() {
    override val api: AuthApi
        get() = createApi(AuthApi::class.java)

    suspend fun login(loginRequest: LoginRequest) : LoginData {
        return api.login(loginRequest)
    }

    suspend fun joinUser(joinUserRequest: JoinUserRequest){
        return api.joinUser(joinUserRequest)
    }

    suspend fun joinOwner(joinOwnerRequest: JoinOwnerRequest){
        return api.joinOwner(joinOwnerRequest)
    }


}