package co.dasa.data.database.cache

import android.app.Application
import co.dasa.data.base.BaseCache
import co.dasa.data.database.dao.TokenDao
import co.dasa.data.database.entity.TokenEntity
import javax.inject.Inject

class TokenCache @Inject constructor(application: Application) : BaseCache(application) {
    private val tokenDao: TokenDao = database.tokenDao()
    suspend fun insertToken(tokenEntity: TokenEntity) = tokenDao.insert(tokenEntity)
    suspend fun deleteToken() = tokenDao.deleteToken()
    suspend fun getToken(): TokenEntity = tokenDao.getToken()
}