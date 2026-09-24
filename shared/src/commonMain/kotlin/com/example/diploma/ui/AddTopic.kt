package com.example.diploma.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//private val PrimaryBlue = Color(0xFF4164F7)
//private val TextPrimary = Color(0xFF172033)
//private val TextSecondary = Color(0xFF8190AA)

data class WordItem(
    val word: String,
    val translation: String,
    val example: String
)

@Composable
fun AddTopicScreen(
    onBackClick: () -> Unit = {},
    //onSaveClick: (String, List<WordItem>) -> Unit = { _, _ -> }
) {
//    var topicName by remember { mutableStateOf("") }
//    var word by remember { mutableStateOf("") }
//    var translation by remember { mutableStateOf("") }
//    var example by remember { mutableStateOf("") }
//    val words = remember { mutableStateListOf<WordItem>() }
//
//    Scaffold(topBar = {
//        TopAppBar(
//            title = { Text(text = "Новая тема", fontWeight = FontWeight.SemiBold) },
//            navigationIcon = {
//                IconButton(onClick = onBackClick) {
//                    Icon(
//                        imageVector = Icons.Default.ArrowBack,
//                        contentDescription = "Назад"
//                    )
//                }
//            })
//    }, bottomBar = {
//        Surface(tonalElevation = 4.dp) {
//            Button(
//                onClick = {
////                    onSaveClick(
////                        topicName,
////                        words
////                    )
//                },
//                enabled = topicName.isNotBlank() && words.isNotEmpty(),
//                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 12.dp)
//                    .height(56.dp),
//                shape = RoundedCornerShape(28.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue)
//            ) { Text(text = "Сохранить тему", fontSize = 17.sp) }
//        }
//    }) { paddingValues ->
//        LazyColumn(
//            modifier = Modifier.fillMaxSize().padding(paddingValues),
//            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 20.dp),
//            verticalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//            item {
//                Text(
//                    text = "Название темы",
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.SemiBold,
//                    color = TextPrimary
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//                OutlinedTextField(
//                    value =
//                        topicName,
//                    onValueChange = {
//                        topicName = it
//                    },
//                    modifier = Modifier.fillMaxWidth(),
//                    placeholder = { Text("Например, Еда") },
//                    singleLine = true,
//                    shape = RoundedCornerShape(14.dp)
//                )
//            }
//            item { HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp)) }
//            item {
//                Text(
//                    text = "Новое слово",
//                    fontSize = 21.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = TextPrimary
//                )
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(
//                    text =
//                        "Добавьте слово, перевод и пример", fontSize = 15.sp, color = TextSecondary
//                )
//            }
//            item {
//                OutlinedTextField(
//                    value = word,
//                    onValueChange = { word = it },
//                    modifier = Modifier.fillMaxWidth(),
//                    label = { Text("Слово") },
//                    placeholder = { Text("Например, apple") },
//                    singleLine = true,
//                    shape = RoundedCornerShape(14.dp)
//                )
//            }
//            item {
//                OutlinedTextField(
//                    value = translation,
//                    onValueChange = { translation = it },
//                    modifier = Modifier.fillMaxWidth(),
//                    label = { Text("Перевод") },
//                    placeholder = { Text("Например, яблоко") },
//                    singleLine = true,
//                    shape = RoundedCornerShape(14.dp)
//                )
//            }
//            item {
//                OutlinedTextField(
//                    value = example,
//                    onValueChange = { example = it },
//                    modifier = Modifier.fillMaxWidth(),
//                    label = { Text("Пример") },
//                    placeholder = { Text("Например, I eat an apple every day.") },
//                    minLines = 3,
//                    maxLines = 5,
//                    shape = RoundedCornerShape(14.dp)
//                )
//            }
//            item {
//                OutlinedButton(
//                    onClick = {
//                        if (word.isNotBlank() && translation.isNotBlank()) {
//                            words.add(
//                                WordItem(
//                                    word = word.trim(),
//                                    translation = translation.trim(),
//                                    example = example.trim()
//                                )
//                            )
//                            word = ""
//                            translation = ""
//                            example = ""
//                        }
//                    },
//                    enabled = word.isNotBlank() && translation.isNotBlank(),
//                    modifier = Modifier.fillMaxWidth().height(52.dp),
//                    shape = RoundedCornerShape(14.dp)
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.Add,
//                        contentDescription = null
//                    )
//                    Spacer(modifier = Modifier.width(8.dp))
//                    Text(
//                        text =
//                            "Добавить слово", fontSize = 16.sp
//                    )
//                }
//            }
//            if (words.isNotEmpty()) {
//                item {
//                    HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
//                    Text(
//                        text =
//                            "Слова в теме · ${words.size}",
//                        fontSize = 21.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = TextPrimary
//                    )
//                }
//                items(items = words, key = { it.hashCode() }) { item ->
//                    WordCard(
//                        item = item,
//                        onDeleteClick = { words.remove(item) })
//                }
//            }
//            item { Spacer(modifier = Modifier.height(70.dp)) }
//        }
//    }
}

//@Composable
//private fun WordCard(item: WordItem, onDeleteClick: () -> Unit) {
//    Card(
//        modifier = Modifier.fillMaxWidth(),
//        shape = RoundedCornerShape(16.dp),
//        colors = CardDefaults.cardColors(containerColor = Color(0xFFF6F8FC))
//    ) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                verticalAlignment = Alignment.Top
//            ) {
//                Column(modifier = Modifier.weight(1f)) {
//                    Text(
//                        text = item.word,
//                        fontSize = 19.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = TextPrimary
//                    )
//                    Spacer(modifier = Modifier.height(3.dp))
//                    Text(
//                        text =
//                            item.translation, fontSize = 16.sp, color = PrimaryBlue
//                    )
//                }
//                IconButton(onClick = onDeleteClick) {
//                    Icon(
//                        imageVector = Icons.Default.Delete,
//                        contentDescription = "Удалить слово",
//                        tint = TextSecondary
//                    )
//                }
//            }
//            if (item.example.isNotBlank()) {
//                Spacer(modifier = Modifier.height(12.dp))
//                Text(
//                    text =
//                        item.example, fontSize = 15.sp, lineHeight = 21.sp, color = TextSecondary
//                )
//            }
//        }
//    }
//}
//
//@Preview
//@Composable
//private fun AddTopicScreenPreview(){
//    AddTopicScreen(
//        onBackClick = {}
//    )
//}