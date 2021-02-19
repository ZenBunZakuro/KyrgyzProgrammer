package com.entezeer.kyrgyzprogrammer.data.database

import androidx.room.*
import com.entezeer.kyrgyzprogrammer.data.models.Category
import com.entezeer.kyrgyzprogrammer.data.models.Lessons

@Dao
interface LessonsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertLessons(lessons: Lessons)

    @Query("SELECT * FROM lessons")
    fun getAllLessons(): List<Lessons>

    @Query("DELETE FROM lessons")
    fun deleteLessons()

    @Query("SELECT * FROM lessons WHERE category_id LIKE :categoryId")
    fun getLessonsByCategory(categoryId: Int): List<Lessons>
}