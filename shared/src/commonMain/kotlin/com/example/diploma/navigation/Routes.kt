package com.example.diploma.navigation

import androidx.navigation3.runtime.NavKey
import androidx.savedstate.serialization.SavedStateConfiguration
import com.example.databasemodule.domain.WordItem
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

/** Экраны навигации */
@Serializable
sealed interface Route : NavKey

@Serializable
data object MainScreen: Route

@Serializable
data object AddWordScreen: Route

@OptIn(ExperimentalSerializationApi::class)
val serializableConfig = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclassesOfSealed<Route>()
        }
    }
}

@Serializable
data object WordCardsScreen: Route