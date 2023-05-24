package co.dasa.dasarang.features.payment.state

import co.dasa.domain.model.user.User

data class PaymentState(
    val isUpdate: Boolean = false,
    val result: Unit? = null,
    val error: String = ""
)
