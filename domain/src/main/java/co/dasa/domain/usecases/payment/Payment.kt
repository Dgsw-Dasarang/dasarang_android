package co.dasa.domain.usecases.payment

import co.dasa.domain.base.UseCase
import co.dasa.domain.model.education.EducationDatas
import co.dasa.domain.repository.EducationRepository
import co.dasa.domain.repository.PaymentRepository
import co.dasa.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Payment @Inject constructor(
    private val paymentRepository: PaymentRepository
) : UseCase<Payment.Params, Unit>() {

    override fun invoke(params: Params): Flow<Resource<Unit>> = execute {
        paymentRepository.payment(params)
    }

    data class Params(
        val authKey: String,
        val customerKey: String
    )
}
