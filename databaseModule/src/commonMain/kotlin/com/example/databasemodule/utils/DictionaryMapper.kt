package com.example.databasemodule.utils

import com.example.databasemodule.db.WordEntity
import com.example.databasemodule.domain.WordItem

internal fun WordEntity.toModel() = WordItem(
    topic = topic,
    word = word,
    translation = translation,
    example = example
)

internal fun WordItem.toEntity() = WordEntity(
    topic = topic,
    word = word,
    translation = translation,
    example = example
)