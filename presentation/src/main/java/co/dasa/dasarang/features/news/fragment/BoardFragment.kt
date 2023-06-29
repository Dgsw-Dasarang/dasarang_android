package co.dasa.dasarang.features.news.fragment

import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentBoardBinding
import co.dasa.dasarang.extensions.shortToast
import co.dasa.dasarang.features.news.adapter.BoardAdapter
import co.dasa.dasarang.features.news.viewmodel.BoardViewModel
import co.dasa.domain.model.education.BoardData
import co.dasa.domain.model.education.EducationData
import co.dasa.domain.model.education.Image
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BoardFragment : BaseFragment<FragmentBoardBinding, BoardViewModel>(R.layout.fragment_board) {
    private lateinit var data: EducationData

    override val viewModel: BoardViewModel by viewModels()
    private lateinit var boardAdapter: BoardAdapter

    override fun start() {
        data = arguments?.getSerializable("data") as EducationData
        collectBoardState()
        setBoardAdapter()
        setListener()
    }

    private fun setListener() {
        binding.recyclerBoard.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!binding.recyclerBoard.canScrollVertically(1)) {
                    viewModel.doData(boardAdapter.itemCount / 10 + 1, data.academyNumber)
                }
            }
        })
    }

    private fun collectBoardState() {
        with(viewModel) {
            lifecycleScope.launchWhenStarted {
                boardState.collect { state ->
                    if (state.isUpdate) {
                        if(state.result!!.list.isNullOrEmpty()) {
                            boardAdapter.submitList(mutableListOf(BoardData("", "", listOf(Image("", "")), 0, "게시물이 비어있습니다."), BoardData("", "", listOf(Image("", "")), 0, "게시물이 비어있습니다."), BoardData("", "", listOf(Image("", "")), 0, "게시물이 비어있습니다.")))
                        } else {
                            boardAdapter.submitList((boardAdapter.currentList + state.result.list).distinct())
                        }
                    } else if (state.error.isNotBlank()) {
                        boardAdapter.submitList(mutableListOf(BoardData("", "", listOf(Image("", "")), 0, "게시물이 비어있습니다."), BoardData("", "", listOf(Image("", "")), 0, "게시물이 비어있습니다."), BoardData("", "", listOf(Image("", "")), 0, "게시물이 비어있습니다.")))
                        shortToast(state.error)
                    }
                }
            }
        }
    }

    private fun setBoardAdapter() {
        boardAdapter = BoardAdapter()
        binding.recyclerBoard.adapter = boardAdapter
        viewModel.doData(1, data.academyNumber)
    }
}
