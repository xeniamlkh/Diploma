package com.example.diploma.navigation

import com.example.wordcardsscreen.navigation.WordCardsNavigator

class WordCardsScreenNavigatorImpl(
    private val navigator: Navigator
): WordCardsNavigator {
    override fun goBack() {
        navigator.goBack()
    }
}