package com.example.designlibrary.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designlibrary.resources.Res
import com.example.designlibrary.resources.back_btn_description
import com.example.designlibrary.resources.ic_arrow_back
import com.example.designlibrary.resources.my_topics
import com.example.designlibrary.resources.topics_start_warning
import com.example.designlibrary.theme.AppColors.TextPrimary
import com.example.designlibrary.theme.AppColors.TextSecondary
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun AppTopBar(
    titleRes: StringResource,
    subTitleRes: StringResource? = null,
    showBackButton: Boolean = false,
    onBackClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if (showBackButton) {
            AppTopBarIconButton(
                onClick = onBackClick ?: {},
                contentDescription = stringResource(Res.string.back_btn_description),
                iconId = Res.drawable.ic_arrow_back
            )
        }
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = stringResource(titleRes),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )

            if (subTitleRes != null) {
                Text(
                    text = stringResource(subTitleRes),
                    fontSize = 18.sp,
                    color = TextSecondary
                )
            }
        }
    }
}

@Preview
@Composable
private fun TempAppTopBarPreview() {
    AppTopBar(
        titleRes = Res.string.my_topics,
        subTitleRes = Res.string.topics_start_warning,
        showBackButton = false,
        onBackClick = {}
    )
}