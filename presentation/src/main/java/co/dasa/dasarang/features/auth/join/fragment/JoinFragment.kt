package co.dasa.dasarang.features.auth.join.fragment

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentJoinBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.features.auth.join.viewmodel.JoinViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JoinFragment : BaseFragment<FragmentJoinBinding, JoinViewModel>(R.layout.fragment_join) {

    override val viewModel: JoinViewModel by viewModels()

    override fun start() {
        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event) }
        }
    }

    private fun handleEvent(event: JoinViewModel.Event) {
        when (event) {
            is JoinViewModel.Event.Search -> search()
            is JoinViewModel.Event.Join -> join()
            is JoinViewModel.Event.BusinessJoin -> business()
            is JoinViewModel.Event.UserJoin -> user()
            is JoinViewModel.Event.MoveLogin -> moveLogin()
        }
    }

    private fun search() {
        // TODO 다음 주소 검색 api 사용
        Toast.makeText(requireContext(), "기능 구현 중 입니다.", Toast.LENGTH_SHORT).show()
    }

    private fun join() {
        // TODO 회원가입 데이터 처리
        // 임시로 화면만 넘김
        findNavController().navigate(R.id.action_joinFragment_to_loginFragment)
    }

    private fun business() {
        binding.businessGroup.visibility = View.VISIBLE
        binding.tvBusiness.visibility = View.GONE
        binding.tvUser.visibility = View.VISIBLE
    }

    private fun user() {
        binding.businessGroup.visibility = View.GONE
        binding.tvBusiness.visibility = View.VISIBLE
        binding.tvUser.visibility = View.GONE
    }

    private fun moveLogin() {
        findNavController().navigate(R.id.action_joinFragment_to_loginFragment)
    }
}
