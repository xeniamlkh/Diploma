package com.example.addwordscreen.di

import com.example.addwordscreen.data.AddWordServiceImpl
import com.example.addwordscreen.domain.AddWordService
import com.example.addwordscreen.navigation.AddWordScreenNavigator
import com.example.addwordscreen.navigation.AddWordScreen
import com.example.addwordscreen.presentation.AddWordScreen
import com.example.addwordscreen.presentation.AddWordViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation

@OptIn(KoinExperimentalAPI::class)
val addWordScreenModule = module {
    single<AddWordService> { AddWordServiceImpl(appRepository = get(), sentenceService = get()) }

    viewModel { AddWordViewModel(addWordService = get()) }

    navigation<AddWordScreen> {
        AddWordScreen(
            onBackClick = {
                get<AddWordScreenNavigator>().goBack()
            }
        )
    }
}