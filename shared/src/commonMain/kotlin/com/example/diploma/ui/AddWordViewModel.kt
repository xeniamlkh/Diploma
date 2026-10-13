package com.example.diploma.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.databasemodule.domain.IDictionaryRepository
import com.example.databasemodule.domain.WordItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AddWordViewModel(
    private val appRepository: IDictionaryRepository
) : ViewModel() {
    private val _state = MutableStateFlow(AddWordUiState())
    val state: StateFlow<AddWordUiState> = _state.asStateFlow()

    fun onWordChange(value: String) {
        _state.update { it.copy(word = value, wordIsSaved = false) }
    }

    fun onTranslationChange(value: String) {
        _state.update { it.copy(translation = value) }
    }

    fun onExampleChange(value: String) {
        _state.update { it.copy(example = value) }
    }

    fun addWord() {
        val currentState = _state.value

        viewModelScope.launch {
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