package com.example.diploma

import androidx.compose.runtime.Composable
import com.example.diploma.ui.addingWords.AddWordViewModel

/** Bottom bar в зависимости от ОС */
@Composable
expect fun GetBottomBar(
    onAddWordClick: () -> Unit,
    onLearnWordClick: () -> Unit,
)

/** Показывать ли в TopBar кнопку назад */
expect fun showBackButton(): Boolean

@Composable
expect fun AppBackHandler(
    viewModel: AddWordViewModel,
    onBackClick: () -> Unit
)