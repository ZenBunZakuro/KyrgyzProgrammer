package com.entezeer.kyrgyzprogrammer.di.modules

import com.entezeer.kyrgyzprogrammer.ui.articles.ArticlesFragment
import com.entezeer.kyrgyzprogrammer.ui.categories.CategoriesFragment
import com.entezeer.kyrgyzprogrammer.ui.favorite.FavoriteFragment
import com.entezeer.kyrgyzprogrammer.ui.home.HomeFragment
import com.entezeer.kyrgyzprogrammer.ui.lessons.LessonsContainerFragment
import com.entezeer.kyrgyzprogrammer.ui.lessons.LessonsFragment
import com.entezeer.kyrgyzprogrammer.ui.settings.SettingsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeArticlesFragment(): ArticlesFragment

    @ContributesAndroidInjector
    abstract fun contributeLessonFragment(): LessonsFragment

    @ContributesAndroidInjector
    abstract fun contributeLessonContainerFragment(): LessonsContainerFragment

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeFavoriteFragment(): FavoriteFragment

    @ContributesAndroidInjector
    abstract fun contributeCategoriesFragment(): CategoriesFragment

    @ContributesAndroidInjector
    abstract fun contributeSettingsFragment(): SettingsFragment
}