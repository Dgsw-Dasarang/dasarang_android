package co.dasa.dasarang.features.myInfo.viewmodel

import androidx.lifecycle.viewModelScope
import co.dasa.dasarang.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.co.moreversal.grabthathoe.utils.MutableEventFlow
import kr.co.moreversal.grabthathoe.utils.asEventFlow
import javax.inject.Inject

@HiltViewModel
class MyInfoViewModel @Inject constructor() : BaseViewModel() {
    private val _eventFlow = MutableEventFlow<Event>()
    private var logoutCnt = 0
    val eventFlow = _eventFlow.asEventFlow()

    fun showToast() {
        event(Event.ShowToast("테스트 토스트"))
    }

    fun logout() {
        event(Event.Logout(++logoutCnt))
        logoutCnt = 0
    }

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    sealed class Event {
        data class ShowToast(val text: String) : Event()

        data class Logout(val logout: Int) : Event()
    }
}