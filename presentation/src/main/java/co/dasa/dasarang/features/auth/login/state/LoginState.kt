package co.dasa.dasarang.features.auth.login.state

data class LoginState(
    val isUpdate: Boolean = false,
    val result: Any? = null,
    val error: String = ""
)
