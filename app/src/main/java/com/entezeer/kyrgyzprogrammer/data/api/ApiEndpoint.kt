package com.entezeer.kyrgyzprogrammer.data.api

import com.entezeer.kyrgyzprogrammer.data.models.Lessons
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("lessons")
    fun getLessons(): Call<ArrayList<Lessons>>
}