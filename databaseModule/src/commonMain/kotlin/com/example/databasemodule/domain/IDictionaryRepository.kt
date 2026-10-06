package com.example.databasemodule.domain

interface IDictionaryRepository {

    suspend fun addWord(wordItem: WordItem)

    suspend fun deleteWord(wordItem: WordItem)
}