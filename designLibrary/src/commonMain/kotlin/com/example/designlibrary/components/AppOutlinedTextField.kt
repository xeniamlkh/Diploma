package com.example.designlibrary.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.designlibrary.theme.AppColors.ErrorColor
import com.example.designlibrary.theme.AppColors.PrimaryBlue
import com.example.designlibrary.theme.AppColors.TextPrimary
import com.example.designlibrary.theme.AppColors.TextSecondary

@Composable
fun AppOutlinedTextField(
    value: String,
    testTag: String = "",
    errorTestTag: String = "",
    onValueChange: (String) -> Unit,
    placeholder: String,
    singleLine: Boolean = true,
    focusRequester: FocusRequester = FocusRequester(),
    onFocus: () -> Unit = {},
    onFocusEnded: () -> Unit = {},
    isError: Boolean = false,
    errorText: String = "",
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .testTag(testTag)
            .fillMaxWidth()
            .focusRequester(focusRequester)
            .onFocusChanged(
                onFocusChanged = {
                    if (it.isFocused) onFocus() else onFocusEnded()
                }
            ),
        placeholder = { Text(text = placeholder) },
        singleLine = singleLine,
        shape = RoundedCornerShape(14.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = PrimaryBlue,
            unfocusedBorderColor = TextSecondary,
            focusedTextColor = TextPrimary,
            unfocusedTextColor = TextPrimary
        )
    )
    AnimatedVisibility(
        visible = isError,
        enter = expandVertically(),
        exit = shrinkVertically()
    ) {
        Text(
            modifier = Modifier
                .testTag(errorTestTag)
                .padding(horizontal = 16.dp),
            text = errorText,
            style = typography.bodySmall.merge(TextStyle(color = ErrorColor))
        )
    }
}
