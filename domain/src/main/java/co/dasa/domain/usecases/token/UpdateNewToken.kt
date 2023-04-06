package co.dasa.domain.usecases.token

import co.dasa.domain.model.token.Token
import co.dasa.domain.repository.TokenRepository
import javax.inject.Inject

class UpdateNewToken @Inject constructor(
    val repository: TokenRepository
) {
    suspend operator fun invoke(): Token = repository.updateNewToken()
}
