package com.entezeer.kyrgyzprogrammer.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class Category(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int? = null,
    var name: String = "",
    var img: String = ""
)