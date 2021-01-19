package com.entezeer.kyrgyzprogrammer.ui.articles

import androidx.lifecycle.MutableLiveData
import com.entezeer.core.base.BaseViewModel
import com.entezeer.kyrgyzprogrammer.data.ContentRepository
import com.entezeer.kyrgyzprogrammer.data.models.Articles
import com.entezeer.kyrgyzprogrammer.data.models.Event
import javax.inject.Inject

class ArticlesViewModel @Inject constructor(private var articlesRepo: ContentRepository) : BaseViewModel<Event>() {

    val articles: MutableLiveData<ArrayList<Articles>> = MutableLiveData()

    fun fetchArticles() {
        runWithErrorHandling({
            articles.value = articlesRepo.getArticles()
        })
    }
}