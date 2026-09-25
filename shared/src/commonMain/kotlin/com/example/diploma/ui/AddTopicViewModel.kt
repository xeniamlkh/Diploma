package com.example.diploma.ui

import androidx.lifecycle.ViewModel
import co.touchlab.kermit.Logger
import com.example.diploma.data.AppRepository

class AddTopicViewModel(
    private val appRepository: AppRepository
) : ViewModel() {
    val logger = Logger.withTag("!!!!!")
    fun addTopic(topic: String) {
        logger.i { "topic = $topic" }
        appRepository.insertWord(topic)
    }
}