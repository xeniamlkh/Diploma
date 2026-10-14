package com.example.diploma.ui.addingWords

import androidx.compose.material3.SnackbarHostState

data class AddWordUiState(
    val word: String = "",
    val translation: String = "",
    val example: String = "",
    val isExampleError: Boolean = false,

    val snackbarHostState: SnackbarHostState = SnackbarHostState(),
    val wordIsSaved: Boolean = false,
    val disableSnackBar: Boolean = false
)