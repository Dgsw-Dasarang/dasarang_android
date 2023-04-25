package co.dasa.dasarang.features.myInfo.fragment

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentMyinfoBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.extensions.shortToast
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
        viewModel.getUserInfo()
        collectUserState()

    }

    private fun collectUserState() {
        with(viewModel) {
            lifecycleScope.launchWhenStarted {
                userState.collect { state ->
                    if (state.error.isNotBlank()) {
                        binding.tvUserId.text = "로그인을 해주세요."
                        binding.btnLogout.visibility = View.GONE
                        binding.btnEditInfo.visibility = View.GONE
                    } else if (state.isUpdate) {
                        state.result.also {
                            binding.tvUserId.text = it!!.userId
                            binding.tvPhoneNum.text = it.number
                            binding.tvUserAddress.text = it.address
                            binding.tvUserBirth.text = it.birth
                            binding.btnLogout.visibility = View.VISIBLE
                            binding.btnEditInfo.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
    }

    private fun handleEvent(event: MyInfoViewModel.Event) {
        when (event) {
            is MyInfoViewModel.Event.ShowToast -> Toast.makeText(requireContext(), event.text, Toast.LENGTH_SHORT).show()
            is MyInfoViewModel.Event.Logout -> logout()
            is MyInfoViewModel.Event.Modify -> modify()
        }
    }

    private fun setView() {
        val args = arguments?.getString("view")
        when (args) {
            "owner" -> {
                (activity as? MainActivity)?.setNavVisible(false)
            }
        }
    }
    private fun logout() {
        viewModel.doLogout()
        findNavController().navigate(R.id.action_main_info_to_main_plaza)
    }

    private fun modify() {
        val args = arguments?.getString("view")
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
