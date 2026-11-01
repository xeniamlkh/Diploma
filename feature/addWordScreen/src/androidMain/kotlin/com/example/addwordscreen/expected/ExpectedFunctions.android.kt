package com.example.addwordscreen.expected

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import com.example.addwordscreen.presentation.AddWordViewModel

actual fun showBackButton(): Boolean = false

@Composable
actual fun AppBackHandler(
    viewModel: AddWordViewModel,
    onBackClick: () -> Unit
) {
    BackHandler {
        viewModel.onBackClick()
        onBackClick()
    }
}