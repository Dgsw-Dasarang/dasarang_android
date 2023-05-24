package co.dasa.domain.usecases.payment

import co.dasa.domain.base.UseCase
import co.dasa.domain.model.education.EducationDatas
import co.dasa.domain.model.payment.GetPaymentData
import co.dasa.domain.repository.EducationRepository
import co.dasa.domain.repository.PaymentRepository
import co.dasa.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPayment @Inject constructor(
    private val paymentRepository: PaymentRepository
) : UseCase<Unit, GetPaymentData>() {

    override fun invoke(params: Unit): Flow<Resource<GetPaymentData>> = execute {
        paymentRepository.getPayment()
    }
}
