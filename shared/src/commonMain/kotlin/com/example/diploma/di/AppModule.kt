package com.example.diploma.di

import com.example.diploma.navigation.AddWordScreen
import com.example.diploma.navigation.MainScreenNavigatorImpl
import com.example.diploma.navigation.Navigator
import com.example.diploma.navigation.WordCardsScreen
import com.example.diploma.ui.cards.WordCardsScreen
import com.example.diploma.ui.addingWords.AddWordScreen
import com.example.diploma.ui.addingWords.AddWordViewModel
import com.example.diploma.ui.cards.WordCardsScreenViewModel
import com.example.mainscreen.navigation.MainScreen
import com.example.mainscreen.navigation.MainScreenNavigator
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
    single<MainScreenNavigator> { MainScreenNavigatorImpl(navigator = get()) }

    viewModel { AddWordViewModel(appRepository = get(), sentenceService = get()) }
    viewModel { WordCardsScreenViewModel(appRepository = get()) }

    navigation<AddWordScreen> {
        AddWordScreen(
            onBackClick = {
                get<Navigator>().goBack()
            }
        )
    }

    navigation<WordCardsScreen> {
        WordCardsScreen(
            onBackClick = { get<Navigator>().goBack() }
        )
    }
}