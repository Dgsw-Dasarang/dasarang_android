package co.dasa.domain.usecases.token

data class TokenUseCases(
    val deleteToken: DeleteToken,
    val getToken: GetToken,
    val updateNewToken: UpdateNewToken,
)