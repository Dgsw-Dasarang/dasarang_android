package co.dasa.dasarang.features.auth.join.state

data class JoinState(
    val isUpdate: Boolean = false,
    val result: Any? = null,
    val error: String = ""
)
