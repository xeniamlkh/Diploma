package com.example.databasemodule.db

import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy
import androidx.room3.Query
import kotlinx.coroutines.flow.Flow

@Dao
internal interface DictionaryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertWord(wordEntity: WordEntity): Long

    @Query("DELETE FROM words WHERE word = :word")
    suspend fun deleteWord(word: String)

    @Query("SELECT * FROM words")
    fun loadAll(): Flow<List<WordEntity>>

    @Query("SELECT * FROM words WHERE id = :id")
    suspend fun getById(id: Long): WordEntity
}