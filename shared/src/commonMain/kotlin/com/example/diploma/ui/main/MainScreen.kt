package com.example.diploma.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.diploma.ui.EmptyScreen
import com.example.diploma.ui.WordListScreen
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = koinViewModel(),
    onAddWordClick: () -> Unit,
    onLearnWordClick: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    with(state) {
        if (words.isEmpty()) {
            EmptyScreen(
                onAddWordClick = onAddWordClick
            )
        } else {
            WordListScreen(
                words = state.words,
                onAddWordClick = onAddWordClick,
                onLearnWordClick = onLearnWordClick,
                onDeleteWordClick = viewModel::deleteWord
            )
        }
    }
}