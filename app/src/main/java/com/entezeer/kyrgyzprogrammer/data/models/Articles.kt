package com.entezeer.kyrgyzprogrammer.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="articles")
data class Articles(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int? = null,
    val title: String = "",
    val img: String = "",
    val content: String = ""
)

