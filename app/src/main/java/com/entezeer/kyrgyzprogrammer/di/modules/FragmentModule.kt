package com.entezeer.kyrgyzprogrammer.di.modules

import com.entezeer.kyrgyzprogrammer.ui.fragments.articles.ArticlesFragment
import com.entezeer.kyrgyzprogrammer.ui.fragments.categories.CategoriesFragment
import com.entezeer.kyrgyzprogrammer.ui.fragments.favorite.FavoriteFragment
import com.entezeer.kyrgyzprogrammer.ui.fragments.home.HomeFragment
import com.entezeer.kyrgyzprogrammer.ui.fragments.lessons.LessonsContainerFragment
import com.entezeer.kyrgyzprogrammer.ui.fragments.lessons.LessonsFragment
import com.entezeer.kyrgyzprogrammer.ui.fragments.settings.SettingsFragment
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