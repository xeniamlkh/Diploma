package com.example.diploma.ui.cards

import com.example.databasemodule.domain.WordItem

data class WordCardsUiState(
    val words: List<WordItem> = emptyList(),

    val currentIndex: Int = 0,
    val isFlipped: Boolean = false
)
