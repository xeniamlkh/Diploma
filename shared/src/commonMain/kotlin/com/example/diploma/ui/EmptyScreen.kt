package com.example.diploma.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.designlibrary.components.AppFullWidthFilledButton
import com.example.designlibrary.components.AppScreenField
import com.example.designlibrary.components.AppText
import com.example.designlibrary.components.FolderIllustration
import com.example.designlibrary.resources.Res
import com.example.designlibrary.resources.add_new_word
import com.example.designlibrary.resources.add_new_words_explanation
import com.example.designlibrary.resources.ic_add
import com.example.designlibrary.resources.my_dictionary
import com.example.designlibrary.resources.no_topics
import com.example.designlibrary.resources.words_start_warning
import com.example.designlibrary.screens.AppScreen
import com.example.designlibrary.theme.AppColors.TextPrimary
import com.example.designlibrary.theme.AppColors.TextSecondary
import org.jetbrains.compose.resources.stringResource

@Composable
fun EmptyScreen(onAddTopicClick: () -> Unit) {
    AppScreen(
        titleRes = Res.string.my_dictionary,
        subTitleRes = Res.string.words_start_warning,
        showBackButton = false,
        onBackClick = {},
        content = {
            AppScreenField {
                FolderIllustration()
            }
            AppScreenField {
                AppText(
                    text = stringResource(Res.string.no_topics),
                    fontSize = 23.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextPrimary,
                    textAlign = TextAlign.Center
                )
            }
            AppScreenField {
                AppText(
                    text = stringResource(Res.string.add_new_words_explanation),
                    fontSize = 17.sp,
                    lineHeight = 24.sp,
                    color = TextSecondary,
                    textAlign = TextAlign.Center
                )
            }
            AppScreenField {
                AppFullWidthFilledButton(
                    iconRes = Res.drawable.ic_add,
                    buttonText = stringResource(Res.string.add_new_word),
                    onClick = onAddTopicClick
                )
            }
        }
    )
}

@Preview
@Composable
fun EmptyScreenPreview() {
    EmptyScreen(
        onAddTopicClick = {}
    )
}