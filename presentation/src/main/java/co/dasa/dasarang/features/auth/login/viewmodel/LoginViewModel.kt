package co.dasa.dasarang.features.auth.login.viewmodel

import androidx.lifecycle.viewModelScope
import co.dasa.dasarang.base.BaseViewModel
import co.dasa.dasarang.features.myInfo.viewmodel.MyInfoViewModel
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
        event(Event.Login(1))
    }

    fun join() {
        event(Event.Join(1))
    }

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    sealed class Event {
        data class Login(val loginNum: Int) : Event()

        data class Join(val joinNum: Int) : Event()
    }
}