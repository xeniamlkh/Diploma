package com.example.diploma.data

interface AppRepository {
    fun insertWord(word: String)
    fun getWord()
    fun deleteWord()
    fun editWord()
}