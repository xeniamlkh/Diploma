package com.example.databasemodule

interface AppRepository {
    fun insertWord(word: String)
    fun getWord()
    fun deleteWord()
    fun editWord()
}