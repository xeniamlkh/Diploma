package com.example.databasemodule.repo

import com.example.databasemodule.db.DictionaryDao
import com.example.databasemodule.domain.IDictionaryRepository
import com.example.databasemodule.domain.WordItem
import com.example.databasemodule.utils.toEntity
import com.example.databasemodule.utils.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.collections.map

internal class DictionaryRepositoryImpl(private val dictionaryDao: DictionaryDao) :
    IDictionaryRepository {

    override suspend fun addWord(wordItem: WordItem) {
        dictionaryDao.insertWord(wordEntity = wordItem.toEntity())
    }

    override suspend fun deleteWord(wordItem: WordItem) {
        dictionaryDao.deleteWord(wordItem.word)
    }

    override fun getWords(): Flow<List<WordItem>> {
        return dictionaryDao.loadAll().map { words ->
            words.map { word -> word.toModel() }
        }
    }
}