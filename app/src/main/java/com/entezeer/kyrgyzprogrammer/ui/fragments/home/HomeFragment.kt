package com.entezeer.kyrgyzprogrammer.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.entezeer.kyrgyzprogrammer.R
import com.entezeer.kyrgyzprogrammer.databinding.FragmentHomeBinding
import com.entezeer.kyrgyzprogrammer.ui.fragments.home.adapter.ViewPagerAdapter
import com.entezeer.kyrgyzprogrammer.ui.fragments.home.articles.ArticlesFragment
import com.entezeer.kyrgyzprogrammer.ui.fragments.home.lessons.LessonsFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var mBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHomeBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpTabs()
    }

    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(LessonsFragment(), "Lessons")
        adapter.addFragment(ArticlesFragment(), "Articles")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_home_black_24)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_favorite_black_24)
    }

}