package com.entezeer.core.extensions

import android.app.Activity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import com.entezeer.kyrgyzprogrammer.R
import kotlinx.android.synthetic.main.activity_main.*

private val AppCompatActivity.toast: Toast?
    get() = Toast.makeText(
        applicationContext,
        "Settings",
        Toast.LENGTH_SHORT
    )

fun AppCompatActivity.replaceFragment(fragment: Fragment, content: Int, addStack: Boolean) {
    if (addStack) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.addToBackStack(fragment::class.java.canonicalName)
        //Toast.makeText(applicationContext, fragment::class.java.canonicalName.toString(), Toast.LENGTH_SHORT).show()
        transaction.replace(content, fragment)
        transaction.commit()

        when (fragment::class.java.canonicalName.toString()) {
            "com.entezeer.kyrgyzprogrammer.ui.fragments.home.HomeFragment" -> Toast.makeText(
                applicationContext,
                "Home",
                Toast.LENGTH_SHORT
            ).show()
            "com.entezeer.kyrgyzprogrammer.ui.fragments.favorite.FavoriteFragment" -> Toast.makeText(
                applicationContext,
                "Favorite",
                Toast.LENGTH_SHORT
            ).show()
            "com.entezeer.kyrgyzprogrammer.ui.fragments.settings.SettingsFragment" -> Toast.makeText(
                applicationContext,
                "Settings",
                Toast.LENGTH_SHORT
            ).show()
        }
    } else {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(content, fragment)
        transaction.commit()
    }
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