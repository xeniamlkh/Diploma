package com.example.databasemodule.db

import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy
import androidx.room3.Query
import kotlinx.coroutines.flow.Flow

@Dao
internal interface DictionaryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertWord(wordEntity: WordEntity)

    @Query("DELETE FROM words WHERE word = :word")
    suspend fun deleteWord(word: String)

    @Query("SELECT * FROM words")
    fun loadAll(): Flow<List<WordEntity>>
}