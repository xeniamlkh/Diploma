package com.example.databasemodule.db

import androidx.room3.ConstructedBy
import androidx.room3.Database
import androidx.room3.RoomDatabase
import androidx.room3.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers

@Database(entities = [WordEntity::class], version = 3)
@ConstructedBy(DictionaryDatabaseConstructor::class)
abstract class DictionaryDatabase : RoomDatabase() {
    internal abstract fun getDao(): DictionaryDao
}

@Suppress("KotlinNoActualForExpect")
expect object DictionaryDatabaseConstructor : RoomDatabaseConstructor<DictionaryDatabase> {
    override fun initialize(): DictionaryDatabase
}

internal fun getRoomDatabase(
    builder: RoomDatabase.Builder<DictionaryDatabase>
): DictionaryDatabase {
    return builder
        .fallbackToDestructiveMigration()
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}

internal fun createDao(database: DictionaryDatabase): DictionaryDao = database.getDao()