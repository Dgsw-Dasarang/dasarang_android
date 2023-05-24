package co.dasa.domain.repository

import co.dasa.domain.model.payment.CanclePaymentData
import co.dasa.domain.model.payment.GetPaymentData
import co.dasa.domain.model.user.User
import co.dasa.domain.model.user.UserInfo
import co.dasa.domain.request.auth.JoinOwnerRequest
import co.dasa.domain.request.auth.JoinUserRequest
import co.dasa.domain.request.auth.LoginRequest
import co.dasa.domain.usecases.payment.CanclePayment
import co.dasa.domain.usecases.payment.Payment

interface PaymentRepository {

    suspend fun payment(params: Payment.Params)

    suspend fun getPayment() : GetPaymentData

    suspend fun canclePayment(params: CanclePayment.Params) : CanclePaymentData
}
