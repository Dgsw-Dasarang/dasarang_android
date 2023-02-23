package co.dasa.dasarang.features.myInfo.fragment

import android.view.Window
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentMyinfoBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.features.main.activity.MainActivity
import co.dasa.dasarang.features.myInfo.viewmodel.MyInfoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyInfoFragment : BaseFragment<FragmentMyinfoBinding, MyInfoViewModel>(R.layout.fragment_myinfo) {

    override val viewModel: MyInfoViewModel by viewModels()
    override val hasBottomNavigation: Boolean = true

    override fun start() {
        (activity as MainActivity).updateStatusBarColor("#46BBFB")

        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event) }
        }
    }

    private fun handleEvent(event: MyInfoViewModel.Event) {
        when (event) {
            is MyInfoViewModel.Event.ShowToast -> Toast.makeText(requireContext(), event.text, Toast.LENGTH_SHORT).show()
            is MyInfoViewModel.Event.Logout -> logout()
        }
    }

    private fun logout() {
        findNavController().navigate(R.id.action_main_info_to_loginFragment)
    }
}
