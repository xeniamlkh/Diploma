package com.example.designlibrary.screens

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
import com.example.designlibrary.resources.add_new_topic
import com.example.designlibrary.resources.add_new_topic_explanation
import com.example.designlibrary.resources.ic_add
import com.example.designlibrary.resources.my_topics
import com.example.designlibrary.resources.no_topics
import com.example.designlibrary.resources.topics_start_warning
import com.example.designlibrary.theme.AppColors.TextPrimary
import com.example.designlibrary.theme.AppColors.TextSecondary
import org.jetbrains.compose.resources.stringResource

@Composable
fun EmptyScreen(
    onAddTopicClick: () -> Unit
) {
    AppScreen(
        titleRes = Res.string.my_topics,
        subTitleRes = Res.string.topics_start_warning,
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
                    text = stringResource(Res.string.add_new_topic_explanation),
                    fontSize = 17.sp,
                    lineHeight = 24.sp,
                    color = TextSecondary,
                    textAlign = TextAlign.Center
                )
            }
            AppScreenField {
                AppFullWidthFilledButton(
                    iconRes = Res.drawable.ic_add,
                    buttonText = stringResource(Res.string.add_new_topic),
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