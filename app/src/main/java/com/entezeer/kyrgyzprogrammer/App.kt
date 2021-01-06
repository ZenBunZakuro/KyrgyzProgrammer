package com.entezeer.kyrgyzprogrammer

import com.entezeer.kyrgyzprogrammer.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
       return DaggerAppComponent.builder().applicationBind(this).build()
    }
}