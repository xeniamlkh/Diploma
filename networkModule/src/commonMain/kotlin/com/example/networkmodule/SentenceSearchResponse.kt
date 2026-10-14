package com.example.networkmodule

import kotlinx.serialization.Serializable

@Serializable
internal data class SentenceSearchResponse(
    val data: List<TatoebaSentence> = emptyList()
)
