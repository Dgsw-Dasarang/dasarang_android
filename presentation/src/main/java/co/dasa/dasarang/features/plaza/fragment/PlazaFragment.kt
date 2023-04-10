package co.dasa.dasarang.features.plaza.fragment

import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentPlazaBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.extensions.shortToast
import co.dasa.dasarang.features.plaza.adapter.ViewPagerAdapter
import co.dasa.dasarang.features.plaza.viewmodel.PlazaViewModel
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
        settingView()
    }

    private fun handleEvent(event: PlazaViewModel.Event) {
        when (event) {
            is PlazaViewModel.Event.ShowToast -> Toast.makeText(requireContext(), event.text, Toast.LENGTH_SHORT).show()
            is PlazaViewModel.Event.MoveScreen -> checkMove(event.cnt)
            is PlazaViewModel.Event.Login -> moveLogin()
        }
    }

    private fun settingView() {
        val role = arguments?.getString("role")
        val id = arguments?.getString("id")

        if (!role.isNullOrBlank()) {
            binding.groupLogin.visibility = View.GONE
            binding.groupProfile.visibility = View.VISIBLE

            binding.tvUserId.text = id

            if(role == "ROLE_USER") {

            } else if(role == "ROLE_OWNER") {

            } else {
                shortToast("알수 없는 권한")
            }
        }
    }

    private fun checkMove(cnt: Int) {
        val bundle = bundleOf("view" to "$cnt")
        findNavController().navigate(R.id.action_main_plaza_to_main_news, bundle)
    }

    private fun moveLogin() {
        findNavController().navigate(R.id.action_main_plaza_to_loginFragment)
    }

    private fun setBannerViewPager() {
        val bannerList = listOf(R.drawable.example_banner, R.drawable.academy, R.drawable.child)

        val adapter = ViewPagerAdapter()
        adapter.item.addAll(bannerList)

        binding.ivBanner.adapter = adapter
    }
}
