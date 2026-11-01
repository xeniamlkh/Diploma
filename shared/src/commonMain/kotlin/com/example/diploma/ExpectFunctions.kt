package com.example.diploma

import androidx.compose.runtime.Composable
import com.example.diploma.ui.addingWords.AddWordViewModel

/** Показывать ли в TopBar кнопку назад */
expect fun showBackButton(): Boolean

@Composable
expect fun AppBackHandler(
    viewModel: AddWordViewModel,
    onBackClick: () -> Unit
)