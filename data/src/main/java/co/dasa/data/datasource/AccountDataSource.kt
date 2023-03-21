package co.dasa.data.datasource

import co.dasa.data.base.BaseDataSource
import co.dasa.data.database.cache.AccountCache
import co.dasa.data.database.entity.AccountEntity
import javax.inject.Inject

class AccountDataSource @Inject constructor(
    override val remote: Any,
    override val cache: AccountCache
) : BaseDataSource<Any, AccountCache> {

    suspend fun getAccount(): AccountEntity = cache.getAccount()

    suspend fun insertAccount(accountEntity: AccountEntity) = cache.insertAccount(accountEntity)

    suspend fun deleteAccount() = cache.deleteAccount()
}