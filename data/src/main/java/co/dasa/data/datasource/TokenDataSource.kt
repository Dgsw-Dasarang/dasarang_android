package co.dasa.data.datasource

import android.util.Base64
import co.dasa.data.base.BaseDataSource
import co.dasa.data.database.cache.TokenCache
import co.dasa.data.database.entity.TokenEntity
import co.dasa.data.mapper.toEntity
import co.dasa.data.mapper.toModel
import co.dasa.data.network.remote.TokenRemote
import co.dasa.domain.model.token.Token
import org.json.JSONException
import org.json.JSONObject
import javax.inject.Inject

class TokenDataSource @Inject constructor(
    override val remote: TokenRemote,
    override val cache: TokenCache
) : BaseDataSource<TokenRemote, TokenCache> {

    private val PAYLOAD_MEMBER_ID = "memberId"

    suspend fun insertToken(token: Token) = cache.insertToken(token.toEntity())

    suspend fun getToken(): TokenEntity = cache.getToken()

    suspend fun updateNewToken(): TokenEntity =
        getToken()
            .let { tokenEntity -> tokenEntity.toModel() }
            .let { insertNewToken(it) }

    suspend fun deleteToken() = cache.deleteToken()

    private suspend fun insertNewToken(token: Token): TokenEntity =
        remote.getNewToken(token.refreshToken)
            .let { newToken -> TokenEntity(newToken, token.refreshToken) }
            .also { cache.insertToken(it) }

    suspend fun getMyId(): String = getId(getToken().toModel())

    private fun getId(token: Token): String {
        return try {
            val payload = decodedPayloadObject(token.token)
            payload!!.getString(PAYLOAD_MEMBER_ID)
        } catch (ignore: JSONException) {
            throw Throwable("아이디 오류")
        }
    }

    private fun decodedPayloadObject(tokenString: String): JSONObject? {
        return try {
            val split = tokenString.split(".").toTypedArray()
            JSONObject(String(Base64.decode(split[1], Base64.DEFAULT)))
        } catch (ignore: JSONException) {
            null
        }
    }
}
