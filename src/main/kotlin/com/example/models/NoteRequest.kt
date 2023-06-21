package com.example.models

import kotlinx.serialization.Serializable

/**
 * Represents a NoteRequest object.
 * The NoteRequest class is a Kotlin data class that holds the information for creating a new note.
 * It is annotated with @Serializable from the kotlinx. Serialization library to enable serialization/deserialization.
 * @param note The content of the note.
 */
@Serializable
data class NoteRequest (
    val note: String
)
