package co.dasa.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import co.dasa.data.base.remote.BaseDao
import co.dasa.data.database.entity.AccountEntity

@Dao
interface AccountDao : BaseDao<AccountEntity> {

    @Query("Select * FROM account_table WHERE idx = 0")
    suspend fun getAccount(): AccountEntity

    @Query("DELETE FROM account_table")
    suspend fun deleteAccount()
}