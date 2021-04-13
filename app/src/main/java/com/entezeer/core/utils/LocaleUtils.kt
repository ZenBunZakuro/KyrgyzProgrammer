package com.entezeer.core.utils

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import com.entezeer.core.preferences.SharedStorageImpl
import com.entezeer.kyrgyzprogrammer.constants.Constants
import java.util.*


object LocaleUtils {

    fun setLocale(context: Context, lang: String): Context? {
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val res: Resources = context.resources
        val conf = Configuration(res.configuration)
        conf.setLayoutDirection(locale)

        val savedLanguage = SharedStorageImpl(context, Constants.settings)
        savedLanguage.save(Constants.language, lang)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            conf.setLocale(locale)
            val localeList = LocaleList(locale)
            LocaleList.setDefault(localeList)
            conf.setLocales(localeList)
        } else {
            conf.locale = locale
            conf.setLocale(locale)
        }

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            context.createConfigurationContext(conf)
        } else {
            res.updateConfiguration(conf, res.displayMetrics)
            context
        }
    }

    fun onAttach(context: Context): Context? {
        return setLocale(context, getSavedLocale(context))
    }

    fun getSavedLocale(c: Context): String {
        val savedLanguage = SharedStorageImpl(c, Constants.settings)
        return savedLanguage.get(Constants.language, Constants.RU)
    }
}