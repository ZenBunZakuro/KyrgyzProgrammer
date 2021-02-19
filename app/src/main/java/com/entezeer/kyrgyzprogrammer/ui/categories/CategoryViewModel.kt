package com.entezeer.kyrgyzprogrammer.ui.categories

import androidx.lifecycle.MutableLiveData
import com.entezeer.core.base.BaseViewModel
import com.entezeer.kyrgyzprogrammer.data.ContentRepository
import com.entezeer.kyrgyzprogrammer.data.models.Category
import com.entezeer.kyrgyzprogrammer.data.models.Event
import javax.inject.Inject

class CategoryViewModel @Inject constructor(private var categoryRepo: ContentRepository) : BaseViewModel<Event>() {


    val categories: MutableLiveData<List<Category>> = MutableLiveData()

    fun fetchCategories(lang: String) {
        runWithErrorHandling({
            categories.value = categoryRepo.getCategories(lang)
        })
    }
}