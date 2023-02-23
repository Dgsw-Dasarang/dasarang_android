package co.dasa.dasarang.features.modify.viewmodel

import co.dasa.dasarang.base.BaseViewModel
import co.dasa.dasarang.features.myInfo.viewmodel.MyInfoViewModel
import kr.co.moreversal.grabthathoe.utils.MutableEventFlow
import kr.co.moreversal.grabthathoe.utils.asEventFlow
import javax.inject.Inject

class ModifyViewModel @Inject constructor() : BaseViewModel() {
    private val _eventFlow = MutableEventFlow<MyInfoViewModel.Event>()
    val eventFlow = _eventFlow.asEventFlow()

}