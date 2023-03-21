package co.dasa.data.network.response

data class LoginData(
    val accessToken: String,
    val name: String,
    val refreshToken: String,
    val type: String
)