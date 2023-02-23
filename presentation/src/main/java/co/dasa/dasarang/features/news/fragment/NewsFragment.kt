package co.dasa.dasarang.features.news.fragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentNewsBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.features.news.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding, NewsViewModel>(R.layout.fragment_news) {

    override val viewModel: NewsViewModel by viewModels()
    override val hasBottomNavigation: Boolean = true

    override fun start() {
        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event) }
        }
    }

    private fun handleEvent(event: NewsViewModel.Event) {
        when (event) {
            is NewsViewModel.Event.ShowToast -> Toast.makeText(requireContext(), event.text, Toast.LENGTH_SHORT).show()
        }
    }
}
