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
import co.dasa.dasarang.features.main.activity.MainActivity
import co.dasa.dasarang.features.plaza.adapter.ViewPagerAdapter
import co.dasa.dasarang.features.plaza.viewmodel.PlazaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlazaFragment : BaseFragment<FragmentPlazaBinding, PlazaViewModel>(R.layout.fragment_plaza) {

    override val viewModel: PlazaViewModel by viewModels()
    override val hasBottomNavigation: Boolean = true

    override fun start() {
        (activity as MainActivity).updateStatusBarColor("#FFFFFF")
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
            is PlazaViewModel.Event.MoveScreenOwner -> checkMoveOwner(event.count)
        }
    }

    private fun settingView() {
        val role = arguments?.getString("role")
        val id = arguments?.getString("id")

        if (!role.isNullOrBlank()) {
            binding.groupLogin.visibility = View.GONE
            binding.groupProfile.visibility = View.VISIBLE

            binding.tvUserId.text = id

            when (role) {
                "ROLE_USER" -> {
                    binding.groupPlazaUser.visibility = View.VISIBLE
                    binding.groupPlazaOwner.visibility = View.GONE
                }
                "ROLE_OWNER" -> {
                    (activity as? MainActivity)?.setNavVisible(false)
                    binding.groupPlazaUser.visibility = View.GONE
                    binding.groupPlazaOwner.visibility = View.VISIBLE
                }
                else -> {
                    shortToast("알수 없는 권한")
                }
            }
        }
    }

    private fun checkMove(cnt: Int) {
        val bundle = bundleOf("view" to "$cnt")
        findNavController().navigate(R.id.action_main_plaza_to_main_news, bundle)
    }

    private fun checkMoveOwner(count: Int) {
        when(count) {
            1 -> {
                //내 학원
                //물어보기
            }
            2 -> {
                //게시판
                //Activity 만들기
            }
            3 -> {
                //상담
                //Activity 만들기
            }
            4 -> {
                val bundle = bundleOf("view" to "owner")
                findNavController().navigate(R.id.action_main_plaza_to_main_info, bundle)
            }
            5 -> {
                //결제
                //Activity
            }
        }
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
