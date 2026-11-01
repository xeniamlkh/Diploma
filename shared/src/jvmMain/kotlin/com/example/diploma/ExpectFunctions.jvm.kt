package com.example.diploma

import androidx.compose.runtime.Composable
import com.example.diploma.ui.addingWords.AddWordViewModel

@Composable
actual fun AppBackHandler(
    viewModel: AddWordViewModel,
    onBackClick: () -> Unit
) {}