package co.dasa.dasarang.features.news.fragment

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentDetailBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.features.news.viewmodel.DetailViewModel
import co.dasa.dasarang.features.plaza.viewmodel.PlazaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>(R.layout.fragment_detail){

    override val viewModel: DetailViewModel by viewModels()

    override fun start() {
        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event) }
        }
    }

    private fun handleEvent(event: DetailViewModel.Event) {
        when(event) {
            is DetailViewModel.Event.Back -> moveBack()
        }
    }

    private fun moveBack() {
        findNavController().navigate(R.id.action_news_detail_to_main_news)
    }
}