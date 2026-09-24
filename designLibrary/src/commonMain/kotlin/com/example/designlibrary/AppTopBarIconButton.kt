package com.example.designlibrary

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun AppTopBarIconButton(
    enabled: Boolean = true,
    onClick: () -> Unit,
    iconId: DrawableResource,
    //iconId: ImageVector,
    contentDescription: String,
    size: Dp = 28.dp
) {
    IconButton(
        modifier = Modifier
            .padding(end = 5.dp)
            .clip(RoundedCornerShape(16.dp)),
        colors = IconButtonDefaults.iconButtonColors().copy(
            containerColor = colorScheme.primary,
            contentColor = colorScheme.surfaceContainer
        ),
        enabled = enabled,
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier.size(size),
            painter = painterResource(iconId),
            //imageVector = iconId,
            contentDescription = contentDescription,
            tint = colorScheme.surfaceContainer
        )
    }
}