package com.entezeer.kyrgyzprogrammer.di.modules

import com.entezeer.kyrgyzprogrammer.BuildConfig
import com.entezeer.kyrgyzprogrammer.data.api.ApiEndpoint
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import javax.net.ssl.HostnameVerifier

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideApiClient(okHttpClient: OkHttpClient): ApiEndpoint = getApiclient(okHttpClient).create(ApiEndpoint::class.java)

    fun getApiclient(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl("https://kyrgyzprogrammer.herokuapp.com/api/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()

        client.hostnameVerifier(HostnameVerifier { _, _ -> true })
        if(BuildConfig.DEBUG){
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(interceptor)
        }
        return client.build()
    }
}