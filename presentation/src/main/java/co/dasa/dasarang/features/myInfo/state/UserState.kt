package co.dasa.dasarang.features.myInfo.state

import co.dasa.domain.model.user.UserInfo

data class UserState(
    val isUpdate: Boolean = false,
    val result: UserInfo? = null,
    val error: String = ""
)
