package com.example.databasemodule

import androidx.room3.Room
import androidx.room3.RoomDatabase
import com.example.databasemodule.db.DictionaryDatabase
import java.io.File

fun getDatabaseBuilder(): RoomDatabase.Builder<DictionaryDatabase> {
    val dbFile = File(
        System.getProperty("java.io.tmpdir"), //TODO заменить на application data directory
        "dictionary_room.db"
    )

    return Room.databaseBuilder<DictionaryDatabase>(
        name = dbFile.absolutePath,
    )
}