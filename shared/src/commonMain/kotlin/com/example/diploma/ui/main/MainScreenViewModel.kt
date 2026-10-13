package com.example.diploma.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.databasemodule.domain.IDictionaryRepository
import com.example.databasemodule.domain.WordItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val appRepository: IDictionaryRepository
) : ViewModel() {
    private val _state = MutableStateFlow(MainScreenUiState())
    val state: StateFlow<MainScreenUiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            appRepository.getWords().collect { words ->
                _state.update {
                    it.copy(words = words)
                }
            }
        }
    }

    fun deleteWord(word: WordItem) {
        viewModelScope.launch {
            appRepository.deleteWord(word)
        }
    }
}