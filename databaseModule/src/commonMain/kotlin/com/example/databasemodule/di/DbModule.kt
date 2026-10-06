package com.example.databasemodule.di

import com.example.databasemodule.db.createDao
import com.example.databasemodule.db.getRoomDatabase
import com.example.databasemodule.domain.IDictionaryRepository
import com.example.databasemodule.repo.DictionaryRepositoryImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.plugin.module.dsl.create

expect fun platformKoinModule(): Module

val dbModule = module {
    includes(platformKoinModule())

    single { create(::getRoomDatabase) }
    single { create(::createDao) }
    singleOf(::DictionaryRepositoryImpl) {
        bind<IDictionaryRepository>()
    }
}
