package co.dasa.dasarang.features.myInfo.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import co.dasa.dasarang.base.BaseViewModel
import co.dasa.dasarang.features.auth.login.state.LoginState
import co.dasa.dasarang.features.myInfo.state.UserState
import co.dasa.dasarang.utils.MutableEventFlow
import co.dasa.dasarang.utils.asEventFlow
import co.dasa.domain.usecases.auth.AuthUseCases
import co.dasa.domain.usecases.auth.Login
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyInfoViewModel @Inject constructor(
    private val authUseCases: AuthUseCases
) : BaseViewModel() {
    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    private val _userState = MutableStateFlow(UserState())
    val userState: StateFlow<UserState> = _userState

    fun showToast() {
        event(Event.ShowToast("테스트 토스트"))
    }

    fun logout() {
        event(Event.Logout)
    }

    fun doLogout() {
        authUseCases.logout(Unit).launchIn(viewModelScope)
    }

    fun modify() {
        event(Event.Modify)
    }

    fun moveInfo(cnt: Int) {
        event(Event.MoveInfo(cnt))
    }

    fun getUserInfo() {
        _userState.value = UserState(error = "")
        authUseCases.getUser(Unit).divideResult(
            isLoading,
            { _userState.value = UserState(result = it, isUpdate = true) },
            { _userState.value = UserState(error = it ?: "정보를 가져오는 데에 실패하였습니다") }
        ).launchIn(viewModelScope)
    }

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    sealed class Event {
        data class ShowToast(val text: String) : Event()

        data class MoveInfo(val cnt: Int) : Event()
        object Logout : Event()

        object Modify : Event()
    }
}
