package co.dasa.dasarang.features.news.fragment

import androidx.fragment.app.viewModels
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentInfoBinding
import co.dasa.dasarang.features.news.viewmodel.InfoViewModel

class InfoFragment : BaseFragment<FragmentInfoBinding, InfoViewModel>(R.layout.fragment_info) {

    override val viewModel: InfoViewModel by viewModels()

    override fun start() {
        //TODO info 연결해서 데이터 넣어놓기
    }

}