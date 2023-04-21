package co.dasa.domain.usecases.auth

data class AuthUseCases(
    val login: Login,
    val joinUser: JoinUser,
    val joinOwner: JoinOwner,
    val getUser: GetUser,
    val logout: Logout
)
