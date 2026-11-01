package com.example.diploma.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

/** Экраны навигации */
@Serializable
sealed interface Route : NavKey

@Serializable
data object AddWordScreen: Route

@Serializable
data object WordCardsScreen: Route