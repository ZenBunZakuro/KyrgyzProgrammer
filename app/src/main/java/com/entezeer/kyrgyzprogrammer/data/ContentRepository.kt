package com.entezeer.kyrgyzprogrammer.data

import androidx.lifecycle.LiveData
import com.entezeer.kyrgyzprogrammer.data.api.ApiEndpoint
import com.entezeer.kyrgyzprogrammer.data.database.KyrProDatabase
import com.entezeer.kyrgyzprogrammer.data.models.Lessons
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContentRepository
@Inject constructor(
    private val service: ApiEndpoint,
    private val db: KyrProDatabase
) {
    fun getAllArticles() = db.getArticlesDao().getAllArticles()

    suspend fun getLessonsByCategory(categoryId: Int, lang: String) =
        withContext(Dispatchers.IO) {
            service.getLessonsByCategory(categoryId, lang)
        }

    suspend fun getArticles(lang: String) =
        withContext(Dispatchers.IO) {
            service.getArticles(lang).apply {
                db.getArticlesDao().deleteArticles()
                db.getArticlesDao().insertArticles(this)
            }
        }

    suspend fun getCategories(lang: String) =
        withContext(Dispatchers.IO) { service.getCategories(lang) }
}