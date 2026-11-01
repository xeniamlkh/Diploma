package com.example.addwordscreen.domain

import com.example.databasemodule.domain.WordItem

interface AddWordService {
    suspend fun addWord(wordItem: WordItem)
    suspend fun searchSentence(currentWord: String): String
}