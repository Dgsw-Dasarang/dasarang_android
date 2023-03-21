package co.dasa.domain.usecases.token

import co.dasa.domain.repository.TokenRepository
import javax.inject.Inject

class DeleteToken @Inject constructor(
    val repository: TokenRepository
) {
    suspend operator fun invoke() = repository.deleteToken()
}