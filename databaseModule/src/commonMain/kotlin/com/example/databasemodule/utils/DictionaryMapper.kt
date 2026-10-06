package com.example.databasemodule.utils

import com.example.databasemodule.db.DictionaryEntity
import com.example.databasemodule.domain.WordItem

internal fun DictionaryEntity.toModel() = WordItem(
    word = word,
    translation = translation,
    example = example
)

internal fun WordItem.toEntity() = DictionaryEntity(
    word = word,
    translation = translation,
    example = example
)
