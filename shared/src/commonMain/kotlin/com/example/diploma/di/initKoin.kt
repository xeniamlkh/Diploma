package com.example.diploma.di

import com.example.databasemodule.di.dbModule
import com.example.networkmodule.di.networkModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.includes

/**
 * Функция инициализации koin.
 * @param config - настройки Koin, выполняемые во время её инициализации
 */
fun initKoin(config: KoinAppDeclaration? = null): KoinApplication {
    return startKoin {
        includes(config)
        modules(appModule, dbModule, networkModule)
    }
}