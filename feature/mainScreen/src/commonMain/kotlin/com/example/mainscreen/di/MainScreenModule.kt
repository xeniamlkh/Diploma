package com.example.mainscreen.di

import com.example.mainscreen.navigation.MainScreen
import com.example.mainscreen.navigation.MainScreenNavigator
import com.example.mainscreen.presentation.MainScreen
import com.example.mainscreen.presentation.MainScreenViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation

@OptIn(KoinExperimentalAPI::class)
val mainScreenModule = module {
    viewModel { MainScreenViewModel(appRepository = get()) }

    navigation<MainScreen> {
        MainScreen(
            onAddWordClick = {
                get<MainScreenNavigator>().openAddWordScreen()
            },
            onLearnWordClick = {
                get<MainScreenNavigator>().openWordCardsScreen()
            }
        )
    }
}