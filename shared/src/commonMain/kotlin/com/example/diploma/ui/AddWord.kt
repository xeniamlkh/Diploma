package com.example.diploma.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.designlibrary.components.AppFullWidthFilledButton
import com.example.designlibrary.components.AppOutlinedTextField
import com.example.designlibrary.components.AppScreenField
import com.example.designlibrary.components.appScreenField
import com.example.designlibrary.resources.ic_save
import com.example.designlibrary.resources.new_word
import com.example.designlibrary.resources.save_btn
import com.example.designlibrary.resources.example
import com.example.designlibrary.screens.AppScreen
import com.example.designlibrary.theme.AppColors.PrimaryBlue
import com.example.designlibrary.theme.AppColors.TextPrimary
import com.example.designlibrary.theme.AppColors.TextSecondary
import com.example.designlibrary.resources.Res
import com.example.designlibrary.resources.translation
import com.example.designlibrary.resources.word
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AddWordScreen(
    viewModel: AddWordViewModel = koinViewModel(),
    onBackClick: () -> Unit = {},
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    with(state) {
        AppScreen(
            titleRes = Res.string.new_word,
            showBackButton = true,
            onBackClick = onBackClick,
            content = {
                appScreenField {
                    AppOutlinedTextField(
                        value = word,
                        onValueChange = viewModel::onWordChange,
                        placeholder = stringResource(Res.string.word),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                appScreenField {
                    AppOutlinedTextField(
                        value = translation,
                        onValueChange = viewModel::onTranslationChange,
                        placeholder = stringResource(Res.string.translation),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                appScreenField {
                    AppOutlinedTextField(
                        value = state.example,
                        onValueChange = viewModel::onExampleChange,
                        placeholder = stringResource(Res.string.example),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                appScreenField {
                    AppFullWidthFilledButton(
                        iconRes = Res.drawable.ic_save,
                        buttonText = stringResource(Res.string.save_btn),
                        onClick =  viewModel::addWord
                    )
                }
            }
        )
    }
}