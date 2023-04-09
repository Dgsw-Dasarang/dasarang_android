package co.dasa.domain.usecases.auth

import co.dasa.domain.base.UseCase
import co.dasa.domain.model.user.User
import co.dasa.domain.repository.AuthRepository
import co.dasa.domain.request.auth.LoginRequest
import co.dasa.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Login @Inject constructor(
    private val authRepository: AuthRepository
) : UseCase<Login.Params, User>() {

    override fun invoke(params: Params): Flow<Resource<User>> = execute {
        authRepository.login(LoginRequest(params.id, params.pw, params.encryption))
    }

    data class Params(
        val id: String,
        val pw: String,
        val encryption: Boolean = false
    )
}
