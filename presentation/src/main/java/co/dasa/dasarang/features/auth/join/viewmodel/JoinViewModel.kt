package co.dasa.dasarang.features.auth.join.viewmodel

import androidx.lifecycle.viewModelScope
import co.dasa.dasarang.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.co.moreversal.grabthathoe.utils.MutableEventFlow
import kr.co.moreversal.grabthathoe.utils.asEventFlow
import javax.inject.Inject

@HiltViewModel
class JoinViewModel @Inject constructor() : BaseViewModel() {

    private val _eventFlow = MutableEventFlow<JoinViewModel.Event>()
    val eventFlow = _eventFlow.asEventFlow()

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    sealed class Event {
        data class Join(val joinNum: Int) : Event()
    }
}