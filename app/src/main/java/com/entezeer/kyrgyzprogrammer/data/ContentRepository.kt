package com.entezeer.kyrgyzprogrammer.data

import com.entezeer.kyrgyzprogrammer.data.api.ApiEndpoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContentRepository
@Inject constructor(
    private val service: ApiEndpoint
){
    suspend fun getLessonsByCategory(categoryId: Int) = withContext(Dispatchers.IO) {service.getLessonsByCategory(categoryId)}
    suspend fun getArticles() = withContext(Dispatchers.IO) {service.getArticles()}
    suspend fun getCategories() = withContext(Dispatchers.IO) {service.getCategories()}
}