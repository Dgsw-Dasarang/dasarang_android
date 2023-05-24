package co.dasa.domain.usecases.payment

data class PaymentUseCases(
    val payment: Payment,
    val getPayment: GetPayment,
    val canclePayment: CanclePayment
)
