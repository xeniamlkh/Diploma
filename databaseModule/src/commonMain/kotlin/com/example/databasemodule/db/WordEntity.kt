package com.example.databasemodule.db

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "words")
internal data class WordEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val word: String,
    val translation: String,
    val example: String
)