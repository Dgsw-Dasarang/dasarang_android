package co.dasa.dasarang.features.myInfo.viewmodel

import androidx.lifecycle.viewModelScope
import co.dasa.dasarang.base.BaseViewModel
import co.dasa.dasarang.features.myInfo.state.AcademyNumState
import co.dasa.dasarang.features.myInfo.state.AcademyState
import co.dasa.dasarang.features.myInfo.state.UserState
import co.dasa.dasarang.utils.MutableEventFlow
import co.dasa.dasarang.utils.asEventFlow
import co.dasa.domain.usecases.auth.AuthUseCases
import co.dasa.domain.usecases.education.EducationUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyAcademyViewModel @Inject constructor(
    private val educationUseCases: EducationUseCases,
    private val authUseCases: AuthUseCases
) : BaseViewModel() {
    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    private val _academyState = MutableStateFlow(AcademyState())
    val academyState: StateFlow<AcademyState> = _academyState

    private val _academyNumState = MutableStateFlow(AcademyNumState())
    val academyNumState: StateFlow<AcademyNumState> = _academyNumState

    private fun event(event: Event) = viewModelScope.launch {
        _eventFlow.emit(event)
    }

    fun getAcademyData(num: String) {
        _academyState.value = AcademyState(error = "")
        educationUseCases.getEducationByNum(num).divideResult(
            isLoading,
            { _academyState.value = AcademyState(result = it, isUpdate = true) },
            { _academyState.value = AcademyState(error = it ?: "정보를 가져오는 데에 실패하였습니다") }
        ).launchIn(viewModelScope)
    }

    fun getAdminData() {
        authUseCases.getUser(Unit).divideResult(
            isLoading,
            { _academyNumState.value = AcademyNumState(result = it!!.ownerNumber, isUpdate = true) },
            { _academyNumState.value = AcademyNumState(error = it ?: "정보를 가져오는 데에 실패하였습니다") }
        ).launchIn(viewModelScope)
    }

    fun back() {
        event(Event.Back)
    }

    sealed class Event {
        object Back : Event()
    }
}