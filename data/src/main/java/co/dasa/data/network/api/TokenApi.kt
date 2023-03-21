package co.dasa.data.network.api

import co.dasa.data.network.response.LoginData
import co.dasa.data.network.url.DasaUrl
import co.dasa.domain.request.auth.LoginRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TokenApi {
    @POST(DasaUrl.REFRESH_TOKEN)
    suspend fun getNewToken(
        @Body token: String
    ): String
}
