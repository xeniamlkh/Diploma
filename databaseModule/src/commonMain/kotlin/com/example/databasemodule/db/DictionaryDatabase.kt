package com.example.databasemodule.db

import androidx.room3.ConstructedBy
import androidx.room3.Database
import androidx.room3.RoomDatabase
import androidx.room3.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers

@Database(entities = [DictionaryEntity::class], version = 1)
@ConstructedBy(DictionaryDatabaseConstructor::class)
abstract class DictionaryDatabase : RoomDatabase() {
    abstract fun getDao(): DictionaryDao
}

@Suppress("KotlinNoActualForExpect")
expect object DictionaryDatabaseConstructor : RoomDatabaseConstructor<DictionaryDatabase> {
    override fun initialize(): DictionaryDatabase
}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<DictionaryDatabase>
): DictionaryDatabase {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}

fun createDao(database: DictionaryDatabase): DictionaryDao = database.getDao()