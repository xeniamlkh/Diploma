package com.example.diploma.ui

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.example.designlibrary.theme.AppColors.PrimaryBlue
import com.example.designlibrary.theme.AppColors.TextSecondary
import com.example.designlibrary.screens.EmptyScreen

@Composable
fun MainScreen(
    cardsAvailable: Boolean = false, //TODO Move to VM
    onAddTopicClick: () -> Unit
) {
    if (!cardsAvailable) {
        EmptyScreen(
            onAddTopicClick = onAddTopicClick
        )
    }
}


//original screen
//    Scaffold(
//        containerColor = Color.White,
//        bottomBar = {
//            //AppBottomBar()
//        }
//    ) { paddingValues ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(paddingValues)
//                .padding(horizontal = 24.dp)
//        ) {
//
//            Spacer(modifier = Modifier.height(24.dp))
//
//            Header(
//                onSettingsClick = {}
//                    //onSettingsClick
//            )
//
//            Box(
//                modifier = Modifier
//                    .weight(1f)
//                    .fillMaxWidth(),
//                contentAlignment = Alignment.Center
//            ) {
//                EmptyTopicsContent(
//                    //onAddTopicClick = { logger.i { "CLICK" } }
//                    onAddTopicClick = onAddTopicClick
//                )
//            }
//        }
//    }

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