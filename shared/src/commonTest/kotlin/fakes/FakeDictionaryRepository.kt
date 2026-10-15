package fakes

import com.example.databasemodule.domain.IDictionaryRepository
import com.example.databasemodule.domain.WordItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class FakeDictionaryRepository(initial: List<WordItem> = emptyList()) : IDictionaryRepository {
    val words = MutableStateFlow(initial)

    override fun getWords(): Flow<List<WordItem>> = words

    override suspend fun addWord(wordItem: WordItem) {
        words.update { it + wordItem }
    }

    override suspend fun deleteWord(wordItem: WordItem) {
        words.update { it - wordItem }
    }
}