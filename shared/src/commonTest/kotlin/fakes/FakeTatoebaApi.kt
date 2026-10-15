package fakes

import com.example.networkmodule.domain.ITatoebaApi

class FakeTatoebaApi : ITatoebaApi {
    var result: () -> String = { "Tom saw some rabbits in his backyard." }
    val requestedWords = mutableListOf<String>()

    override suspend fun searchSentence(
        word: String,
        language: String
    ): String {
        requestedWords += word
        return result()
    }
}