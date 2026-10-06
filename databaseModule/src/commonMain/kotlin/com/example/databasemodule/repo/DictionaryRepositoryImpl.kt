package com.example.databasemodule.repo

import com.example.databasemodule.db.DictionaryDao
import com.example.databasemodule.domain.IDictionaryRepository
import com.example.databasemodule.domain.WordItem
import com.example.databasemodule.utils.toEntity

internal class DictionaryRepositoryImpl(private val dictionaryDao: DictionaryDao) : IDictionaryRepository {
    override suspend fun addWord(wordItem: WordItem) {
        dictionaryDao.insert(dictionaryEntity = wordItem.toEntity())
    }

    override suspend fun deleteWord(wordItem: WordItem) {
        dictionaryDao.deleteWord(dictionaryEntity = wordItem.toEntity())
    }
}