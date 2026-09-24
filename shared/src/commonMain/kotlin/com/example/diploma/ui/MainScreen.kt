package com.example.diploma.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
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
import com.example.designlibrary.components.buttons.AppFullWidthFilledButton
import com.example.designlibrary.screens.AppScreen
import com.example.designlibrary.components.listBlocks.AppScreenField
import com.example.designlibrary.theme.AppColors.PrimaryBlue
import com.example.designlibrary.theme.AppColors.PrimaryBlueLight
import com.example.designlibrary.theme.AppColors.TextPrimary
import com.example.designlibrary.theme.AppColors.TextSecondary
import com.example.designlibrary.resources.Res
import com.example.designlibrary.resources.ic_add
import com.example.designlibrary.resources.my_topics
import com.example.designlibrary.resources.topics_start_warning

@Composable
fun MainScreen(
    cardsAvailable: Boolean = false, //TODO Move to VM
    onAddTopicClick: () -> Unit
) {

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

    AppScreen(
        titleRes = Res.string.my_topics,
        subTitleRes = if (!cardsAvailable) Res.string.topics_start_warning else null,
        showBackButton = false,
        onBackClick = {},
        content = {
            AppScreenField {
                AppFullWidthFilledButton(
                    iconRes = Res.drawable.ic_add,
                    onClick = onAddTopicClick
                )
            }
        }
    )
}


@Composable
private fun Header(
    onSettingsClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Мои темы",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Здесь будут храниться ваши слова\nпо темам",
                fontSize = 18.sp,
                lineHeight = 24.sp,
                color = TextSecondary
            )
        }

        IconButton(
            onClick = onSettingsClick
        ) {
//            Icon(
//                imageVector = Icons.Default.Settings,
//                contentDescription = "Настройки",
//                tint = TextPrimary,
//                modifier = Modifier.size(30.dp)
//            )
        }
    }
}

@Composable
private fun EmptyTopicsContent(
    onAddTopicClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        FolderIllustration()

        Spacer(modifier = Modifier.height(36.dp))

        Text(
            text = "У вас пока нет тем",
            fontSize = 23.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextPrimary
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "Добавьте первую тему, чтобы начать\nизучать новые слова.",
            fontSize = 17.sp,
            lineHeight = 24.sp,
            color = TextSecondary,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(36.dp))

        Button(
            onClick = onAddTopicClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryBlue,
                contentColor = White
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 0.dp
            )
        ) {
//            Icon(
//                imageVector = Icons.Default.Add,
//                contentDescription = null,
//                modifier = Modifier.size(28.dp)
//            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Добавить тему",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
private fun FolderIllustration() {
    Surface(
        modifier = Modifier.size(150.dp),
        shape = CircleShape,
        color = PrimaryBlueLight
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
//            Icon(
//                imageVector = Icons.Default.Folder,
//                contentDescription = null,
//                tint = Color(0xFF90A6FF),
//                modifier = Modifier.size(92.dp)
//            )

            Surface(
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(x = 26.dp, y = 15.dp)
                    .size(38.dp),
                shape = CircleShape,
                color = PrimaryBlue
            ) {
//                Icon(
//                    imageVector = Icons.Default.Add,
//                    contentDescription = null,
//                    tint = Color.White,
//                    modifier = Modifier.padding(7.dp)
//                )
            }
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

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen(
        onAddTopicClick = {}
    )
}