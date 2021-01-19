package com.entezeer.kyrgyzprogrammer.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.entezeer.kyrgyzprogrammer.di.factory.ViewModelFactory
import com.entezeer.kyrgyzprogrammer.di.factory.ViewModelKey
import com.entezeer.kyrgyzprogrammer.ui.articles.ArticlesViewModel
import com.entezeer.kyrgyzprogrammer.ui.categories.CategoryViewModel
import com.entezeer.kyrgyzprogrammer.ui.favorite.FavoriteViewModel
import com.entezeer.kyrgyzprogrammer.ui.lessons.LessonsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(LessonsViewModel::class)
    abstract fun bindLessonsViewModel(vm: LessonsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CategoryViewModel::class)
    abstract fun bindCategoryViewModel(vm: CategoryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    abstract fun bindFavoriteViewModel(vm: FavoriteViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ArticlesViewModel::class)
    abstract fun bindArticlesViewModel(vm: ArticlesViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}