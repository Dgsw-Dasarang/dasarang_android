package co.dasa.data.mapper

import co.dasa.data.network.response.User
import co.dasa.domain.model.user.UserInfo

fun User.toModel(): UserInfo = UserInfo(
    address = this.address,
    birth = this.birth,
    email = this.email ?: "",
    id = this.id,
    number = this.number,
    ownerNumber = this.ownerNumber ?: "",
    type = this.type,
    userId = this.userId
)