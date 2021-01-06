package com.entezeer.kyrgyzprogrammer.di.modules

import com.entezeer.kyrgyzprogrammer.data.api.ApiEndpoint
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideApiClient(): ApiEndpoint = getApiclient().create(ApiEndpoint::class.java)



    fun getApiclient(): Retrofit =
        Retrofit.Builder().baseUrl("https://kyrgyzprogrammer.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create()).build()
}