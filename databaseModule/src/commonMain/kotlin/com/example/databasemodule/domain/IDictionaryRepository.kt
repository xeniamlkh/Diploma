package com.example.databasemodule.domain

import kotlinx.coroutines.flow.Flow

interface IDictionaryRepository {

    suspend fun addWord(wordItem: WordItem)

    suspend fun deleteWord(wordItem: WordItem)

    fun getWords(): Flow<List<WordItem>>
}