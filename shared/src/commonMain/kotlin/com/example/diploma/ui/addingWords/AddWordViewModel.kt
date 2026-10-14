package com.example.diploma.ui.addingWords

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.databasemodule.domain.IDictionaryRepository
import com.example.databasemodule.domain.WordItem
import com.example.networkmodule.domain.ITatoebaApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AddWordViewModel(
    private val appRepository: IDictionaryRepository,
    private val sentenceService: ITatoebaApi
) : ViewModel() {
    private val _state = MutableStateFlow(AddWordUiState())
    val state: StateFlow<AddWordUiState> = _state.asStateFlow()

    fun onWordChange(value: String) {
        _state.update { it.copy(word = value, wordIsSaved = false) }
    }

    fun onWordFocusEnded() {
        val currentWord = _state.value.word
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val sentence = sentenceService.searchSentence(currentWord)
                _state.update { it.copy(example = sentence) }
            } catch (e: Exception) {
                _state.update { it.copy(example = e.message.toString()) }
            }
        }
    }

    fun onTranslationChange(value: String) {
        _state.update { it.copy(translation = value) }
    }

    fun onExampleChange(value: String) {
        _state.update { it.copy(example = value) }
    }

    fun addWord() {
        val currentState = _state.value

        viewModelScope.launch(Dispatchers.IO) {
            appRepository.addWord(
                WordItem(
                    word = currentState.word,
                    translation = currentState.translation,
                    example = currentState.example
                )
            )
        }

        _state.update {
            it.copy(
                word = "",
                translation = "",
                example = "",
                wordIsSaved = true
            )
        }
    }

    fun onBackClick() {
        _state.update {
            it.copy(
                disableSnackBar = true,
                wordIsSaved = false
            )
        }
    }
}