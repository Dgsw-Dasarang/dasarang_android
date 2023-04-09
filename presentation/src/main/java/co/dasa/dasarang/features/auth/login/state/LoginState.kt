package co.dasa.dasarang.features.auth.login.state

import co.dasa.domain.model.user.User

data class LoginState(
    val isUpdate: Boolean = false,
    val result: User? = null,
    val error: String = ""
)
