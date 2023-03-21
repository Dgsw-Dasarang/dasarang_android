package co.dasa.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import co.dasa.data.base.remote.BaseDao
import co.dasa.data.database.entity.TokenEntity

@Dao
interface TokenDao : BaseDao<TokenEntity> {

    @Query("SELECT * FROM token_table WHERE idx = 0")
    suspend fun getToken(): TokenEntity

    @Query("DELETE FROM token_table")
    suspend fun deleteToken()
}