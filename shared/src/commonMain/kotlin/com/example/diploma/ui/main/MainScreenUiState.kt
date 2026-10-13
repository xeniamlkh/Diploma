package com.example.diploma.ui.main

import com.example.databasemodule.domain.WordItem

data class MainScreenUiState(
    val words: List<WordItem> = emptyList()
)
