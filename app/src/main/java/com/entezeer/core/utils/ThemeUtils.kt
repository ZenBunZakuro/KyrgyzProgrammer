package com.entezeer.core.utils

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.entezeer.core.preferences.SharedStorageImpl

object ThemeUtils {
    const val NIGHT = "Night mode"

    fun setNightModeEnabled(context: Context, isEnabled: Boolean) {
        val settings = SharedStorageImpl(context, "Settings")
        settings.save(NIGHT, isEnabled)
        updateTheme(context)
    }

    fun updateTheme(context: Context) {
        if (getThemePref(context)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    fun getThemePref(context: Context): Boolean {
        val sharedPreferences = SharedStorageImpl(context, "Settings")
        return sharedPreferences.get(NIGHT, false)
    }
}