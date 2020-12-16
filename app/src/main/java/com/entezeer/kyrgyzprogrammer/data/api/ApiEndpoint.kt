package com.entezeer.kyrgyzprogrammer.data.api

import com.entezeer.kyrgyzprogrammer.data.models.Articles
import com.entezeer.kyrgyzprogrammer.data.models.Category
import com.entezeer.kyrgyzprogrammer.data.models.Lessons
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndpoint {
    @GET("lessons")
    fun getLessons(): Call<ArrayList<Lessons>>

    @GET("articles")
    fun getArticles(): Call<ArrayList<Articles>>

    @GET("categories")
    fun getCategories(): Call<ArrayList<Category>>

    @GET("lessons_by_category/{id}")
    fun getLessonsByCategory(@Path("id") id: Int?): Call<ArrayList<Lessons>>
}