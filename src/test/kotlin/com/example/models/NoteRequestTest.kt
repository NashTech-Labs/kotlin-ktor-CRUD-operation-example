package com.example.models

import kotlinx.serialization.Serializable
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

@Serializable
data class NoteRequest(
    val note: String
)

class NoteRequestTest {

    @Test
    fun testNoteRequestProperties() {
        // Arrange
        val note = "sample note"

        // Act
        val noteRequest = NoteRequest(note)
        val actualNote = noteRequest.note

        // Assert
        assertEquals(note, actualNote)
    }

    @Test
    fun testNoteRequestSerialization() {
        // Arrange
        val note = "sample note"
        val noteRequest = NoteRequest(note)

        // Act
        val json = kotlinx.serialization.json.Json.encodeToString(NoteRequest.serializer(), noteRequest)
        val deserializedNoteRequest = kotlinx.serialization.json.Json.decodeFromString(NoteRequest.serializer(), json)

        // Assert
        assertEquals(noteRequest, deserializedNoteRequest)
    }

    @Test
    fun testNoteRequestEquality() {
        // Arrange
        val note1 = NoteRequest("sample note")
        val note2 = NoteRequest("sample note")
        val note3 = NoteRequest("different note")

        // Assert
        assertEquals(note1, note2) // Note requests with the same note content should be equal
        assertNotEquals(note1, note3) // Note requests with different note content should not be equal
    }

    @Test
    fun testNoteRequestToString() {
        // Arrange
        val note = "sample note"
        val noteRequest = NoteRequest(note)

        // Act
        val stringRepresentation = noteRequest.toString()

        // Assert
        assertEquals("NoteRequest(note=$note)", stringRepresentation)
    }
}
