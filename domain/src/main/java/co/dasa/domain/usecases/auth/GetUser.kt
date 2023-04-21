package co.dasa.domain.usecases.auth

import co.dasa.domain.base.UseCase
import co.dasa.domain.model.user.User
import co.dasa.domain.model.user.UserInfo
import co.dasa.domain.repository.AuthRepository
import co.dasa.domain.request.auth.LoginRequest
import co.dasa.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUser @Inject constructor(
    private val authRepository: AuthRepository
) : UseCase<Unit, UserInfo>() {

    override fun invoke(params: Unit): Flow<Resource<UserInfo>> = execute {
        authRepository.getUser()
    }
}
