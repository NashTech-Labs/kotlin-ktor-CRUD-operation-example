package com.example.models

import kotlinx.serialization.Serializable
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

@Serializable
data class NoteResponse<T>(
    val data: T,
    val success: Boolean
)

class NoteResponseTest {

    @Test
    fun testNoteResponseProperties() {
        // Arrange
        val responseData = "Sample response data"
        val successStatus = true

        // Act
        val noteResponse = NoteResponse(responseData, successStatus)

        // Assert
        assertEquals(responseData, noteResponse.data)
        assertEquals(successStatus, noteResponse.success)
    }

    @Test
    fun testNoteResponseToString() {
        // Arrange
        val responseData = "Sample response data"
        val successStatus = true
        val noteResponse = NoteResponse(responseData, successStatus)

        // Act
        val stringRepresentation = noteResponse.toString()

        // Assert
        assertEquals("NoteResponse(data=$responseData, success=$successStatus)", stringRepresentation)
    }

    @Test
    fun testNoteResponseEquality() {
        // Arrange
        val responseData1 = "Sample response data"
        val successStatus1 = true
        val noteResponse1 = NoteResponse(responseData1, successStatus1)

        val responseData2 = "Sample response data"
        val successStatus2 = true
        val noteResponse2 = NoteResponse(responseData2, successStatus2)

        val responseData3 = "Different response data"
        val successStatus3 = false
        val noteResponse3 = NoteResponse(responseData3, successStatus3)

        // Assert
        assertEquals(noteResponse1, noteResponse2) // NoteResponses with the same data and success status should be equal
        assertNotEquals(noteResponse1, noteResponse3) // NoteResponses with different data or success status should not be equal
    }

    @Test
    fun testNoteResponseHashCode() {
        // Arrange
        val responseData = "Sample response data"
        val successStatus = true
        val noteResponse = NoteResponse(responseData, successStatus)

        // Act
        val hashCode = noteResponse.hashCode()

        // Assert
        val expectedHashCode = responseData.hashCode() * 31 + successStatus.hashCode()
        assertEquals(expectedHashCode, hashCode)
    }
}
