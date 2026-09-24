package com.example.diploma

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.ui.NavDisplay
import com.example.diploma.navigation.Navigator
import org.koin.compose.navigation3.koinEntryProvider
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.java.KoinJavaComponent.inject
import kotlin.getValue

@OptIn(KoinExperimentalAPI::class)
@Composable
@Preview
fun App() {
    val navigator: Navigator by inject(Navigator::class.java)

    val entryProvider = koinEntryProvider<NavKey>()

    NavDisplay(
        backStack = navigator.backStack,
        onBack = { navigator.goBack() },
        entryProvider = entryProvider
    )
}