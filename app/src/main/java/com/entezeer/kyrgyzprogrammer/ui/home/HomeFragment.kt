package com.entezeer.kyrgyzprogrammer.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.entezeer.kyrgyzprogrammer.R
import com.entezeer.kyrgyzprogrammer.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var mBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHomeBinding.inflate(layoutInflater)
        return mBinding.root




    }

    override fun onResume() {
        super.onResume()
    }
}