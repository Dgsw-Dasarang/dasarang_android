package co.dasa.dasarang.features.payment.state

import co.dasa.domain.model.payment.GetPaymentData
import co.dasa.domain.model.user.User

data class GetPaymentState(
    val isUpdate: Boolean = false,
    val result: GetPaymentData? = null,
    val error: String = ""
)
