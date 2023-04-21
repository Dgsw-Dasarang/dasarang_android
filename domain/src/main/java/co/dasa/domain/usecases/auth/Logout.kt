package co.dasa.domain.usecases.auth

import android.util.Log
import co.dasa.domain.base.UseCase
import co.dasa.domain.model.user.User
import co.dasa.domain.model.user.UserInfo
import co.dasa.domain.repository.AuthRepository
import co.dasa.domain.request.auth.LoginRequest
import co.dasa.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Logout @Inject constructor(
    private val authRepository: AuthRepository
) : UseCase<Unit, Unit>() {

    override fun invoke(params: Unit): Flow<Resource<Unit>> = execute {
        authRepository.logout()
    }
}
