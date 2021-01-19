package com.entezeer.kyrgyzprogrammer.ui.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.entezeer.core.utils.AppUtils
import com.entezeer.kyrgyzprogrammer.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private lateinit var mBinding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentSettingsBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    fun setupView() {
        mBinding.cbShareApp.setOnClickListener {
            activity?.let { it1 -> AppUtils.Utils.shareApp(it1, it1.packageName) }
        }

        mBinding.cbRateApp.setOnClickListener {
            activity?.let { it1 -> AppUtils.Utils.rateApp(it1, it1.packageName) }
        }

        mBinding.cbWriteForUs.setOnClickListener {
            activity?.let { it1 -> AppUtils.Utils.contactUs(it1) }
        }

        mBinding.cbBugReport.setOnClickListener {
            activity?.let { it1 -> AppUtils.Utils.reportBug(it1) }
        }
    }
}