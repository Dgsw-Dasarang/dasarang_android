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
        setView()
    }

    private fun handleEvent(event: NewsViewModel.Event) {
        when (event) {
            is NewsViewModel.Event.ShowToast -> Toast.makeText(requireContext(), event.text, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setView() {
        val args = arguments?.getString("view")
        when(args) {
            "0" -> {
                binding.tvAppTitle.text = "새소식"
            }
            "1" -> {
                binding.tvAppTitle.text = "교육청 소식"
            }
            "2" -> {
                binding.tvAppTitle.text = "학교별 소식"
            }
            "3" -> {
                binding.tvAppTitle.text = "학원별 소식"
            }
            "4" -> {
                binding.tvAppTitle.text = "유치원 소식"
            }
            "5" -> {
                binding.tvAppTitle.text = "어린이집 소식"
            }
        }
    }

}
