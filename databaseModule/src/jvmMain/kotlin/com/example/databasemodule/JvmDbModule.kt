package com.example.databasemodule

import androidx.room3.RoomDatabase
import com.example.databasemodule.db.DictionaryDatabase
import org.koin.dsl.module

val jvmDbModule = module {
    single<RoomDatabase.Builder<DictionaryDatabase>> {
        getDatabaseBuilder()
    }
}