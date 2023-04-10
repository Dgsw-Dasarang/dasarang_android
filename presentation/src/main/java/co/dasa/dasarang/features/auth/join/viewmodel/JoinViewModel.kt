package co.dasa.dasarang.features.auth.join.viewmodel

import androidx.lifecycle.viewModelScope
import co.dasa.dasarang.base.BaseViewModel
import co.dasa.dasarang.features.auth.join.state.JoinState
import co.dasa.domain.usecases.auth.AuthUseCases
import co.dasa.domain.usecases.auth.JoinOwner
import co.dasa.domain.usecases.auth.JoinUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import kr.co.moreversal.grabthathoe.utils.MutableEventFlow
import kr.co.moreversal.grabthathoe.utils.asEventFlow
import javax.inject.Inject

@HiltViewModel
class JoinViewModel @Inject constructor(
    private val authUseCases: AuthUseCases
) : BaseViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    private val _joinState = MutableStateFlow(JoinState())
    val joinState: StateFlow<JoinState> = _joinState

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    fun checkAgree() {
        event(Event.CheckAgree)
    }
    fun moveAgree() {
        event(Event.MoveAgree)
    }
    fun search() {
        event(Event.Search)
    }

    fun join() {
        event(Event.Join)
    }

    fun businessJoin() {
        event(Event.BusinessJoin)
    }

    fun userJoin() {
        event(Event.UserJoin)
    }

    fun moveLogin() {
        event(Event.MoveLogin)
    }

    fun doUserJoin(id: String, pw: String, address: String, number: String, birth: String) {
        authUseCases.joinUser(JoinUser.Params(id, pw, address, number, birth)).divideResult(
            isLoading,
            { _joinState.value = JoinState(result = it, isUpdate = true) },
            { _joinState.value = JoinState(error = it ?: "회원가입에 실패하였습니다.") }
        ).launchIn(viewModelScope)
    }

    fun doOwnerJoin(id: String, pw: String, address: String, number: String, birth: String, ownerNumber: String, email: String) {
        authUseCases.joinOwner(JoinOwner.Params(id, pw, address, number, birth, ownerNumber, email)).divideResult(
            isLoading,
            { _joinState.value = JoinState(result = it, isUpdate = true) },
            { _joinState.value = JoinState(error = it ?: "회원가입에 실패하였습니다.") }
        ).launchIn(viewModelScope)
    }

    sealed class Event {

        object CheckAgree : Event()
        object MoveAgree : Event()
        object Join : Event()

        object Search : Event()

        object BusinessJoin : Event()

        object UserJoin : Event()

        object MoveLogin : Event()
    }
}
