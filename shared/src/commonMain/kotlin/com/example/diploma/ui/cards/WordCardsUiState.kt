package com.example.diploma.ui.cards

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.databasemodule.domain.WordItem

data class WordCardsUiState(
    val words: List<WordItem> = emptyList(),

    val currentIndex: Int = 0,
    val isFlipped: Boolean = false
)
