package com.example.addwordscreen.expected

import androidx.compose.runtime.Composable
import com.example.addwordscreen.presentation.AddWordViewModel

actual fun showBackButton(): Boolean = true

@Composable
actual fun AppBackHandler(
    viewModel: AddWordViewModel,
    onBackClick: () -> Unit
) {}