package com.entezeer.kyrgyzprogrammer

import android.content.Context
import android.content.res.Configuration
import com.entezeer.core.utils.LocaleUtils
import com.entezeer.core.utils.ThemeUtils
import com.entezeer.kyrgyzprogrammer.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
       return DaggerAppComponent.builder().applicationBind(this).build()
    }

    override fun onCreate() {
        super.onCreate()
        ThemeUtils.updateTheme(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base?.let { LocaleUtils.setLocale(it) })
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleUtils.setLocale(this)
    }
}