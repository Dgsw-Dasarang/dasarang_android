package co.dasa.dasarang.features.main.activity

import android.graphics.Color
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseActivity
import co.dasa.dasarang.databinding.ActivityMainBinding
import co.dasa.dasarang.features.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    override val viewModel: MainViewModel by viewModels()
    private lateinit var navController: NavController

    private var backpressedTime: Long = 0

    override fun start() {
        setNavigation()
    }

    private fun setNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment
        navController = navHostFragment.navController
        binding.bnvMain.apply {
            setupWithNavController(navController)
            setOnItemSelectedListener { item ->
                NavigationUI.onNavDestinationSelected(item, navController)
                navController.popBackStack(item.itemId, inclusive = false)
                true
            }
        }
    }

    fun setNavVisible(demand: Boolean) {
        binding.bnvMain.visibility = if (demand) View.VISIBLE else View.GONE
    }

    fun updateStatusBarColor(color: String) {
        val window: Window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.parseColor(color)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (System.currentTimeMillis() > backpressedTime + 2000) {
            backpressedTime = System.currentTimeMillis()
            // shortToast("\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.")
        } else if (System.currentTimeMillis() <= backpressedTime + 2000) {
            finish()
        }
        /*val fragment = supportFragmentManager.findFragmentById(R.id.fcv_main)
        Log.d("testasd", "$fragment")
        if (fragment is PlazaFragment) {
            super.onBackPressed()
        } else if (fragment is NewsFragment) {
            navController.navigate(R.id.main_plaza)
        } else {
            if (System.currentTimeMillis() > backpressedTime + 2000) {
                backpressedTime = System.currentTimeMillis()
                shortToast("\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.")
            } else if (System.currentTimeMillis() <= backpressedTime + 2000) {
                finish()
            }
        }*/
    }
}
