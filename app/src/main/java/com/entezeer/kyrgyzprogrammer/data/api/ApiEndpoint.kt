package com.entezeer.kyrgyzprogrammer.data.api

import com.entezeer.kyrgyzprogrammer.data.models.Articles
import com.entezeer.kyrgyzprogrammer.data.models.Category
import com.entezeer.kyrgyzprogrammer.data.models.Lessons
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndpoint {
    @GET("lessons")
    suspend fun getLessons(): ArrayList<Lessons>

    @GET("articles")
    suspend fun getArticles(): ArrayList<Articles>

    @GET("categories")
    suspend fun getCategories(): ArrayList<Category>

    @GET("lessons_by_category/{id}")
    suspend fun getLessonsByCategory(@Path("id") id: Int?): ArrayList<Lessons>
}