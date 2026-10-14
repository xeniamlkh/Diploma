package com.example.networkmodule

import kotlinx.serialization.Serializable

@Serializable
internal data class TatoebaSentence(
    val id: Int,
    val text: String
)
