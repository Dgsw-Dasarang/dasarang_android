package co.dasa.dasarang.features.news.viewmodel

import androidx.lifecycle.viewModelScope
import co.dasa.dasarang.base.BaseViewModel
import co.dasa.dasarang.features.auth.login.state.LoginState
import co.dasa.dasarang.utils.MutableEventFlow
import co.dasa.dasarang.utils.asEventFlow
import co.dasa.domain.usecases.auth.Login
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class BoardViewModel @Inject constructor() : BaseViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    fun doData(page: Int, num: String) {
        authUseCases.login(Login.Params()).divideResult(
            isLoading,
            { _loginState.value = LoginState(result = it, isUpdate = true) },
            { _loginState.value = LoginState(error = it ?: "로그인에 실패하였습니다.") }
        ).launchIn(viewModelScope)
    }

    sealed class Event
}
