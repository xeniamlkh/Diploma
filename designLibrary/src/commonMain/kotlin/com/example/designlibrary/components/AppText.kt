package com.example.designlibrary.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.designlibrary.theme.AppColors.TextSecondary
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit.Companion

@Composable
fun AppText(
    text: String,
    fontSize: TextUnit = 17.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    lineHeight: TextUnit = TextUnit.Unspecified,
    color: Color,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        lineHeight = lineHeight,
        color = color,
        textAlign = textAlign
    )
}