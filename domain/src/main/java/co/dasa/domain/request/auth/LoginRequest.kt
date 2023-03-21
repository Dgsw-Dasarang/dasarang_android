package co.dasa.domain.request.auth

import co.dasa.domain.util.Utils
import java.security.NoSuchAlgorithmException

class LoginRequest(
    userId: String,
    password: String,
    encryption: Boolean = true
) {
    var userId: String? = null
    var password: String? = null

    init {
        try {
            this.userId = userId
            this.password = if (encryption) Utils.encryptSHA512(password) else password
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
    }
}