package co.dasa.dasarang.features.main.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
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

    override fun start() {
        setNavigation()
    }

    private fun setNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment
        navController = navHostFragment.navController
        binding.bnvMain.setupWithNavController(navController)
    }

    fun setNavVisible(demand: Boolean) {
        binding.bnvMain.visibility = if (demand) View.VISIBLE else View.GONE
    }

}