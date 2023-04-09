package co.dasa.dasarang.features.news.fragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentNewsBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.features.news.adapter.NewsAdapter
import co.dasa.dasarang.features.news.viewmodel.NewsViewModel
import co.dasa.domain.model.education.EducationDatas
import co.dasa.domain.model.news.NewsData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding, NewsViewModel>(R.layout.fragment_news) {

    override val viewModel: NewsViewModel by viewModels()
    override val hasBottomNavigation: Boolean = true

    private lateinit var newsAdapter: NewsAdapter

    override fun start() {
        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event) }
        }
        setView()

        setNewsAdapter()
        collectEducationState()
    }

    private fun setNewsAdapter() {
        newsAdapter = NewsAdapter()
        binding.recyclerNews.adapter = newsAdapter
        viewModel.getData(1)
    }

    private fun handleEvent(event: NewsViewModel.Event) {
        when (event) {
            is NewsViewModel.Event.ShowToast -> Toast.makeText(requireContext(), event.text, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setView() {
        val args = arguments?.getString("view")
        when (args) {
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
                // setNewsAdapter()
            }
            "4" -> {
                binding.tvAppTitle.text = "유치원 소식"
            }
            "5" -> {
                binding.tvAppTitle.text = "어린이집 소식"
            }
        }
    }

    private fun collectEducationState() {
        with(viewModel) {
            lifecycleScope.launchWhenStarted {
                educationState.collect { state ->
                    if (state.isUpdate) {
                        state.result.let {
                            newsAdapter.submitList(mapper(it))
                        }
                    }
                }
            }
        }
    }

    private fun mapper(data: EducationDatas?): MutableList<NewsData> {
        val list = mutableListOf<NewsData>()
        data?.list?.forEach {
            list.add(NewsData(null, it.academyName, it.admstZoneName, it.status, it.courseName))
            // TODO courseListName -> ??
        }
        return list
    }
}
