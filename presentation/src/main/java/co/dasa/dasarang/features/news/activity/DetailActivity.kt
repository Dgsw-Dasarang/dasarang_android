package co.dasa.dasarang.features.news.activity

import android.util.Log
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseActivity
import co.dasa.dasarang.databinding.ActivityDetailBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.features.news.adapter.TabPagerAdapter
import co.dasa.dasarang.features.news.viewmodel.DetailViewModel
import co.dasa.domain.model.education.EducationData
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>(R.layout.activity_detail) {

    override val viewModel: DetailViewModel by viewModels()

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var adapter: TabPagerAdapter

    override fun start() {
        settingTapLayout()
        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event) }
        }
    }

    private fun handleEvent(event: DetailViewModel.Event) {
        when (event) {
            is DetailViewModel.Event.Back -> moveBack()
        }
    }

    private fun settingTapLayout() {
        tabLayout = binding.tapAcademy
        viewPager = binding.container

        val data = intent.getSerializableExtra("item") as EducationData //넘겨준 학원 데이터 받아주는 코드
        binding.tvAcademyTitle.text = data.academyName

        adapter = TabPagerAdapter(this, data)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "정보"
                1 -> tab.text = "게시판"
                2 -> tab.text = "상담"
            }
        }.attach()
    }
    private fun moveBack() {
        finish()
    }
}
