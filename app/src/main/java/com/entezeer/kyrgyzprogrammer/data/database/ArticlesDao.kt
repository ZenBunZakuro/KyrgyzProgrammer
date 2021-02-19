package com.entezeer.kyrgyzprogrammer.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.entezeer.kyrgyzprogrammer.data.models.Articles

@Dao
interface ArticlesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertArticles(articles: List<Articles>)

    @Query("DELETE FROM articles")
    fun deleteArticles()

    @Query("SELECT * FROM articles")
    fun getAllArticles(): List<Articles>
}