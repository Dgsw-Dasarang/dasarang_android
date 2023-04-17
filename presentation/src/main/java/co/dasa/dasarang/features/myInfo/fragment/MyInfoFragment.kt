package co.dasa.dasarang.features.myInfo.fragment

import android.util.Log
import android.widget.Toast
import androidx.core.os.bundleOf
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
        setView()
        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event) }
        }

    }

    private fun handleEvent(event: MyInfoViewModel.Event) {
        when (event) {
            is MyInfoViewModel.Event.ShowToast -> Toast.makeText(requireContext(), event.text, Toast.LENGTH_SHORT).show()
            is MyInfoViewModel.Event.Logout -> logout()
            is MyInfoViewModel.Event.Modify -> modify()
        }
    }

        val args = arguments?.getString("view")
    private fun setView() {
        when (args) {
            "owner" -> {
                (activity as? MainActivity)?.setNavVisible(false)
            }
        }
    }
    private fun setLogoutBtn() {
        //TODO logout 세팅
    }
    private fun logout() {
        findNavController().navigate(R.id.action_main_info_to_main_plaza)
    }

    private fun modify() {
        when (args) {
            "owner" -> {
                val bundle = bundleOf("view" to "owner")
                findNavController().navigate(R.id.action_main_info_to_modify_info, bundle)
            }
            else -> {
                findNavController().navigate(R.id.action_main_info_to_modify_info)
            }
        }
    }
}
