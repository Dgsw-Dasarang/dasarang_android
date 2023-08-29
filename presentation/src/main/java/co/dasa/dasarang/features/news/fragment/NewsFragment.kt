package co.dasa.dasarang.features.news.fragment

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentNewsBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.features.main.activity.MainActivity
import co.dasa.dasarang.features.news.adapter.EduNewsAdapter
import co.dasa.dasarang.features.news.adapter.OtherNewsAdapter
import co.dasa.dasarang.features.news.viewmodel.NewsViewModel
import co.dasa.domain.model.news.NewsData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding, NewsViewModel>(R.layout.fragment_news) {

    override val viewModel: NewsViewModel by viewModels()
    override val hasBottomNavigation: Boolean = true

    private lateinit var eduNewsAdapter: EduNewsAdapter
    private lateinit var otherNewsAdapter: OtherNewsAdapter

    private var content = ""
    private var category = ""

    override fun start() {
        (activity as MainActivity).updateStatusBarColor("#FFFFFF")
        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event) }
        }
        setView()
    }

    private fun setEduListener() {
        binding.recyclerEduNews.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!binding.recyclerEduNews.canScrollVertically(1)) {
                    viewModel.getEduData(eduNewsAdapter.itemCount / 10 + 1)
                }
            }
        })
    }

    private fun setNewsListener() {
        binding.recyclerNews.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!binding.recyclerNews.canScrollVertically(1)) {
                    viewModel.getNewsData(otherNewsAdapter.itemCount / 10 + 1, category, content)
                }
            }
        })
    }

    private fun setEduNewsAdapter() {
        eduNewsAdapter = EduNewsAdapter()
        binding.recyclerEduNews.adapter = eduNewsAdapter
        viewModel.getEduData(1)
    }

    private fun setOtherNewsAdapter() {
        otherNewsAdapter = OtherNewsAdapter()
        binding.recyclerNews.adapter = otherNewsAdapter
        viewModel.getNewsData(1, category, content)
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
                category = "NEW"
                content = "NEW"
            }
            "1" -> {
                binding.tvAppTitle.text = "교육청 소식"
                category = "CATEGORY"
                content = "EDUCATION_OFFICE"
            }
            "2" -> {
                binding.tvAppTitle.text = "학교별 소식"
                category = "CATEGORY"
                content = "SCHOOL"
            }
            "3" -> {
                binding.tvAppTitle.text = "학원별 소식"
            }
            "4" -> {
                binding.tvAppTitle.text = "유치원 소식"
                category = "CATEGORY"
                content = "PRESCHOOL"
            }
            "5" -> {
                binding.tvAppTitle.text = "어린이집 소식"
                category = "CATEGORY"
                content = "DAYCARE_CENTER"
            }
        }
        if(args?.toInt() == 3) {
            binding.recyclerEduNews.visibility = View.VISIBLE
            binding.recyclerNews.visibility = View.GONE
            collectEducationState()
            setEduNewsAdapter()
            setEduListener()
        } else {
            binding.recyclerEduNews.visibility = View.GONE
            binding.recyclerNews.visibility = View.VISIBLE
            collectNewsState()
            setOtherNewsAdapter()
            setNewsListener()
        }
    }

    private fun collectEducationState() {
        with(viewModel) {
            lifecycleScope.launchWhenStarted {
                educationState.collect { state ->
                    if (state.isUpdate) {
                        state.result.let {
                            eduNewsAdapter.submitList((eduNewsAdapter.currentList + it?.list!!.toMutableList()))
                        }
                    }
                }
            }
        }
    }

    private fun collectNewsState() {
        with(viewModel) {
            lifecycleScope.launchWhenStarted {
                newsState.collect { state ->
                    if (state.isUpdate) {
                        state.result.let {
                            if(it != null) {
                                otherNewsAdapter.submitList((otherNewsAdapter.currentList + it.list))
                            }
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
