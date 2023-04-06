package co.dasa.dasarang.features.auth.login.fragment

import android.text.InputType
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentLoginBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.extensions.shortToast
import co.dasa.dasarang.features.auth.login.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>(R.layout.fragment_login) {

    override val viewModel: LoginViewModel by viewModels()

    override fun start() {
        binding.etUserPw.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event) }
        }

        collectLoginState()
    }

    private fun handleEvent(event: LoginViewModel.Event) {
        when (event) {
            is LoginViewModel.Event.Login -> checkLogin()
            is LoginViewModel.Event.Join -> moveJoin()
            is LoginViewModel.Event.ShowToast -> unimplemented(event.text)
        }
    }

    private fun collectLoginState() {
        with(viewModel) {
            lifecycleScope.launchWhenStarted {
                loginState.collect { state ->
                    if (state.error.isNotBlank()) {
                        shortToast(state.error)
                    } else if (state.isUpdate) {
                        findNavController().navigate(R.id.main_plaza)
                    }
                }
            }
        }
    }

    private fun checkLogin() {
        if (binding.etUserId.text.isNotBlank() && binding.etUserPw.text.isNotBlank()) {
            viewModel.doLogin(binding.etUserId.text.toString(), binding.etUserPw.text.toString())
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
