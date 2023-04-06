package co.dasa.dasarang.features.auth.login.viewmodel

import androidx.lifecycle.viewModelScope
import co.dasa.dasarang.base.BaseViewModel
import co.dasa.dasarang.features.auth.login.state.LoginState
import co.dasa.domain.usecases.auth.AuthUseCases
import co.dasa.domain.usecases.auth.Login
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import kr.co.moreversal.grabthathoe.utils.MutableEventFlow
import kr.co.moreversal.grabthathoe.utils.asEventFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authUseCases: AuthUseCases
) : BaseViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    private val _loginState = MutableStateFlow(LoginState())
    val loginState: StateFlow<LoginState> = _loginState

    fun doLogin(id: String, pw: String) {
        authUseCases.login(Login.Params(id, pw)).divideResult(
            isLoading,
            { _loginState.value = LoginState(result = it, isUpdate = true) },
            { _loginState.value = LoginState(error = it ?: "로그인에 실패하였습니다.") }
        ).launchIn(viewModelScope)
    }

    fun login() {
        event(Event.Login)
    }

    fun join() {
        event(Event.Join)
    }

    fun showToast() {
        event(Event.ShowToast("준비 중인 기능입니다"))
    }

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    sealed class Event {
        object Login : Event()

        object Join : Event()

        data class ShowToast(val text: String) : Event()
    }
}
