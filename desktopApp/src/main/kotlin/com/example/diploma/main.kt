package com.example.diploma

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.designlibrary.resources.Res
import com.example.designlibrary.resources.ic_diploma_png
import com.example.diploma.di.initKoin
import org.jetbrains.compose.resources.painterResource

fun main() {

    initKoin()

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Diploma",
            icon = painterResource(Res.drawable.ic_diploma_png)
        ) {
            App()
        }
    }
}