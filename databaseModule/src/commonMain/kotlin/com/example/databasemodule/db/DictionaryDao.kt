package com.example.databasemodule.db

import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DictionaryDao {
    @Insert
    suspend fun insert(dictionaryEntity: DictionaryEntity)

    @Query("SELECT * FROM words")
    fun loadAll(): Flow<List<DictionaryEntity>>

    @Delete
    suspend fun deleteWord(dictionaryEntity: DictionaryEntity)
}