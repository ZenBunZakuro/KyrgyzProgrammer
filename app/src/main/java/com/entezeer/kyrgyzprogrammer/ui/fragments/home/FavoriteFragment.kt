package com.entezeer.kyrgyzprogrammer.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.entezeer.kyrgyzprogrammer.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {

    private lateinit var mBinding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentFavoriteBinding.inflate(layoutInflater)
        return mBinding.root
    }
}