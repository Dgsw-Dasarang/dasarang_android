package co.dasa.domain.usecases.payment

import co.dasa.domain.base.UseCase
import co.dasa.domain.model.education.EducationDatas
import co.dasa.domain.model.payment.CanclePaymentData
import co.dasa.domain.model.payment.GetPaymentData
import co.dasa.domain.repository.EducationRepository
import co.dasa.domain.repository.PaymentRepository
import co.dasa.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CanclePayment @Inject constructor(
    private val paymentRepository: PaymentRepository
) : UseCase<CanclePayment.Params, CanclePaymentData>() {

    override fun invoke(params: Params): Flow<Resource<CanclePaymentData>> = execute {
        paymentRepository.canclePayment(params)
    }

    data class Params(
        val cancelReason: String
    )
}
