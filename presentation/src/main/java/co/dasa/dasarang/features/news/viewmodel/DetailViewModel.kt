package co.dasa.dasarang.features.news.viewmodel

import androidx.lifecycle.viewModelScope
import co.dasa.dasarang.base.BaseViewModel
import co.dasa.dasarang.features.plaza.viewmodel.PlazaViewModel
import kotlinx.coroutines.launch
import kr.co.moreversal.grabthathoe.utils.MutableEventFlow
import kr.co.moreversal.grabthathoe.utils.asEventFlow
import javax.inject.Inject

class DetailViewModel @Inject constructor() : BaseViewModel() {

    private val _eventFlow = MutableEventFlow<DetailViewModel.Event>()
    val eventFlow = _eventFlow.asEventFlow()

    fun back() {
        event(Event.Back)
    }

    private fun event(event: DetailViewModel.Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    sealed class Event{
        object Back : Event()
    }
}