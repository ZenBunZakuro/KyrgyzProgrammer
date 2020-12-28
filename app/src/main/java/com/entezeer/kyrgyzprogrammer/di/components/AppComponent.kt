package com.entezeer.kyrgyzprogrammer.di.components

import android.app.Application
import android.os.Build
import com.entezeer.kyrgyzprogrammer.App
import com.entezeer.kyrgyzprogrammer.di.modules.ActivityModule
import com.entezeer.kyrgyzprogrammer.di.modules.FragmentModule
import com.entezeer.kyrgyzprogrammer.di.modules.NetworkModule
import com.entezeer.kyrgyzprogrammer.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        ActivityModule::class,
        FragmentModule::class]
)

interface AppComponent: AndroidInjector<App> {

    fun inject(application: Application)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun applicationBind(application: Application): Builder
    }
}