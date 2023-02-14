package co.dasa.dasarang.features.myInfo.fragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentMyinfoBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.features.auth.login.fragment.LoginFragment
import co.dasa.dasarang.features.myInfo.viewmodel.MyInfoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyInfoFragment : BaseFragment<FragmentMyinfoBinding, MyInfoViewModel>(R.layout.fragment_myinfo) {

    override val viewModel: MyInfoViewModel by viewModels()
    override val hasBottomNavigation: Boolean = true

    override fun start() {
        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event)}
        }
    }

    private fun handleEvent(event: MyInfoViewModel.Event) {
        when(event) {
            is MyInfoViewModel.Event.ShowToast -> Toast.makeText(requireContext(), event.text, Toast.LENGTH_SHORT).show()
            is MyInfoViewModel.Event.Logout -> logout(event.logout)
        }
    }

    private fun logout(num: Int){
        when(num) {
            1 -> {
                val fragmentManager = fragmentManager

                val loginFragment = LoginFragment()
                fragmentManager!!.beginTransaction().apply {
                    replace(R.id.fcv_main, loginFragment)
                    //addToBackStack(null) 스택 쌓아서 뒤로 가기 동작시 나옴
                    commit()
                }
            }
            else -> Toast.makeText(requireContext(), "알수없는 error", Toast.LENGTH_SHORT).show()
        }
    }
}