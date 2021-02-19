package com.entezeer.kyrgyzprogrammer.di.modules

import android.app.Application
import android.content.Context
import com.entezeer.kyrgyzprogrammer.data.database.KyrProDatabase
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun provideContext(application: Application): Context{
        return application
    }

    @Provides
    fun provideResource(context: Context) = context.resources!!

    @Provides
    fun provideAppDataBase(context: Context) = KyrProDatabase.getInstance(context)
}