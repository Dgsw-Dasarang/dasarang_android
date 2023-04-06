package co.dasa.domain.request.auth

import java.security.NoSuchAlgorithmException

class JoinOwnerRequest(
    userId: String,
    password: String,
    address: String,
    number: String,
    birth: String,
    ownerNumber: String,
    email: String
) {
    var userId: String? = null
    var password: String? = null
    var address: String? = null
    var number: String? = null
    var birth: String? = null
    var ownerNumber: String? = null
    var email: String? = null

    init {
        try {
            this.userId = userId
            this.password = password
            this.address = address
            this.number = number
            this.birth = birth
            this.ownerNumber = ownerNumber
            this.email = email
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
    }
}
