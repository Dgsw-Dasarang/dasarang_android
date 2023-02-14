package co.dasa.dasarang.features.auth.join.fragment

import androidx.fragment.app.viewModels
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentJoinBinding
import co.dasa.dasarang.features.auth.join.viewmodel.JoinViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JoinFragment : BaseFragment<FragmentJoinBinding, JoinViewModel>(R.layout.fragment_join) {

    override val viewModel: JoinViewModel by viewModels()

    override fun start() {

    }
}