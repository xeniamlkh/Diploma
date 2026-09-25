package com.example.diploma.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designlibrary.theme.AppColors.PrimaryBlue
import com.example.designlibrary.theme.AppColors.TextPrimary
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

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen(
        onAddTopicClick = {}
    )
}