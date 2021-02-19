package com.entezeer.kyrgyzprogrammer.data.api

import com.entezeer.kyrgyzprogrammer.data.models.Articles
import com.entezeer.kyrgyzprogrammer.data.models.Category
import com.entezeer.kyrgyzprogrammer.data.models.Lessons
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndpoint {
    @GET("lessons/{lang}")
    suspend fun getLessons(@Path("lang") lang: String?): List<Lessons>

    @GET("articles/{lang}")
    suspend fun getArticles(@Path("lang") lang: String?): List<Articles>

    @GET("categories/{lang}")
    suspend fun getCategories(@Path("lang") lang: String?): List<Category>

    @GET("lessons_by_category/{id}/{lang}")
    suspend fun getLessonsByCategory(@Path("id") id: Int?, @Path("lang") lang: String?): List<Lessons>
}