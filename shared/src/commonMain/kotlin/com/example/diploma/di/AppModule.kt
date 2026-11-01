package com.example.diploma.di

import com.example.addwordscreen.navigation.AddWordScreenNavigator
import com.example.diploma.navigation.AddWordScreenNavigatorImpl
import com.example.diploma.navigation.MainScreenNavigatorImpl
import com.example.diploma.navigation.Navigator
import com.example.diploma.navigation.WordCardsScreenNavigatorImpl
import com.example.mainscreen.navigation.MainScreen
import com.example.mainscreen.navigation.MainScreenNavigator
import com.example.wordcardsscreen.navigation.WordCardsNavigator
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.dsl.module

/**
 * Koin модуль приложения.
 */
@OptIn(KoinExperimentalAPI::class)
val appModule = module {
    single { Navigator(startDestination = MainScreen) }
    single<MainScreenNavigator> { MainScreenNavigatorImpl(navigator = get()) }
    single<WordCardsNavigator> { WordCardsScreenNavigatorImpl(navigator = get()) }
    single<AddWordScreenNavigator> { AddWordScreenNavigatorImpl(navigator = get()) }
}