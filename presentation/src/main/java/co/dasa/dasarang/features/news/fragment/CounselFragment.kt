package co.dasa.dasarang.features.news.fragment

import androidx.fragment.app.viewModels
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentCounselBinding
import co.dasa.dasarang.features.news.viewmodel.CounselViewModel

class CounselFragment : BaseFragment<FragmentCounselBinding, CounselViewModel>(R.layout.fragment_counsel) {

    override val viewModel: CounselViewModel by viewModels()

    override fun start() {

    }

}