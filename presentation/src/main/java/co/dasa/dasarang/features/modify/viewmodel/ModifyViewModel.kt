package co.dasa.dasarang.features.modify.viewmodel

import androidx.lifecycle.viewModelScope
import co.dasa.dasarang.base.BaseViewModel
import co.dasa.dasarang.utils.MutableEventFlow
import co.dasa.dasarang.utils.asEventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ModifyViewModel @Inject constructor() : BaseViewModel() {
    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    fun back() {
        event(Event.Back)
    }

    fun modifyProfile() {
        event(Event.ProfileImage)
    }

    fun search() {
        event(Event.Search)
    }

    fun modify() {
        event(Event.Modify)
    }

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    sealed class Event {
        object Back : Event()

        object ProfileImage : Event()

        object Search : Event()

        object Modify : Event()
    }
}
