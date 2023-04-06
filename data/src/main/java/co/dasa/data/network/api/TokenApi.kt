package co.dasa.data.network.api

import co.dasa.data.network.url.DasaUrl
import retrofit2.http.Body
import retrofit2.http.POST

interface TokenApi {
    @POST(DasaUrl.REFRESH_TOKEN)
    suspend fun getNewToken(
        @Body token: String
    ): String
}
