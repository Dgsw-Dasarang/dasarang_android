package co.dasa.dasarang.features.news.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import co.dasa.dasarang.features.news.fragment.BoardFragment
import co.dasa.dasarang.features.news.fragment.CounselFragment
import co.dasa.dasarang.features.news.fragment.InfoFragment
import co.dasa.domain.model.education.EducationData

class TabPagerAdapter(fragmentActivity: FragmentActivity, data: EducationData) : FragmentStateAdapter(fragmentActivity) {

    private val fragments = arrayOf(InfoFragment().apply { arguments = Bundle().apply { putSerializable("data", data) } }, BoardFragment(), CounselFragment())

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    override fun getItemCount(): Int {
        return fragments.size
    }
}
