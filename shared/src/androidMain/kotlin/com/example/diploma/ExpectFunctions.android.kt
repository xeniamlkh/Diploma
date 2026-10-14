package com.example.diploma

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.designlibrary.components.AppFilledButtonPhone
import com.example.designlibrary.resources.Res
import com.example.designlibrary.resources.add_new_word
import com.example.designlibrary.resources.ic_add
import com.example.designlibrary.resources.ic_selector_tool
import com.example.designlibrary.resources.start_study
import org.jetbrains.compose.resources.stringResource
import androidx.activity.compose.BackHandler
import com.example.diploma.ui.addingWords.AddWordViewModel

@Composable
actual fun GetBottomBar(
    onAddWordClick: () -> Unit,
    onLearnWordClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(Alignment.CenterVertically),
        verticalAlignment = Alignment.Top
    ) {
        AppFilledButtonPhone(
            modifier = Modifier.weight(1f),
            iconRes = Res.drawable.ic_add,
            buttonText = stringResource(Res.string.add_new_word),
            onClick = onAddWordClick
        )
        AppFilledButtonPhone(
            modifier = Modifier.weight(1f),
            iconRes = Res.drawable.ic_selector_tool,
            buttonText = stringResource(Res.string.start_study),
            onClick = onLearnWordClick
        )
    }
}

actual fun showBackButton(): Boolean = false

@Composable
actual fun AppBackHandler(
    viewModel: AddWordViewModel,
    onBackClick: () -> Unit
) {
    BackHandler {
        viewModel.onBackClick()
        onBackClick()
    }
}