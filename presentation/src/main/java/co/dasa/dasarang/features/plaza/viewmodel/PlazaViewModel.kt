package co.dasa.dasarang.features.plaza.viewmodel

import androidx.lifecycle.viewModelScope
import co.dasa.dasarang.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.co.moreversal.grabthathoe.utils.MutableEventFlow
import kr.co.moreversal.grabthathoe.utils.asEventFlow
import javax.inject.Inject

@HiltViewModel
class PlazaViewModel @Inject constructor() : BaseViewModel() {
    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    fun showToast() {
        event(Event.ShowToast("테스트 토스트"))
    }

    fun moveScreen(cnt: Int) {
        event(Event.MoveScreen(cnt))
    }

    fun login() {
        event(Event.Login)
    }

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    sealed class Event {
        data class ShowToast(val text: String) : Event()

        data class MoveScreen(val cnt: Int) : Event()

        object Login : Event()
    }
}
