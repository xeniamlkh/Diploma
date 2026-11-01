package com.example.diploma.di

import com.example.diploma.navigation.AddWordScreen
import com.example.diploma.navigation.MainScreenNavigatorImpl
import com.example.diploma.navigation.Navigator
import com.example.diploma.navigation.WordCardsScreenNavigatorImpl
import com.example.diploma.ui.addingWords.AddWordScreen
import com.example.diploma.ui.addingWords.AddWordViewModel
import com.example.mainscreen.navigation.MainScreen
import com.example.mainscreen.navigation.MainScreenNavigator
import com.example.wordcardsscreen.navigation.WordCardsNavigator
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
    single<WordCardsNavigator> { WordCardsScreenNavigatorImpl(navigator = get()) }

    viewModel { AddWordViewModel(appRepository = get(), sentenceService = get()) }

    navigation<AddWordScreen> {
        AddWordScreen(
            onBackClick = {
                get<Navigator>().goBack()
            }
        )
    }
}