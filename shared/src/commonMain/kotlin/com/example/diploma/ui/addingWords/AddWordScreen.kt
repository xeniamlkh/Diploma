package com.example.diploma.ui.addingWords

import androidx.compose.material3.SnackbarDuration
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.designlibrary.components.AppFullWidthFilledButton
import com.example.designlibrary.components.AppOutlinedTextField
import com.example.designlibrary.components.appScreenField
import com.example.designlibrary.resources.ic_save
import com.example.designlibrary.resources.new_word
import com.example.designlibrary.resources.save_btn
import com.example.designlibrary.resources.example
import com.example.designlibrary.screens.AppScreen
import com.example.designlibrary.resources.Res
import com.example.designlibrary.resources.example_is_saved
import com.example.designlibrary.resources.network_error
import com.example.designlibrary.resources.network_error_hint
import com.example.designlibrary.resources.translation
import com.example.designlibrary.resources.word
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AddWordScreen(
    viewModel: AddWordViewModel = koinViewModel(),
    onBackClick: () -> Unit = {},
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    with(state) {

        LaunchedEffect(disableSnackBar) {
            if (disableSnackBar) {
                snackbarHostState.currentSnackbarData?.dismiss()
            }
        }

        LaunchedEffect(wordIsSaved) {
            if (wordIsSaved) {
                snackbarHostState.showSnackbar(
                    message = getString(Res.string.example_is_saved),
                    withDismissAction = true,
                    duration = SnackbarDuration.Short
                )
            }
        }
        AppScreen(
            titleRes = Res.string.new_word,
            showBackButton = true,
            onBackClick = {
                viewModel.onBackClick()
                onBackClick()
            },
            snackBarHostState = snackbarHostState,
            content = {
                appScreenField {
                    AppOutlinedTextField(
                        value = word,
                        onValueChange = viewModel::onWordChange,
                        placeholder = stringResource(Res.string.word),
                        onFocusEnded = viewModel::onWordFocusEnded
                    )
                }
                appScreenField {
                    AppOutlinedTextField(
                        value = translation,
                        onValueChange = viewModel::onTranslationChange,
                        placeholder = stringResource(Res.string.translation)
                    )
                }
                appScreenField {
                    AppOutlinedTextField(
                        value = if (!isExampleError) state.example else stringResource(Res.string.network_error),
                        onValueChange = viewModel::onExampleChange,
                        placeholder = stringResource(Res.string.example),
                        isError = isExampleError,
                        errorText = stringResource(Res.string.network_error_hint)
                    )
                }
                appScreenField {
                    AppFullWidthFilledButton(
                        iconRes = Res.drawable.ic_save,
                        buttonText = stringResource(Res.string.save_btn),
                        onClick = viewModel::addWord
                    )
                }
            }
        )
    }
}