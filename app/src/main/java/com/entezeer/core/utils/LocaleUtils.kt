package com.entezeer.core.utils

import android.content.Context
import android.os.Build
import com.entezeer.core.preferences.SharedStorageImpl
import com.entezeer.kyrgyzprogrammer.constants.Constants
import java.util.*


object LocaleUtils {

    fun setLocale(c: Context): Context? {
        return updateResources(c, getSavedLocale(c))
    }

    fun setNewLocale(
        c: Context,
        language: String
    ): Context? {
        updateResources(c, language)
        val settings = SharedStorageImpl(c, Constants.settings)
        settings.save(Constants.language, language)
        return c
    }

    private fun updateResources(
        c: Context,
        language: String
    ): Context? {
        var context = c
        val locale = Locale(language)
        val configuration = context.resources.configuration
        val res = context.resources

        if (Build.VERSION.SDK_INT >= 17) {
            Locale.setDefault(locale)
            configuration.setLocale(locale)
            context = context.createConfigurationContext(configuration)
        } else {
            configuration.locale = locale
            res.updateConfiguration(configuration, res.displayMetrics)
        }
        return context
    }

    fun getSavedLocale(c: Context): String {
        val savedLanguage = SharedStorageImpl(c, Constants.settings)
        return savedLanguage.get(Constants.language, Constants.RU)
    }
}