package co.dasa.data.mapper

import co.dasa.data.database.entity.TokenEntity
import co.dasa.domain.model.token.Token

fun TokenEntity?.toModel(): Token = Token(
    token = this?.token ?: "",
    refreshToken = this?.refreshToken ?: ""
)

fun Token.toEntity(): TokenEntity = TokenEntity(
    idx = 0,
    token = this.token,
    refreshToken = this.refreshToken
)
