package co.dasa.dasarang.features.news.fragment

import androidx.activity.viewModels
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseActivity
import co.dasa.dasarang.databinding.ActivityOtherNewsBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.features.news.viewmodel.OtherNewsViewModel

class OtherNewsActivity : BaseActivity<ActivityOtherNewsBinding, OtherNewsViewModel>(R.layout.activity_other_news) {
    override val viewModel: OtherNewsViewModel by viewModels()

    override fun start() {
        repeatOnStarted {
            viewModel.eventFlow.collect() { event -> handleEvent(event) }
        }
    }

    private fun handleEvent(event: OtherNewsViewModel.Event) {
        when (event) {
            else -> {}
        }
    }
}