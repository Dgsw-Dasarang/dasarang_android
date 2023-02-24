package co.dasa.dasarang.features.modify.fragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentModifyBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.features.modify.viewmodel.ModifyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ModifyFragment : BaseFragment<FragmentModifyBinding, ModifyViewModel>(R.layout.fragment_modify) {

    override val viewModel: ModifyViewModel by viewModels()
    override val hasBottomNavigation: Boolean = true

    override fun start() {
        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event)}
        }
    }

    private fun handleEvent(event: ModifyViewModel.Event) {
        when (event) {
            is ModifyViewModel.Event.Back -> back()
            is ModifyViewModel.Event.ProfileImage -> profileImage()
            is ModifyViewModel.Event.Search -> search()
            is ModifyViewModel.Event.Modify -> modify()
        }
    }

    private fun back() {
        findNavController().navigate(R.id.action_modify_info_to_main_info)
    }

    private fun profileImage() {
        showToast()
    }

    private fun search() {
        showToast()
    }

    private fun modify() {
        //TODO 서버로 데이터 전달 후 정보 변경 적용
        //임시 처리
        findNavController().navigate(R.id.action_modify_info_to_main_info)
    }

    private fun showToast() {
        Toast.makeText(requireContext(), "준비 중인 기능 입니다", Toast.LENGTH_SHORT).show()
    }
}