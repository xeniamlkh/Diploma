package com.example.addwordscreen.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface AddWordRoute : NavKey

@Serializable
data object AddWordScreen: AddWordRoute