package co.dasa.dasarang.features.news.fragment

import androidx.fragment.app.viewModels
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentBoardBinding
import co.dasa.dasarang.features.news.viewmodel.BoardViewModel
import co.dasa.domain.model.education.EducationData

class BoardFragment : BaseFragment<FragmentBoardBinding, BoardViewModel>(R.layout.fragment_board) {

    override val viewModel: BoardViewModel by viewModels()

    override fun start() {
        val data = arguments?.getSerializable("data") as EducationData
        data.academyNumber
        // TODO 리사이클러 어뎁터 만들고 연결하기
    }
}
