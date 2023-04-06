package co.dasa.domain.usecases.auth

import co.dasa.domain.base.UseCase
import co.dasa.domain.repository.AuthRepository
import co.dasa.domain.request.auth.JoinOwnerRequest
import co.dasa.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class JoinOwner @Inject constructor(
    private val authRepository: AuthRepository
) : UseCase<JoinOwner.Params, Any>() {
    override operator fun invoke(params: Params): Flow<Resource<Any>> = execute {
        authRepository.joinOwner(
            JoinOwnerRequest(
                params.id,
                params.pw,
                params.address,
                params.number,
                params.birth,
                params.ownerNumber,
                params.email
            )
        )
    }

    data class Params(
        var id: String,
        var pw: String,
        var address: String,
        var number: String,
        var birth: String,
        var ownerNumber: String,
        var email: String
    )
}
