package co.dasa.dasarang.features.news.viewmodel

import androidx.lifecycle.viewModelScope
import co.dasa.dasarang.base.BaseViewModel
import co.dasa.dasarang.features.news.state.BoardState
import co.dasa.dasarang.utils.MutableEventFlow
import co.dasa.dasarang.utils.asEventFlow
import co.dasa.domain.usecases.board.EduBoardUseCases
import co.dasa.domain.usecases.board.GetBoardData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BoardViewModel @Inject constructor(
    val boardUseCases: EduBoardUseCases
) : BaseViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    private val _boardState = MutableStateFlow(BoardState())
    val boardState: StateFlow<BoardState> = _boardState

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    fun doData(page: Int, num: String) {
        boardUseCases.getBoardData(GetBoardData.Params(page, 10, num)).divideResult(
            isLoading,
            { _boardState.value = BoardState(result = it, isUpdate = true) },
            { _boardState.value = BoardState(error = it ?: "데이터를 가져오는 데에 실패하였습니다.") }
        ).launchIn(viewModelScope)
    }

    sealed class Event
}
