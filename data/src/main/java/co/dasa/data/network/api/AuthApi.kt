package co.dasa.data.network.api

import co.dasa.data.network.response.LoginData
import co.dasa.data.network.response.User
import co.dasa.data.network.url.DasaUrl
import co.dasa.domain.request.auth.JoinOwnerRequest
import co.dasa.domain.request.auth.JoinUserRequest
import co.dasa.domain.request.auth.LoginRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthApi {
    @POST(DasaUrl.LOGIN)
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): LoginData

    @POST(DasaUrl.JOIN_USER)
    suspend fun joinUser(
        @Body joinUserRequest: JoinUserRequest
    )

    @POST(DasaUrl.JOIN_OWNER)
    suspend fun joinOwner(
        @Body joinOwnerRequest: JoinOwnerRequest
    )

    @GET(DasaUrl.GET_USER)
    suspend fun getUser(
        @Header("Authorization") token: String,
    ): User
}
