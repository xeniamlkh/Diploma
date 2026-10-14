package com.example.diploma.ui

import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.databasemodule.domain.WordItem
import com.example.designlibrary.components.AppWordItem
import com.example.designlibrary.resources.Res
import com.example.designlibrary.resources.my_dictionary
import com.example.designlibrary.screens.AppScreen
import com.example.diploma.GetBottomBar

@Composable
fun WordListScreen(
    words: List<WordItem>,
    onAddWordClick: () -> Unit,
    onLearnWordClick: () -> Unit,
    onDeleteWordClick: (WordItem) -> Unit
) {
    AppScreen(
        titleRes = Res.string.my_dictionary,
        showBackButton = false,
        content = {
            items(words) { word ->
                AppWordItem(
                    word = word.word,
                    translation = word.translation,
                    example = word.example,
                    onDeleteClick = {
                        onDeleteWordClick(word)
                    }
                )
            }
        },
        bottomBar = {
            GetBottomBar(
                onAddWordClick = onAddWordClick,
                onLearnWordClick = onLearnWordClick
            )
        }
    )
}