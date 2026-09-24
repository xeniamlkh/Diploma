package com.example.diploma.navigation

import androidx.navigation3.runtime.NavKey
import androidx.savedstate.serialization.SavedStateConfiguration
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
data object AddTopicScreen: Route

@OptIn(ExperimentalSerializationApi::class)
val serializableConfig = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclassesOfSealed<Route>()
        }
    }
}