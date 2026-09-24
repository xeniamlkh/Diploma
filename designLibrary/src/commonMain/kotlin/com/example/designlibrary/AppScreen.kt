package com.example.designlibrary

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.Arrangement.Top
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
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designlibrary.resources.Res
import com.example.designlibrary.resources.my_topics
import com.example.designlibrary.resources.topics_start_warning
import org.jetbrains.compose.resources.StringResource

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun AppScreen(
    titleRes: StringResource,
    subTitleRes: StringResource? = null,
    showBackButton: Boolean = false,
    onBackClick: (() -> Unit)? = null,
    //sharedTransitionScope: SharedTransitionScope,
    //animatedContentScope: AnimatedContentScope,
    scrollState: LazyListState = rememberLazyListState(),
    // drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    // bottomBar: @Composable ColumnScope.() -> Unit = {},
    //drawerContent: @Composable () -> Unit = {},
    //snackBarHostState: SnackbarHostState = SnackbarHostState(),
    content: LazyListScope.() -> Unit
) {
    Scaffold(
        containerColor = Color.White, //TODO change to material theme
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
                    .semantics { contentDescription = "LazyColumn" }
                    .fillMaxWidth()
                    .padding(padding)
                    .padding(horizontal = 8.dp),
                state = scrollState,
                verticalArrangement = Top
            ) {
                item { Spacer(Modifier.height(8.dp)) }
                content()
                item { Spacer(Modifier.height(8.dp)) }
            }
        },
        bottomBar = {}
    )
}

@Preview
@Composable
private fun TempAppScreenPreview() {
    AppScreen(
        titleRes = Res.string.my_topics,
        subTitleRes = Res.string.topics_start_warning,
        showBackButton = false,
        onBackClick = {},
        content = {}
    )
}