package com.entezeer.kyrgyzprogrammer.data.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lessons")
data class Lessons(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int? = null,
    val title: String = "",
    val img: String = "",
    val content: String = "",
    val date: String = "",
    @Embedded(prefix = "category_")
    val category: Category? = null
)