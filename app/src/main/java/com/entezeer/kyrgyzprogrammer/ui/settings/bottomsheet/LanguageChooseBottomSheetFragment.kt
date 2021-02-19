package com.entezeer.kyrgyzprogrammer.ui.settings.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.entezeer.core.utils.LocaleUtils
import com.entezeer.kyrgyzprogrammer.R
import com.entezeer.kyrgyzprogrammer.constants.Constants
import com.entezeer.kyrgyzprogrammer.databinding.FragmentCustomBottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class LanguageChooseBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var mBinding: FragmentCustomBottomSheetDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentCustomBottomSheetDialogBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        if (activity?.let { LocaleUtils.getSavedLocale(it) } == Constants.RU) {
            mBinding.radioButtonRu.isChecked = true
        } else {
            mBinding.radioButtonKg.isChecked = true
        }

        mBinding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio_button_ru -> {
                    activity?.let { LocaleUtils.setNewLocale(it, Constants.RU) }
                    activity?.recreate()
                    dismiss()
                }
                R.id.radio_button_kg -> {
                    activity?.let { LocaleUtils.setNewLocale(it, Constants.KG) }
                    activity?.recreate()
                    dismiss()
                }
            }
        }
    }
}