package com.example.databasemodule

import android.content.Context
import androidx.room3.Room
import androidx.room3.RoomDatabase
import com.example.databasemodule.db.DictionaryDatabase

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<DictionaryDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("dictionary_room.db")

    return Room.databaseBuilder<DictionaryDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}