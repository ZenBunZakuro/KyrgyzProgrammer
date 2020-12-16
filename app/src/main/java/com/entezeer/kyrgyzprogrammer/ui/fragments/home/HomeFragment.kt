package com.entezeer.kyrgyzprogrammer.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.entezeer.kyrgyzprogrammer.R
import com.entezeer.kyrgyzprogrammer.databinding.FragmentHomeBinding
import com.entezeer.kyrgyzprogrammer.ui.fragments.home.adapter.ViewPagerAdapter
import com.entezeer.kyrgyzprogrammer.ui.fragments.articles.ArticlesFragment
import com.entezeer.kyrgyzprogrammer.ui.fragments.categories.CategoriesFragment
import com.entezeer.kyrgyzprogrammer.ui.fragments.lessons.LessonsContainerFragment
import com.entezeer.kyrgyzprogrammer.ui.fragments.lessons.LessonsFragment
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
        adapter.addFragment(LessonsContainerFragment(), getString(R.string.lessons))
        adapter.addFragment(ArticlesFragment(), getString(R.string.articles))
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}