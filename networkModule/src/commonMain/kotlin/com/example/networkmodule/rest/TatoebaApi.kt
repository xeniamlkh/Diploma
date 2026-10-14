package com.example.networkmodule.rest

import com.example.networkmodule.domain.ITatoebaApi
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
private const val TATOEBA_URL = "https://api.tatoeba.org/v1/sentences"

internal class TatoebaApi: ITatoebaApi {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json { ignoreUnknownKeys = true }
            )
        }
    }

    override suspend fun searchSentence(
        word: String,
        language: String
    ): String {
        if (word.isBlank()) return ""

        val response: SentenceSearchResponse = client.get(TATOEBA_URL) {
            parameter("lang", language)
            parameter("q", word.trim())
            parameter("word_count", "5-10")
            parameter("sort", "random")
            parameter("limit", 1)
        }.body()

        val sentence = response.data.firstOrNull()?.text.orEmpty()

        return sentence
    }
}