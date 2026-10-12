package com.example.designlibrary.screens

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.designlibrary.components.AppTopBar
import org.jetbrains.compose.resources.StringResource

/** Единый шаблон экрана для всего приложения (LazyColumn)
 * @param titleRes Название экрана
 * @param subTitleRes Подзаголовок экрана, описание
 * @param showBackButton Показывать ли кнопку назад (Для jvm)
 * @param onBackClick Функция, которую нужно выполнять при нажатии на кнопку назад
 * @param scrollState //TODO
 * @param content Содержимое экрана
 * */
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun AppScreen(
    titleRes: StringResource,
    subTitleRes: StringResource? = null,
    showBackButton: Boolean = false,
    onBackClick: (() -> Unit)? = null,
    scrollState: LazyListState = rememberLazyListState(),
    content: LazyListScope.() -> Unit
) {
    Scaffold(
        containerColor = Color.White,
        modifier = Modifier.imePadding(),
        topBar = {
            AppTopBar(
                titleRes = titleRes,
                subTitleRes = subTitleRes,
                showBackButton = showBackButton,
                onBackClick = onBackClick
            )
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding)
                    .padding(horizontal = 8.dp),
                state = scrollState,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item { Spacer(Modifier.height(8.dp)) }
                content()
                item { Spacer(Modifier.height(8.dp)) }
            }
        },
        bottomBar = {}
    )
}