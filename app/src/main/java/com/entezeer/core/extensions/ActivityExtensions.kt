package com.entezeer.core.extensions

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.entezeer.kyrgyzprogrammer.R

fun AppCompatActivity.replaceFragment(fragment: Fragment, container: Int) {
    supportFragmentManager.beginTransaction()
        .addToBackStack(null)
        .replace(container, fragment).commit()
}

fun Activity.fadeIn() {
    this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
}

fun Activity.rightIn() {
    this.overridePendingTransition(R.anim.right_in, R.anim.stay_still)
}

fun Activity.rightOut() {
    this.overridePendingTransition(R.anim.stay_still, R.anim.right_out)
}