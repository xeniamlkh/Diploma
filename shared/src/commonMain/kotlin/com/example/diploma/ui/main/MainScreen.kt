package com.example.diploma.ui.main

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.designlibrary.theme.AppColors.PrimaryBlue
import com.example.designlibrary.theme.AppColors.TextSecondary
import com.example.diploma.ui.EmptyScreen
import com.example.diploma.ui.WordListScreen
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = koinViewModel(),
    onAddTopicClick: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    with(state) {
        if (words.isEmpty()) {
            EmptyScreen(
                onAddTopicClick = onAddTopicClick
            )
        } else {
            WordListScreen(
                words = state.words,
                onAddWordClick = onAddTopicClick,
                onDeleteWordClick = viewModel::deleteWord
            )
        }
    }
}

@Composable
private fun AppBottomBar() {
    NavigationBar(
        containerColor = White,
        tonalElevation = 4.dp
    ) {
        NavigationBarItem(
            selected = true,
            onClick = {},
            icon = {
//                Icon(
//                    imageVector = Icons.Default.Folder,
//                    contentDescription = null
//                )
            },
            label = {
                Text("Темы")
            },
            colors = bottomBarColors()
        )

        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
//                Icon(
//                    imageVector = Icons.Default.List,
//                    contentDescription = null
//                )
            },
            label = {
                Text("Слова")
            },
            colors = bottomBarColors()
        )

        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
//                Icon(
//                    imageVector = Icons.Default.BarChart,
//                    contentDescription = null
//                )
            },
            label = {
                Text("Прогресс")
            },
            colors = bottomBarColors()
        )

        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
//                Icon(
//                    imageVector = Icons.Default.Person,
//                    contentDescription = null
//                )
            },
            label = {
                Text("Профиль")
            },
            colors = bottomBarColors()
        )
    }
}

@Composable
private fun bottomBarColors() =
    NavigationBarItemDefaults.colors(
        selectedIconColor = PrimaryBlue,
        selectedTextColor = PrimaryBlue,
        indicatorColor = Color.Transparent,
        unselectedIconColor = TextSecondary,
        unselectedTextColor = TextSecondary
    )