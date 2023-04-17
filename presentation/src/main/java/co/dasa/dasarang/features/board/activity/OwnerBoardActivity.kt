package co.dasa.dasarang.features.board.activity

import androidx.activity.viewModels
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseActivity
import co.dasa.dasarang.databinding.ActivityBoardBinding
import co.dasa.dasarang.features.board.viewmodel.OwnerBoardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OwnerBoardActivity : BaseActivity<ActivityBoardBinding, OwnerBoardViewModel>(R.layout.activity_board) {
    override val viewModel: OwnerBoardViewModel by viewModels()

    override fun start() {

    }

}