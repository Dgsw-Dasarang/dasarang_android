package co.dasa.dasarang.features.modify.fragment

import androidx.fragment.app.viewModels
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentModifyBinding
import co.dasa.dasarang.features.modify.viewmodel.ModifyViewModel

class ModifyFragment : BaseFragment<FragmentModifyBinding, ModifyViewModel>(R.layout.fragment_modify) {

    override val viewModel: ModifyViewModel by viewModels()

    override fun start() {

    }
}