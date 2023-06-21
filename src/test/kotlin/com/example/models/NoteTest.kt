package com.example.models

import kotlinx.serialization.Serializable
import org.junit.Assert.*
import org.junit.Test

@Serializable
data class Note(
    val id: Int,
    val note: String
)

class NoteTest {

    @Test
    fun testNoteEquality() {
        // Arrange
        val note1 = Note(1, "springboot")
        val note2 = Note(1, "springboot")
        val note3 = Note(2, "Core Java")

        // Assert
        assertEquals(note1, note2) // Notes with the same ID and note content should be equal
        assertNotEquals(note1, note3) // Notes with different IDs should not be equal
    }

    @Test
    fun testNoteProperties() {
        // Arrange
        val note = Note(1, "springboot")

        // Act
        val id = note.id
        val noteContent = note.note

        // Assert
        assertEquals(1, id)
        assertEquals("springboot", noteContent)
    }

    @Test
    fun testNoteToString() {
        // Arrange
        val note = Note(1, "springboot")

        // Act
        val noteString = note.toString()

        // Assert
        assertEquals("Note(id=1, note=springboot)", noteString)
    }

    @Test
    fun testNoteCopy() {
        // Arrange
        val note1 = Note(1, "springboot")

        // Act
        val note2 = note1.copy()

        // Assert
        assertEquals(note1, note2)
        assertNotSame(note1, note2)
    }

}
