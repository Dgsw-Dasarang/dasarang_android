package co.dasa.dasarang.features.news.viewmodel

import androidx.lifecycle.viewModelScope
import co.dasa.dasarang.base.BaseViewModel
import co.dasa.dasarang.features.news.state.BoardState
import co.dasa.dasarang.features.news.state.EducationState
import co.dasa.dasarang.features.news.state.NewsState
import co.dasa.dasarang.utils.MutableEventFlow
import co.dasa.dasarang.utils.asEventFlow
import co.dasa.domain.usecases.education.EducationUseCases
import co.dasa.domain.usecases.news.GetNewsColumn
import co.dasa.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val educationUseCases: EducationUseCases,
    private val newsUseCases: NewsUseCases
) : BaseViewModel() {
    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    private val _educationState = MutableStateFlow(EducationState())
    val educationState: StateFlow<EducationState> = _educationState

    private val _newsState = MutableStateFlow(NewsState())
    val newsState: StateFlow<NewsState> = _newsState

    fun showToast() {
        event(Event.ShowToast("테스트 토스트"))
    }

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    fun getEduData(page: Int) {
        educationUseCases.getEducationAll(page).divideResult(
            isLoading,
            { _educationState.value = EducationState(result = it, isUpdate = true) },
            { _educationState.value = EducationState(error = it ?: "학원 정보를 불러오는데 실패했습니다.") }
        ).launchIn(viewModelScope)
    }

    fun getNewsData(page: Int, category: String, content: String) {
        newsUseCases.getNewsColumn(GetNewsColumn.Params(page, category, content)).divideResult(
            isLoading,
            { _newsState.value = NewsState(result = it, isUpdate = true) },
            { _newsState.value = NewsState(error = it ?: "소식을 불러오는데 실패했습니다.") }
        ).launchIn(viewModelScope)
    }

    sealed class Event {
        data class ShowToast(val text: String) : Event()
    }
}
