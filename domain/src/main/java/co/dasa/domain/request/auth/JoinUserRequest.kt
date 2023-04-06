package co.dasa.domain.request.auth

import java.security.NoSuchAlgorithmException

class JoinUserRequest(
    userId: String,
    password: String,
    address: String,
    number: String,
    birth: String
) {
    var userId: String? = null
    var password: String? = null
    var address: String? = null
    var number: String? = null
    var birth: String? = null

    init {
        try {
            this.userId = userId
            this.password = password
            this.address = address
            this.number = number
            this.birth = birth
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
    }
}
