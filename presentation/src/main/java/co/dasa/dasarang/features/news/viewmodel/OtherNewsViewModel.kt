package co.dasa.dasarang.features.news.viewmodel

import androidx.lifecycle.viewModelScope
import co.dasa.dasarang.base.BaseViewModel
import co.dasa.dasarang.features.news.state.EducationState
import co.dasa.dasarang.features.news.state.GetCommentState
import co.dasa.dasarang.features.news.state.WriteCommentState
import co.dasa.dasarang.utils.MutableEventFlow
import co.dasa.dasarang.utils.asEventFlow
import co.dasa.domain.usecases.news.GetCommentNews
import co.dasa.domain.usecases.news.NewsUseCases
import co.dasa.domain.usecases.news.WriteCommentNews
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OtherNewsViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : BaseViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    private val _getcommentState = MutableStateFlow(GetCommentState())
    val getcommentState: StateFlow<GetCommentState> = _getcommentState

    private val _writecommentState = MutableStateFlow(WriteCommentState())
    val writecommentState: StateFlow<WriteCommentState> = _writecommentState

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    fun clearWriteCommentState() {
        _writecommentState.value = WriteCommentState(isUpdate = false)
    }

    fun clickWriteComment() {
        event(Event.WriteComment)
    }

    fun writeComment(comment: String, id: Int) {
        newsUseCases.writeCommentNews(WriteCommentNews.Params(id, comment)).divideResult(
            isLoading,
            { _writecommentState.value = WriteCommentState(result = it, isUpdate = true) },
            { _writecommentState.value = WriteCommentState(error = it ?: "댓글 정보를 불러오는데 실패했습니다.") }
        ).launchIn(viewModelScope)
    }

    fun getComment(id: Int, page: Int) {
        newsUseCases.getCommentNews(GetCommentNews.Params(id, page)).divideResult(
            isLoading,
            { _getcommentState.value = GetCommentState(result = it, isUpdate = true) },
            { _getcommentState.value = GetCommentState(error = it ?: "댓글 정보를 불러오는데 실패했습니다.") }
        ).launchIn(viewModelScope)
    }

    sealed class Event {
        object WriteComment: Event()
    }
}