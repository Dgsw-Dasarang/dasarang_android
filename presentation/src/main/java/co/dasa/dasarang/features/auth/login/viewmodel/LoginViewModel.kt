package co.dasa.dasarang.features.auth.login.viewmodel

import androidx.lifecycle.viewModelScope
import co.dasa.dasarang.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.co.moreversal.grabthathoe.utils.MutableEventFlow
import kr.co.moreversal.grabthathoe.utils.asEventFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : BaseViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

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
