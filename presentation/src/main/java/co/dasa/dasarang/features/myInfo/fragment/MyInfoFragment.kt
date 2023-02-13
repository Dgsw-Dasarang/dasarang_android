package co.dasa.dasarang.features.myInfo.fragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentMyinfoBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.features.myInfo.viewmodel.MyInfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

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
        }
    }
}