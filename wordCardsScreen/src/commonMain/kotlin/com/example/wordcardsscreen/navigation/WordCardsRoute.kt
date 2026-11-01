package com.example.wordcardsscreen.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface WordCardsRoute : NavKey


@Serializable
data object WordCardsScreen: WordCardsRoute