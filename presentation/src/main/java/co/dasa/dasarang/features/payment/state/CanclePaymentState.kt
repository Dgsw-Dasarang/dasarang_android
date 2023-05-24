package co.dasa.dasarang.features.payment.state

import co.dasa.domain.model.payment.CanclePaymentData
import co.dasa.domain.model.payment.GetPaymentData
import co.dasa.domain.model.user.User

data class CanclePaymentState(
    val isUpdate: Boolean = false,
    val result: CanclePaymentData? = null,
    val error: String = ""
)
