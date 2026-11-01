package com.example.diploma.navigation

import com.example.addwordscreen.navigation.AddWordScreenNavigator

class AddWordScreenNavigatorImpl(
    private val navigator: Navigator
) : AddWordScreenNavigator {
    override fun goBack() {
        navigator.goBack()
    }
}