package co.dasa.dasarang.features.plaza.fragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentPlazaBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.features.auth.join.fragment.JoinFragment
import co.dasa.dasarang.features.news.fragment.NewsFragment
import co.dasa.dasarang.features.plaza.viewmodel.PlazaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlazaFragment : BaseFragment<FragmentPlazaBinding, PlazaViewModel>(R.layout.fragment_plaza) {

    override val viewModel: PlazaViewModel by viewModels()
    override val hasBottomNavigation: Boolean = true

    override fun start() {
        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event) }
        }
    }

    private fun handleEvent(event: PlazaViewModel.Event) {
        when (event) {
            is PlazaViewModel.Event.ShowToast -> Toast.makeText(requireContext(), event.text, Toast.LENGTH_SHORT).show()
            is PlazaViewModel.Event.MoveScreen -> checkMove(event.cnt)
        }
    }

    private fun checkMove(cnt: Int) {
        //TODO 값 넘겨서 어떤 소식을 띄워야하는지 알게하기
    }
}
