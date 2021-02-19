package com.entezeer.kyrgyzprogrammer.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.entezeer.core.utils.AppUtils
import com.entezeer.core.utils.ShowToast
import com.entezeer.core.utils.ThemeUtils
import com.entezeer.kyrgyzprogrammer.R
import com.entezeer.kyrgyzprogrammer.databinding.FragmentSettingsBinding
import com.entezeer.kyrgyzprogrammer.ui.main.MainActivity
import com.entezeer.kyrgyzprogrammer.ui.settings.about_us.AboutUsActivity
import com.entezeer.kyrgyzprogrammer.ui.settings.bottomsheet.LanguageChooseBottomSheetFragment
import kotlinx.android.synthetic.main.custom_button.*

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
        mBinding.cbAboutApp.setOnClickListener {
            activity?.let { it1 -> AboutUsActivity.start(it1) }
        }

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

        mBinding.cbTheme.apply {
            setSwitchState(context?.let { ThemeUtils.getThemePref(it) })
            switchChangeListener(isCheckedAction = {
                activity?.apply {
                    ThemeUtils.setNightModeEnabled(this, it)
                    recreate()
                }
            })
        }

        mBinding.cbLanguage.setOnClickListener {
            fragmentManager?.let { it1 -> LanguageChooseBottomSheetFragment().show(it1, "TAG") }
        }
    }
}