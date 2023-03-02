package co.dasa.dasarang.features.plaza.fragment

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentPlazaBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.features.plaza.adapter.ViewPagerAdapter
import co.dasa.dasarang.features.plaza.viewmodel.PlazaViewModel
import co.dasa.domain.model.banner.BannerInfo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlazaFragment : BaseFragment<FragmentPlazaBinding, PlazaViewModel>(R.layout.fragment_plaza) {

    override val viewModel: PlazaViewModel by viewModels()
    override val hasBottomNavigation: Boolean = true

    override fun start() {
        setBannerViewPager()
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
        // TODO 값 넘겨서 어떤 소식을 띄워야하는지 알게하기

    }

    private fun setBannerViewPager() {
        val bannerList = listOf(R.drawable.example_banner, R.drawable.academy, R.drawable.child)

        val adapter = ViewPagerAdapter()
        adapter.item.addAll(bannerList)

        binding.ivBanner.adapter = adapter

    }

}
