package com.example.designlibrary.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designlibrary.theme.AppColors.PrimaryBlueLight
import com.example.designlibrary.theme.AppColors.TextPrimary
import com.example.designlibrary.theme.AppColors.TextSecondary

@Composable
fun AppFlipWordCard(
    word: String,
    translation: String,
    example: String,
    isFlipped: Boolean,
    onFlipClick: () -> Unit,
    onSwipeLeft: () -> Unit,
    onSwipeRight: () -> Unit,
    modifier: Modifier = Modifier
) {
    val rotation by animateFloatAsState(
        targetValue = if (isFlipped) 180f else 0f,
        label = "cardRotation"
    )

    val swipeThreshold = with(LocalDensity.current) {
        80.dp.toPx()
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(360.dp)
            .pointerInput(Unit) {
                var totalDrag = 0f
                detectHorizontalDragGestures(
                    onHorizontalDrag = { change, dragAmount ->
                        change.consume()
                        totalDrag += dragAmount
                    },
                    onDragEnd = {
                        val shouldSwipeLeft = totalDrag < -swipeThreshold
                        val shouldSwipeRight = totalDrag > swipeThreshold
                        totalDrag = 0f
                        when {
                            shouldSwipeLeft -> onSwipeLeft()
                            shouldSwipeRight -> onSwipeRight()
                        }
                    },
                    onDragCancel = {
                        totalDrag = 0f
                    }
                )
            }
            .clickable(onClick = onFlipClick),
        contentAlignment = Alignment.Center
    ) {
        val showFront = rotation <= 90f

        Column(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    rotationY = rotation
                    cameraDistance = 12 * density
                }
                .clip(RoundedCornerShape(24.dp))
                .background(PrimaryBlueLight)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (showFront) {
                AppText(
                    text = word,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
            } else {
                Column(
                    modifier = Modifier.graphicsLayer {
                        rotationY = 180f
                    },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    AppText(
                        text = translation,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = TextPrimary
                    )

                    if (example.isNotBlank()) {
                        Spacer(modifier = Modifier.height(20.dp))

                        AppText(
                            text = example,
                            fontSize = 17.sp,
                            color = TextSecondary
                        )
                    }
                }
            }
        }
    }
}