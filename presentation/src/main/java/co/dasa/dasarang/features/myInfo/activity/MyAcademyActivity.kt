package co.dasa.dasarang.features.myInfo.activity

import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseActivity
import co.dasa.dasarang.databinding.ActivityMyAcademyBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.extensions.shortToast
import co.dasa.dasarang.features.myInfo.viewmodel.MyAcademyViewModel
import dagger.hilt.android.AndroidEntryPoint
import co.dasa.dasarang.features.myInfo.viewmodel.MyAcademyViewModel.Event

@AndroidEntryPoint
class MyAcademyActivity : BaseActivity<ActivityMyAcademyBinding, MyAcademyViewModel>(R.layout.activity_my_academy) {

    override val viewModel: MyAcademyViewModel by viewModels()

    override fun start() {
        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event) }
        }
        collectAcademyState()
        collectAcademyNumState()
        viewModel.getAdminData()
    }

    private fun collectAcademyState() {
        with(viewModel) {
            lifecycleScope.launchWhenStarted {
                academyState.collect { state ->
                    if (state.error.isNotBlank()) {
                        shortToast(state.error)
                    } else if (state.isUpdate) {
                        state.result.also {
                            binding.tvAcademyName.text = it!!.academyName
                            binding.tvAcademySubject.text = it.courseName
                            binding.tvAcademyState.text = it.status
                            var text = ""
                            for(i in it.tuitions) {
                                text += "${i.title} : ${i.price}\n"
                            }
                            binding.tvAcademyPrice.text = text
                            binding.tvAcademyDate.text = it.createdAt
                            binding.tvAcademyCount.text = it.totalSeats.toString()
                        }
                    }
                }
            }
        }
    }

    private fun collectAcademyNumState() {
        with(viewModel) {
            lifecycleScope.launchWhenStarted {
                academyNumState.collect { state ->
                    if (state.error.isNotBlank()) {
                        shortToast(state.error)
                    } else if (state.isUpdate) {
                        viewModel.getAcademyData(state.result!!)
                    }
                }
            }
        }
    }

    private fun handleEvent(event: Event) {
        when (event) {
            is Event.Back -> finish()
        }
    }
}