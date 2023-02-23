package co.dasa.dasarang.features.auth.login.fragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentLoginBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.features.auth.login.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>(R.layout.fragment_login) {

    override val viewModel: LoginViewModel by viewModels()

    override fun start() {
        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event) }
        }
    }

    private fun handleEvent(event: LoginViewModel.Event) {
        when (event) {
            is LoginViewModel.Event.Login -> checkLogin()
            is LoginViewModel.Event.Join -> moveJoin()
            is LoginViewModel.Event.ShowToast -> unimplemented(event.text)
        }
    }

    private fun checkLogin() {
        if (binding.etUserId.text.isNotBlank() && binding.etUserPw.text.isNotBlank()) {
            // TODO id, pw 비교 확인 작업 후 승인
            findNavController().navigate(R.id.action_loginFragment_to_main_plaza)
        } else if (binding.etUserId.text.isNullOrBlank()) {
            binding.etUserId.requestFocus()
            Toast.makeText(requireContext(), "아이디를 입력해 주세요", Toast.LENGTH_SHORT).show()
        } else if (binding.etUserPw.text.isNullOrBlank()) {
            binding.etUserPw.requestFocus()
            Toast.makeText(requireContext(), "비밀번호를 입력해 주세요", Toast.LENGTH_SHORT).show()
        }
    }

    private fun moveJoin() {
        findNavController().navigate(R.id.action_loginFragment_to_joinFragment)
    }

    private fun unimplemented(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
    }
}
