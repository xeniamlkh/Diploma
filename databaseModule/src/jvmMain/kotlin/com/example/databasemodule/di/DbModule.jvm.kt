package com.example.databasemodule.di

import androidx.room3.RoomDatabase
import com.example.databasemodule.db.DictionaryDatabase
import com.example.databasemodule.getDatabaseBuilder
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformKoinModule(): Module = module {
    single<RoomDatabase.Builder<DictionaryDatabase>> {
        getDatabaseBuilder()
    }
}