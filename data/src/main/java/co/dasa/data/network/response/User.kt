package co.dasa.data.network.response

data class User(
    val address: String,
    val birth: String,
    val email: String?,
    val id: Int,
    val number: String,
    val ownerNumber: String?,
    val type: String,
    val userId: String
)