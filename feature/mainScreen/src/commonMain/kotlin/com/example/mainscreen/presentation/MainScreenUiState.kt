package com.example.mainscreen.presentation

import com.example.databasemodule.domain.WordItem

data class MainScreenUiState(
    val words: List<WordItem> = emptyList()
)