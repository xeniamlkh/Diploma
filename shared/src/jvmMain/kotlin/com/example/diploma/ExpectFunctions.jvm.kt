package com.example.diploma

import androidx.compose.runtime.Composable
import com.example.diploma.ui.addingWords.AddWordViewModel

actual fun showBackButton(): Boolean = true

@Composable
actual fun AppBackHandler(
    viewModel: AddWordViewModel,
    onBackClick: () -> Unit
) {}