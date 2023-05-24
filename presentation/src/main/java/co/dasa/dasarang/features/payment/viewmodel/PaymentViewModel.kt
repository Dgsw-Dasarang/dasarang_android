package co.dasa.dasarang.features.payment.viewmodel

import androidx.lifecycle.viewModelScope
import co.dasa.dasarang.base.BaseViewModel
import co.dasa.dasarang.features.auth.login.state.LoginState
import co.dasa.dasarang.features.payment.state.PaymentState
import co.dasa.dasarang.utils.MutableEventFlow
import co.dasa.dasarang.utils.asEventFlow
import co.dasa.domain.usecases.payment.Payment
import co.dasa.domain.usecases.payment.PaymentUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(
    private val paymentUseCases: PaymentUseCases
) : BaseViewModel() {
    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    private val _paymentState = MutableStateFlow(PaymentState())
    val paymentState: StateFlow<PaymentState> = _paymentState

    fun payment(authKey: String, customerKey: String) {
        paymentUseCases.payment(Payment.Params(authKey, customerKey)).divideResult(
            isLoading,
            { _paymentState.value = PaymentState(result = it, isUpdate = true) },
            { _paymentState.value = PaymentState(error = it ?: "정기결제에 실패하였습니다.") }
        ).launchIn(viewModelScope)
    }

    fun back() {
        event(Event.Back)
    }

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    sealed class Event {
        object Back : Event()
    }
}