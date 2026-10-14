package com.example.diploma.ui.cards

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.designlibrary.components.AppFlipWordCard
import com.example.designlibrary.components.AppText
import com.example.designlibrary.components.appScreenField
import com.example.designlibrary.resources.Res
import com.example.designlibrary.resources.my_dictionary
import com.example.designlibrary.resources.tap_to_flip
import com.example.designlibrary.screens.AppScreen
import com.example.designlibrary.theme.AppColors.TextSecondary
import com.example.diploma.showBackButton
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

/** Страница изучения слов */
@Composable
fun WordCardsScreen(
    viewModel: WordCardsScreenViewModel = koinViewModel(),
    onBackClick: () -> Unit = {}
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    with(state) {
        AppScreen(
            titleRes = Res.string.my_dictionary,
            showBackButton = showBackButton(),
            onBackClick = onBackClick,
            content = {
                if (words.isNotEmpty()) {
                    appScreenField {
                        AppText(
                            text = "${currentIndex + 1} / ${words.size}",
                            color = TextSecondary
                        )
                    }
                    appScreenField {
                        val word = words[currentIndex]
                        AppFlipWordCard(
                            word = word.word,
                            translation = word.translation,
                            example = word.example,
                            isFlipped = isFlipped,
                            onFlipClick = {
                                viewModel.onFlipChange(!state.isFlipped)
                            },
                            onSwipeLeft = {
                                viewModel.onCurrentIndexChange()
                            },
                            onSwipeRight = {
                                viewModel.onPreviousIndexChange()
                            }
                        )
                    }
                    appScreenField {
                        AppText(
                            text = stringResource(
                                Res.string.tap_to_flip
                            ),
                            color = TextSecondary
                        )
                    }
                }
            }
        )
    }
}