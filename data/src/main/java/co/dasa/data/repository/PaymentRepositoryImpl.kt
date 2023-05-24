package co.dasa.data.repository

import android.util.Log
import co.dasa.data.database.entity.AccountEntity
import co.dasa.data.datasource.AccountDataSource
import co.dasa.data.datasource.AuthDataSource
import co.dasa.data.datasource.PaymentDataSource
import co.dasa.data.datasource.TokenDataSource
import co.dasa.data.mapper.toModel
import co.dasa.domain.model.payment.CanclePaymentData
import co.dasa.domain.model.payment.GetPaymentData
import co.dasa.domain.model.token.Token
import co.dasa.domain.model.user.User
import co.dasa.domain.model.user.UserInfo
import co.dasa.domain.repository.AuthRepository
import co.dasa.domain.repository.PaymentRepository
import co.dasa.domain.request.auth.JoinOwnerRequest
import co.dasa.domain.request.auth.JoinUserRequest
import co.dasa.domain.request.auth.LoginRequest
import co.dasa.domain.usecases.payment.CanclePayment
import co.dasa.domain.usecases.payment.Payment
import javax.inject.Inject

class PaymentRepositoryImpl @Inject constructor(
    private val paymentDataSource: PaymentDataSource,
    private val tokenDataSource: TokenDataSource
) : PaymentRepository {

    override suspend fun payment(params: Payment.Params) {
        return paymentDataSource.payment(tokenDataSource.getToken().token, params)
    }

    override suspend fun getPayment(): GetPaymentData {
        return paymentDataSource.getPayment(tokenDataSource.getToken().token)
    }

    override suspend fun canclePayment(params: CanclePayment.Params): CanclePaymentData {
        return paymentDataSource.canclePayment(tokenDataSource.getToken().token, params)
    }
}
