package co.dasa.data.network.remote

import co.dasa.data.network.api.EducationApi
import co.dasa.data.base.remote.RetrofitRemote
import co.dasa.data.network.api.PaymentApi
import co.dasa.domain.model.education.EducationDatas
import co.dasa.domain.model.payment.CanclePaymentData
import co.dasa.domain.model.payment.GetPaymentData
import co.dasa.domain.usecases.payment.CanclePayment
import co.dasa.domain.usecases.payment.Payment

class PaymentRemote : RetrofitRemote<PaymentApi>() {
    override val api: PaymentApi
        get() = createApi(PaymentApi::class.java)

    suspend fun payment(token: String, params: Payment.Params) {
        return api.payment("Bearer $token", params)
    }

    suspend fun getPayment(token: String): GetPaymentData {
        return api.getPayment("Bearer $token")
    }

    suspend fun canclePayment(token: String, params: CanclePayment.Params): CanclePaymentData {
        return api.canclePayment("Bearer $token", params)
    }
}
