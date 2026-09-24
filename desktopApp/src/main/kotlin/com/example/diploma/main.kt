package com.example.diploma

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.diploma.di.initKoin

fun main() {

    initKoin()

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Diploma",
        ) {
            App()
        }
    }
}