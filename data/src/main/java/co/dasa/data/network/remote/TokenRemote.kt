package co.dasa.data.network.remote

import co.dasa.data.network.api.TokenApi
import com.stac.data.base.remote.RetrofitRemote

class TokenRemote : RetrofitRemote<TokenApi>() {
    override val api: TokenApi
        get() = createApi(TokenApi::class.java)

    suspend fun getNewToken(token: String): String = api.getNewToken(token)
}
