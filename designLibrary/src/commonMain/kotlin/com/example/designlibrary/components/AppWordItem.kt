package com.example.designlibrary.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designlibrary.resources.Res
import com.example.designlibrary.resources.ic_delete
import com.example.designlibrary.theme.AppColors.PrimaryBlueLight
import com.example.designlibrary.theme.AppColors.TextPrimary
import com.example.designlibrary.theme.AppColors.TextSecondary
import org.jetbrains.compose.resources.painterResource

@Composable
fun AppWordItem(
    word: String,
    translation: String,
    example: String,
    onDeleteClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(PrimaryBlueLight)
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppText(
                text = word,
                fontSize = 21.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = onDeleteClick) {
                Icon(
                    painter = painterResource(Res.drawable.ic_delete),
                    contentDescription = "Delete word",
                    tint = TextSecondary
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        AppText(
            text = translation,
            fontSize = 17.sp,
            color = TextSecondary,
            textAlign = TextAlign.Start
        )
        if (example.isNotBlank()) {
            Spacer(modifier = Modifier.height(12.dp))
            AppText(
                text = example,
                fontSize = 15.sp,
                color = TextSecondary,
                textAlign = TextAlign.Start
            )
        }
    }
}