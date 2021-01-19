package com.entezeer.kyrgyzprogrammer.ui.lessons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.entezeer.kyrgyzprogrammer.R
import com.entezeer.kyrgyzprogrammer.databinding.FragmentLessonsContainerBinding
import com.entezeer.kyrgyzprogrammer.ui.categories.CategoriesFragment

class LessonsContainerFragment : Fragment() {

    private lateinit var mBinding: FragmentLessonsContainerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentLessonsContainerBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(
                R.id.fl_container,
                CategoriesFragment(),
                CategoriesFragment::class.java.canonicalName
            )?.commit()
    }
}