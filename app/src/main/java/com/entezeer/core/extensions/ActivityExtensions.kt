package com.entezeer.core.extensions

import android.app.Activity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.entezeer.kyrgyzprogrammer.R
import com.entezeer.kyrgyzprogrammer.ui.home.HomeFragment

fun AppCompatActivity.replaceFragment(fragment: Fragment, content: Int) {
    if (!equalByLast(fragment)) {
        //ToDo реализовать проверку на нахождения фрагмента в стеке бэк, для того чтобы
        //  недобавлять его далее, при повторном нажатии на него
        if (!supportFragmentManager.fragments.contains(fragment)) {
            supportFragmentManager.beginTransaction()
                .replace(content, fragment)
                .addToBackStack(fragment::class.java.canonicalName)
                .commit()
        }else{
            supportFragmentManager.beginTransaction()
                .replace(content, fragment)
                .commit()
        }
    }
}


fun AppCompatActivity.equalByLast(fragment: Fragment): Boolean {
    if (supportFragmentManager.backStackEntryCount > 0) {
        val lastFragment =
            supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1).name
        return lastFragment == fragment::class.java.canonicalName
    }
    return false
}

fun AppCompatActivity.isFragmentVisible(tag: String, id: Int): Boolean {
    val currentFragment = supportFragmentManager.findFragmentById(id)
    return currentFragment != null && currentFragment::class.java.canonicalName == tag
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