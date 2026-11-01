package com.example.wordcardsscreen.di

import com.example.wordcardsscreen.navigation.WordCardsNavigator
import com.example.wordcardsscreen.navigation.WordCardsScreen
import com.example.wordcardsscreen.presentation.WordCardsScreen
import com.example.wordcardsscreen.presentation.WordCardsScreenViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation

@OptIn(KoinExperimentalAPI::class)
val wordCardsScreenModule = module {
    viewModel { WordCardsScreenViewModel(appRepository = get()) }

    navigation<WordCardsScreen> {
        WordCardsScreen(
            onBackClick = { get<WordCardsNavigator>().goBack() }
        )
    }
}