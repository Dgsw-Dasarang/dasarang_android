package co.dasa.dasarang.features.news.viewmodel

import androidx.lifecycle.viewModelScope
import co.dasa.dasarang.base.BaseViewModel
import co.dasa.dasarang.utils.MutableEventFlow
import co.dasa.dasarang.utils.asEventFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class BoardViewModel @Inject constructor() : BaseViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    sealed class Event
}
