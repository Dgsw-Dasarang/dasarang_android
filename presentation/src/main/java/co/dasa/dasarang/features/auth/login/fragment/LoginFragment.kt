package co.dasa.dasarang.features.auth.login.fragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentLoginBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.features.auth.join.fragment.JoinFragment
import co.dasa.dasarang.features.auth.login.viewmodel.LoginViewModel
import co.dasa.dasarang.features.plaza.fragment.PlazaFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>(R.layout.fragment_login) {

    override val viewModel: LoginViewModel by viewModels()

    override fun start() {
        repeatOnStarted {
            viewModel.eventFlow.collect {event -> handleEvent(event)}
        }
    }

    private fun handleEvent(event: LoginViewModel.Event) {
        when (event) {
            is LoginViewModel.Event.Login -> checkLogin()
            is LoginViewModel.Event.Join -> moveJoin()
        }
    }

    private fun checkLogin() {
        if (binding.etUserId.text.isNotBlank() && binding.etUserPw.text.isNotBlank()) {
            //TODO id, pw 비교 확인 작업 후 승인
            val fragmentManager = fragmentManager

            val plazaFragment = PlazaFragment()
            fragmentManager!!.beginTransaction().apply {
                replace(R.id.fcv_main, plazaFragment)
                commit()
            }
        }else if (binding.etUserId.text.isNullOrBlank()){
            binding.etUserId.requestFocus()
            Toast.makeText(requireContext(), "아이디를 입력해 주세요", Toast.LENGTH_SHORT).show()
        }else if (binding.etUserPw.text.isNullOrBlank()) {
            binding.etUserPw.requestFocus()
            Toast.makeText(requireContext(), "비밀번호를 입력해 주세요", Toast.LENGTH_SHORT).show()
        }
    }

    private fun moveJoin() {
        val fragmentManager = fragmentManager

        val joinFragment = JoinFragment()
        fragmentManager!!.beginTransaction().apply {
            replace(R.id.fcv_main, joinFragment)
            addToBackStack(null)
            commit()
        }
    }

}