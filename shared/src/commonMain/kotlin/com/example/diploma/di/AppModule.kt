package com.example.diploma.di

import com.example.diploma.navigation.AddTopicScreen
import com.example.diploma.navigation.MainScreen
import com.example.diploma.navigation.Navigator
import com.example.diploma.ui.addingWords.AddWordScreen
import com.example.diploma.ui.addingWords.AddWordViewModel
import com.example.diploma.ui.main.MainScreen
import com.example.diploma.ui.main.MainScreenViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation


/**
 * Koin модуль приложения.
 */
@OptIn(KoinExperimentalAPI::class)
val appModule = module {
    single { Navigator(startDestination = MainScreen) }

    viewModel { AddWordViewModel(appRepository = get()) }
    viewModel { MainScreenViewModel(appRepository = get()) }

    navigation<MainScreen> {
        MainScreen(
            onAddTopicClick = {
                get<Navigator>().goTo(AddTopicScreen)
            }
        )
    }

    navigation<AddTopicScreen> {
        AddWordScreen(
            onBackClick = {
                get<Navigator>().goBack()
            }
        )
    }
}