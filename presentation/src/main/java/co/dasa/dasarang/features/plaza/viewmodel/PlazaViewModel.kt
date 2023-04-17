package co.dasa.dasarang.features.plaza.viewmodel

import androidx.lifecycle.viewModelScope
import co.dasa.dasarang.base.BaseViewModel
import co.dasa.dasarang.utils.MutableEventFlow
import co.dasa.dasarang.utils.asEventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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

    fun moveScreenOwner(count: Int) {
        event(Event.MoveScreenOwner(count))
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

        data class MoveScreenOwner(val count: Int) : Event()

        object Login : Event()
    }
}
