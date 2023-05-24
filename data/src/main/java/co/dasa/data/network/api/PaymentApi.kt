package co.dasa.data.network.api

import co.dasa.data.network.url.DasaUrl
import co.dasa.domain.model.education.EducationDatas
import co.dasa.domain.model.payment.CanclePaymentData
import co.dasa.domain.model.payment.GetPaymentData
import co.dasa.domain.usecases.payment.CanclePayment
import co.dasa.domain.usecases.payment.Payment
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface PaymentApi {

    @POST(DasaUrl.PAYMENT)
    suspend fun payment(
        @Header("Authorization") token: String,
        @Body params: Payment.Params
    )

    @POST(DasaUrl.CANCLE_PAYMENT)
    suspend fun canclePayment(
        @Header("Authorization") token: String,
        @Body params: CanclePayment.Params
    ): CanclePaymentData

    @GET(DasaUrl.GET_PAYMENT)
    suspend fun getPayment(
        @Header("Authorization") token: String
    ): GetPaymentData
}
