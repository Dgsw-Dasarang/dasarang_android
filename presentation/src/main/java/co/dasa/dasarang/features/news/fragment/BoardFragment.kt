package co.dasa.dasarang.features.news.fragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentBoardBinding
import co.dasa.dasarang.extensions.shortToast
import co.dasa.dasarang.features.news.adapter.BoardAdapter
import co.dasa.dasarang.features.news.adapter.EduNewsAdapter
import co.dasa.dasarang.features.news.viewmodel.BoardViewModel
import co.dasa.domain.model.education.BoardData
import co.dasa.domain.model.education.EducationData
import co.dasa.domain.model.education.Image
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BoardFragment : BaseFragment<FragmentBoardBinding, BoardViewModel>(R.layout.fragment_board) {

    override val viewModel: BoardViewModel by viewModels()
    private lateinit var boardAdapter: BoardAdapter

    override fun start() {
        collectBoardState()
        setBoardAdapter()
    }

    private fun collectBoardState() {
        with(viewModel) {
            lifecycleScope.launchWhenStarted {
                boardState.collect { state ->
                    if (state.isUpdate) {
                        boardAdapter.submitList(state.result!!.list)
                    } else if (state.error.isNotBlank()) {
                        boardAdapter.submitList(mutableListOf(BoardData("", "", listOf(Image("", "")), 0, "게시물이 비어있습니다."), BoardData("", "", listOf(Image("", "")), 0, "게시물이 비어있습니다."), BoardData("", "", listOf(Image("", "")), 0, "게시물이 비어있습니다.")))
                        //shortToast(state.error)
                    }
                }
            }
        }
    }

    private fun setBoardAdapter() {
        boardAdapter = BoardAdapter()
        binding.recyclerBoard.adapter = boardAdapter
        val data = arguments?.getSerializable("data") as EducationData
        viewModel.doData(1, data.academyNumber)
    }
}
