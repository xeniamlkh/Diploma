package com.example.designlibrary.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.designlibrary.resources.Res
import com.example.designlibrary.resources.ic_add
import com.example.designlibrary.resources.ic_add_ad
import com.example.designlibrary.theme.AppColors.PrimaryBlue
import com.example.designlibrary.theme.AppColors.PrimaryBlueLight
import com.example.designlibrary.theme.AppColors.PrimaryCornFlowerBlue
import org.jetbrains.compose.resources.painterResource

/** Картинка папки для главного (пустого) экрана */
@Composable
fun FolderIllustration() {
    Surface(
        modifier = Modifier.size(150.dp),
        shape = CircleShape,
        color = PrimaryBlueLight
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_add_ad),
                contentDescription = null,
                tint = PrimaryCornFlowerBlue,
                modifier = Modifier.size(92.dp)
            )
        }
    }
}