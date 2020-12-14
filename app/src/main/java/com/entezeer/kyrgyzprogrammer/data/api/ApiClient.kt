package com.entezeer.kyrgyzprogrammer.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    fun getApiclient(): Retrofit =
        Retrofit.Builder().baseUrl("https://kyrgyzprogrammer.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create()).build()
}