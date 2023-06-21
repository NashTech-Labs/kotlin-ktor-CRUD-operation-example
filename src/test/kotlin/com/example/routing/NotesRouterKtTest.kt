package com.example.routing

import com.example.models.Note
import com.example.models.NoteResponse
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.testing.*
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test

class NoteRoutesTest {


    @Test
    fun testGetAllNotes() {
        // Arrange
        val expectedNotes = listOf(
            Note(1, "Note 1"),
            Note(2, "Note 2"),
            Note(3, "Note 3")
        )

        withTestApplication({


            // Add this configuration to set JSON as the default content type
            install(ContentNegotiation) {
                json(
                    contentType = ContentType.Application.Json,
                    json = Json { prettyPrint = true }
                )
            }
            notesRoutes()
        }) {
            // Act
            handleRequest(HttpMethod.Get, "/notes") {
                addHeader(HttpHeaders.Accept, ContentType.Application.Json.toString())
            }.apply {
                // Assert
                assertEquals(HttpStatusCode.OK, response.status())
                val actualResponse = response.content
                val noteResponse = actualResponse?.let { Json.decodeFromString<NoteResponse<List<Note>>>(it) }
                if (noteResponse != null) {
                    assertEquals(expectedNotes, noteResponse.data)
                }
            }
        }
    }

    // ... other test cases ...


    @Test
    fun testGetAllNotess() {
        withTestApplication({ notesRoutes() }) {
            // Arrange

            // Act
            val response = handleRequest(HttpMethod.Get, "/notes").response

            // Assert
            assertEquals(HttpStatusCode.OK, response.status())
            assertEquals(ContentType.Application.Json.withCharset(Charsets.UTF_8), response.contentType())
            // Add further assertions to verify the response body, if needed
        }
    }

    @Test
    fun testCreateNote() {
        withTestApplication({ notesRoutes() }) {
            // Arrange
            val requestBody = """{ "note": "Test note" }"""

            // Act
            val response = handleRequest(HttpMethod.Post, "/notes") {
                setBody(requestBody)
                addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
            }.response

            // Assert
            assertEquals(HttpStatusCode.OK, response.status())
            assertEquals(ContentType.Application.Json.withCharset(Charsets.UTF_8), response.contentType())
            // Add further assertions to verify the response body, if needed
        }
    }

}
