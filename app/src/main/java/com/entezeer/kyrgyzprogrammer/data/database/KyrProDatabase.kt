package com.entezeer.kyrgyzprogrammer.data.database

import android.content.Context
import androidx.room.*
import com.entezeer.kyrgyzprogrammer.data.models.Articles
import com.entezeer.kyrgyzprogrammer.data.models.Category
import com.entezeer.kyrgyzprogrammer.data.models.Lessons

@Database(
    entities = [Lessons::class, Articles::class, Category::class],
    version = 1,
    exportSchema = false
)

abstract class KyrProDatabase : RoomDatabase() {
    abstract fun getLessonsDao(): LessonsDao
    abstract fun getArticlesDao(): ArticlesDao

    companion object {
        @Volatile
        private var instance: KyrProDatabase? = null

        @Synchronized
        fun getInstance(context: Context): KyrProDatabase {
            if(instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    KyrProDatabase::class.java,
                    "ky_pro_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(object : RoomDatabase.Callback(){}).allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }
}