package co.dasa.data.datasource

import co.dasa.data.base.BaseDataSource
import co.dasa.data.network.remote.EducationRemote
import co.dasa.data.network.remote.PaymentRemote
import co.dasa.domain.model.education.EducationDatas
import co.dasa.domain.usecases.payment.CanclePayment
import co.dasa.domain.usecases.payment.Payment
import javax.inject.Inject

class PaymentDataSource @Inject constructor(
    override val remote: PaymentRemote,
    override val cache: Any
) : BaseDataSource<PaymentRemote, Any> {

    suspend fun payment(token: String, params: Payment.Params) = remote.payment(token, params)

    suspend fun getPayment(token: String) = remote.getPayment(token)

    suspend fun canclePayment(token: String, params: CanclePayment.Params) = remote.canclePayment(token, params)
}
