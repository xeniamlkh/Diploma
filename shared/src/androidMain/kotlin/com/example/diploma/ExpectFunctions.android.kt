package com.example.diploma

import androidx.compose.runtime.Composable
import androidx.activity.compose.BackHandler
import com.example.diploma.ui.addingWords.AddWordViewModel

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