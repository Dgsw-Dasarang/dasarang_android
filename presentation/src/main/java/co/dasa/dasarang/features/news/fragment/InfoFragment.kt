package co.dasa.dasarang.features.news.fragment

import android.util.Log
import androidx.fragment.app.viewModels
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseFragment
import co.dasa.dasarang.databinding.FragmentInfoBinding
import co.dasa.dasarang.features.news.viewmodel.InfoViewModel
import co.dasa.domain.model.education.EducationData

class InfoFragment : BaseFragment<FragmentInfoBinding, InfoViewModel>(R.layout.fragment_info) {

    override val viewModel: InfoViewModel by viewModels()

    override fun start() {
        Log.d("testasd", arguments?.getSerializable("data").toString())
        setView()
    }

    private fun setView() {
        val data = arguments?.getSerializable("data") as EducationData
        binding.tvAddress.text = data.roadAddress
        var text = ""
        for(i in data.tuitions) {
            text += "${i.title} : ${i.price}\n"
        }
        binding.tvEduPrice.text = text
        binding.tvEduName.text = data.courseName
        binding.tvEduState.text = data.status
        binding.tvEduBirth.text = data.createdAt
        binding.tvEduSum.text = data.totalSeats.toString()
    }
}
