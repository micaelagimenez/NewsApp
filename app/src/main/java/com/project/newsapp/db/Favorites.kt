package com.project.newsapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_table")
data class Favorites(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val image: String,
    val author: String,
    val date: String,
    val content: String,
    val favStatus: Int
)