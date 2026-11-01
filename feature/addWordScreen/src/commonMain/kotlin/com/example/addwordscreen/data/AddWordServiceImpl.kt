package com.example.addwordscreen.data

import com.example.addwordscreen.domain.AddWordService
import com.example.databasemodule.domain.IDictionaryRepository
import com.example.databasemodule.domain.WordItem
import com.example.networkmodule.domain.ITatoebaApi

class AddWordServiceImpl(
    private val appRepository: IDictionaryRepository,
    private val sentenceService: ITatoebaApi
) : AddWordService {
    override suspend fun addWord(wordItem: WordItem) {
        appRepository.addWord(
            wordItem
        )
    }

    override suspend fun searchSentence(currentWord: String): String {
        return sentenceService.searchSentence(currentWord)
    }
}