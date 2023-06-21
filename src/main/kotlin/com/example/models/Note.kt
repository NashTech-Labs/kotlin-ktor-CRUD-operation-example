package com.example.models

import kotlinx.serialization.Serializable

/**
 * Represents a Note object.
 * The Note class is a data class that holds information about a note, including its ID and the actual note content.
 * It is annotated with @Serializable from the kotlinx. Serialization library to enable serialization/deserialization.
 * @param id The unique identifier of the note.
 * @param note The content of the note.
 */
@Serializable
data class Note (
    val id: Int,
    val note: String
)

