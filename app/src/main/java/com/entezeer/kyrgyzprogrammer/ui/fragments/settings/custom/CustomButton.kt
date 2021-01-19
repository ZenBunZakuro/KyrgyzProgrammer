package com.entezeer.kyrgyzprogrammer.ui.fragments.settings.custom

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.entezeer.kyrgyzprogrammer.R
import kotlinx.android.synthetic.main.custom_button.view.*

class CustomButton : ConstraintLayout {
    constructor(context: Context) : super(context) {
        setupView()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setupView(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle){
        setupView(attrs)
    }

    private fun setupView(attrs: AttributeSet? = null) {
        View.inflate(context, R.layout.custom_button, this)
        if (attrs == null) return
        val attributes  = context?.obtainStyledAttributes(attrs, R.styleable.CustomButtonStyle)
        attributes?.run {
            getString(R.styleable.CustomButtonStyle_title)?.let {
                setTitle(it)
            }

            getDrawable(R.styleable.CustomButtonStyle_iconSrc).let {
                setIcon(it)
            }

            getBoolean(R.styleable.CustomButtonStyle_switchEnabled, false).let {
                setSwitchVisible(it)
            }
        }
        attributes?.recycle()
    }

    private fun setSwitchVisible(switchEnabled: Boolean) {
        if (switchEnabled) {
            sw_theme.visibility = View.VISIBLE
            iv_shevron.visibility = View.GONE
        }
    }

    fun setIcon(icon: Drawable?){
        iv_icon.setImageDrawable(icon)
    }

    fun setTitle(title: String){
        id_title.text = title
    }
}