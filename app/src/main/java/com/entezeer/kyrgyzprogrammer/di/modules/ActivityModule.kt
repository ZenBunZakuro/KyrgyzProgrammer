package com.entezeer.kyrgyzprogrammer.di.modules

import com.entezeer.kyrgyzprogrammer.ui.main.MainActivity
import com.entezeer.kyrgyzprogrammer.ui.articles.ArticlesContentActivity
import com.entezeer.kyrgyzprogrammer.ui.lessons.LessonContentActivity
import com.entezeer.kyrgyzprogrammer.ui.splash.SplashActivity
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