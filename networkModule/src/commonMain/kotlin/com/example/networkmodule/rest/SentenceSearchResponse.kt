package com.example.networkmodule.rest

import kotlinx.serialization.Serializable

@Serializable
internal data class SentenceSearchResponse(
    val data: List<TatoebaSentence> = emptyList()
)