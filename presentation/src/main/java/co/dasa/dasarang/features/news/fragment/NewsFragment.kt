package co.dasa.dasarang.features.news.fragment

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentNewsBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.features.main.activity.MainActivity
import co.dasa.dasarang.features.news.adapter.EduNewsAdapter
import co.dasa.dasarang.features.news.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding, NewsViewModel>(R.layout.fragment_news) {

    override val viewModel: NewsViewModel by viewModels()
    override val hasBottomNavigation: Boolean = true

    private lateinit var eduNewsAdapter: EduNewsAdapter

    override fun start() {
        (activity as MainActivity).updateStatusBarColor("#FFFFFF")
        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event) }
        }
        setView()
        //setEduNewsAdapter()
        collectEducationState()
    }

    //TODO news adapter 만들고 api 받아서 연결 해주기
    private fun setEduNewsAdapter() {
        eduNewsAdapter = EduNewsAdapter()
        binding.recyclerEduNews.adapter = eduNewsAdapter
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
            }
            "4" -> {
                binding.tvAppTitle.text = "유치원 소식"
            }
            "5" -> {
                binding.tvAppTitle.text = "어린이집 소식"
            }
        }
        if(args?.toInt() == 3) {
            binding.recyclerEduNews.visibility = View.VISIBLE
            binding.recyclerNews.visibility = View.GONE
            setEduNewsAdapter()
        } else {
            binding.recyclerEduNews.visibility = View.GONE
            binding.recyclerNews.visibility = View.VISIBLE
        }
    }

    private fun collectEducationState() {
        with(viewModel) {
            lifecycleScope.launchWhenStarted {
                educationState.collect { state ->
                    if (state.isUpdate) {
                        state.result.let {
                            eduNewsAdapter.submitList(it?.list?.toMutableList())
                        }
                    }
                }
            }
        }
    }

//    private fun mapper(data: EducationDatas?): MutableList<EduNewsData> {
//        val list = mutableListOf<EduNewsData>()
//        data?.list?.forEach {
//            list.add(EduNewsData(null, it.academyName, it.admstZoneName, it.status, it.courseName))
//        }
//        return list
//    }
}
