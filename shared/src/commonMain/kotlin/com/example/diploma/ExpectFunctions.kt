package com.example.diploma

import androidx.compose.runtime.Composable

/** Bottom bar в зависимости от ОС */
@Composable
expect fun GetBottomBar(
    onAddWordClick: () -> Unit,
    onLearnWordClick: () -> Unit,
)