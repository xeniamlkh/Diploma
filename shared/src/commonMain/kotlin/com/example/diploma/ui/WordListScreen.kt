package com.example.diploma.ui

import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.databasemodule.domain.WordItem
import com.example.designlibrary.components.AppFullWidthFilledButton
import com.example.designlibrary.components.AppWordItem
import com.example.designlibrary.components.appScreenField
import com.example.designlibrary.resources.Res
import com.example.designlibrary.resources.add_new_word
import com.example.designlibrary.resources.ic_add
import com.example.designlibrary.resources.my_dictionary
import com.example.designlibrary.screens.AppScreen
import org.jetbrains.compose.resources.stringResource

@Composable
fun WordListScreen(
    words: List<WordItem>,
    onAddWordClick: () -> Unit,
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

            appScreenField {
                AppFullWidthFilledButton(
                    iconRes = Res.drawable.ic_add,
                    buttonText = stringResource(Res.string.add_new_word),
                    onClick = onAddWordClick
                )
            }
        }
    )
}