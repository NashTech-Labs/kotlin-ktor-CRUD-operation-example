package com.example.models

import kotlinx.serialization.Serializable

/**
 * Represents a generic NoteResponse object.
 * The NoteResponse class is a Kotlin data class that encapsulates the response data and success status of a note operation.
 * It is annotated with @Serializable from the kotlinx. Serialization library to enable serialization/deserialization.
 * @param data The data associated with the response.
 * @param success The success status of the response.
 * @param T The type of the data.
 */
@Serializable
data class NoteResponse<T>(
    val data: T,
    val success: Boolean

)
