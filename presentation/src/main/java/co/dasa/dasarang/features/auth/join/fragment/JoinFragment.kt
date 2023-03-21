package co.dasa.dasarang.features.auth.join.fragment

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentJoinBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.extensions.shortToast
import co.dasa.dasarang.features.auth.join.viewmodel.JoinViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JoinFragment : BaseFragment<FragmentJoinBinding, JoinViewModel>(R.layout.fragment_join) {

    override val viewModel: JoinViewModel by viewModels()

    private var role = "user"

    override fun start() {
        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event) }
        }
        collectJoinState()
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

    private fun collectJoinState() {
        with(viewModel) {
            lifecycleScope.launchWhenStarted {
                joinState.collect { state ->
                    if(state.isUpdate) {
                        findNavController().navigate(R.id.action_joinFragment_to_loginFragment)
                        shortToast("회원가입에 성공하셨습니다.")
                    }
                    else if (state.error.isNotBlank()) {
                        shortToast(state.error)
                    }
                }
            }
        }
    }

    private fun search() {
        // TODO 다음 주소 검색 api 사용
        Toast.makeText(requireContext(), "기능 구현 중 입니다.", Toast.LENGTH_SHORT).show()
    }

    private fun join() {
        if(role == "user") {
            viewModel.doUserJoin(
                binding.etUserId.text.toString(),
                binding.etUserPw.text.toString(),
                binding.tvAddress.text.toString(),
                binding.etPhoneNum.text.toString(),
                binding.etBirth.text.toString()
            )
        } else if(role == "owner") {
            viewModel.doOwnerJoin(binding.etUserId.text.toString(),
                binding.etUserPw.text.toString(),
                binding.tvAddress.text.toString(),
                binding.etPhoneNum.text.toString(),
                binding.etBirth.text.toString(),
                binding.etBusinessNumber.text.toString(),
                binding.etBusinessEmail.text.toString()
            )
        }

    }

    private fun business() {
        binding.businessGroup.visibility = View.VISIBLE
        binding.tvBusiness.visibility = View.GONE
        binding.tvUser.visibility = View.VISIBLE
        role = "owner"
    }

    private fun user() {
        binding.businessGroup.visibility = View.GONE
        binding.tvBusiness.visibility = View.VISIBLE
        binding.tvUser.visibility = View.GONE
        role = "user"
    }

    private fun moveLogin() {
        findNavController().navigate(R.id.action_joinFragment_to_loginFragment)
    }
}
