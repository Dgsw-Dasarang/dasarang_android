package co.dasa.dasarang.features.news.viewmodel

import co.dasa.dasarang.base.BaseViewModel
import co.dasa.dasarang.features.plaza.viewmodel.PlazaViewModel
import kr.co.moreversal.grabthathoe.utils.MutableEventFlow
import kr.co.moreversal.grabthathoe.utils.asEventFlow
import javax.inject.Inject

class DetailViewModel @Inject constructor() : BaseViewModel() {

    private val _eventFlow = MutableEventFlow<PlazaViewModel.Event>()
    val eventFlow = _eventFlow.asEventFlow()
}