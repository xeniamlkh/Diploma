package com.example.diploma.navigation

import com.example.mainscreen.navigation.MainScreenNavigator

class MainScreenNavigatorImpl(
    private val navigator: Navigator
) : MainScreenNavigator {
    override fun openAddWordScreen() {
        navigator.goTo(destination = AddWordScreen)
    }

    override fun openWordCardsScreen() {
        navigator.goTo(destination = WordCardsScreen)
    }
}