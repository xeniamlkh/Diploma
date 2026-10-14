package com.example.diploma.ui.cards

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.databasemodule.domain.IDictionaryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WordCardsScreenViewModel(
    private val appRepository: IDictionaryRepository
) : ViewModel() {
    private val _state = MutableStateFlow(WordCardsUiState())
    val state: StateFlow<WordCardsUiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            appRepository.getWords().collect { words ->
                _state.update {
                    it.copy(
                        words = words,
                        currentIndex = it.currentIndex.coerceIn(
                            0,
                            (words.size - 1).coerceAtLeast(0)
                        )
                    )
                }
            }
        }
    }

    fun onCurrentIndexChange() {
        _state.update {
            if (it.currentIndex < it.words.lastIndex) {
                it.copy(
                    currentIndex = it.currentIndex + 1,
                    isFlipped = false
                )
            } else {
                it
            }
        }
    }

    fun onPreviousIndexChange() {
        _state.update {
            if (it.currentIndex > 0) {
                it.copy(
                    currentIndex = it.currentIndex - 1,
                    isFlipped = false
                )
            } else {
                it
            }
        }
    }

    fun onFlipChange(value: Boolean) {
        _state.update { it.copy(isFlipped = value) }
    }
}