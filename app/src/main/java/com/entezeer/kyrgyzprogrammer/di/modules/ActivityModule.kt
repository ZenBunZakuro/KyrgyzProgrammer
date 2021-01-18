package com.entezeer.kyrgyzprogrammer.di.modules

import com.entezeer.kyrgyzprogrammer.MainActivity
import com.entezeer.kyrgyzprogrammer.ui.activities.ArticlesContentActivity
import com.entezeer.kyrgyzprogrammer.ui.activities.LessonContentActivity
import com.entezeer.kyrgyzprogrammer.ui.activities.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeLessonContentActivity(): LessonContentActivity

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun contributeArticleContentActivity(): ArticlesContentActivity
}