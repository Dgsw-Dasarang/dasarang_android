package co.dasa.dasarang.features.news.viewmodel

import androidx.lifecycle.viewModelScope
import co.dasa.dasarang.base.BaseViewModel
import co.dasa.dasarang.features.news.state.EducationState
import co.dasa.domain.usecases.education.EducationUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import kr.co.moreversal.grabthathoe.utils.MutableEventFlow
import kr.co.moreversal.grabthathoe.utils.asEventFlow
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val educationUseCases: EducationUseCases
) : BaseViewModel() {
    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    private val _educationState = MutableStateFlow(EducationState())
    val educationState: StateFlow<EducationState> = _educationState

    fun showToast() {
        event(Event.ShowToast("테스트 토스트"))
    }

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    fun getData(page: Int) {
        educationUseCases.getEducationAll(page).divideResult(
            isLoading,
            { _educationState.value = EducationState(result = it, isUpdate = true) },
            { _educationState.value = EducationState(error = it ?: "학원 정보를 불러오는데 실패했습니다.") }
        ).launchIn(viewModelScope)
    }

    sealed class Event {
        data class ShowToast(val text: String) : Event()
    }
}
