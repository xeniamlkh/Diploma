package com.example.networkmodule.domain

/** Подключение к сервису Tatoeba для поиска предложений */
interface ITatoebaApi {

    /** Поиска предложения по заданному слову
     * @param word Слово, для которого нужно найти предложение-пример
     * @param language Язык предложения (по умолчанию английский)
     * @return Найденное предложение */
    suspend fun searchSentence(
        word: String,
        language: String = "eng"
    ): String
}