package com.example.diploma.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.databasemodule.domain.WordItem
import com.example.designlibrary.components.AppFilledButton
import com.example.designlibrary.components.AppFullWidthFilledButton
import com.example.designlibrary.components.AppWordItem
import com.example.designlibrary.components.appScreenField
import com.example.designlibrary.resources.Res
import com.example.designlibrary.resources.add_new_word
import com.example.designlibrary.resources.ic_add
import com.example.designlibrary.resources.ic_selector_tool
import com.example.designlibrary.resources.my_dictionary
import com.example.designlibrary.resources.start_study
import com.example.designlibrary.screens.AppScreen
import org.jetbrains.compose.resources.stringResource

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

            appScreenField {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    AppFilledButton(
                        iconRes = Res.drawable.ic_add,
                        buttonText = stringResource(Res.string.add_new_word),
                        onClick = onAddWordClick
                    )
                    AppFilledButton(
                        iconRes = Res.drawable.ic_selector_tool,
                        buttonText = stringResource(Res.string.start_study),
                        onClick = onLearnWordClick
                    )
                }
            }
        }
    )
}