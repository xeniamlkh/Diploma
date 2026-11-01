package com.example.addwordscreen.expected

import androidx.compose.runtime.Composable
import com.example.addwordscreen.presentation.AddWordViewModel

/** Показывать ли в TopBar кнопку назад */
expect fun showBackButton(): Boolean

@Composable
expect fun AppBackHandler(
    viewModel: AddWordViewModel,
    onBackClick: () -> Unit
)
