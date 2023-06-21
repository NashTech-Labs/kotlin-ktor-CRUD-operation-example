package com.example.routing

/**
 * The com.example.routing package contains route configurations related to handling notes in the application.
 *
 */
import com.example.db.DatabaseConnection
import com.example.entities.NoteEntity
import com.example.models.Note
import com.example.models.NoteRequest
import com.example.models.NoteResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.dsl.*

/**
 * Configures the routes for handling notes.
 *
 * This function is called to configure the routes and endpoints related to notes in the application.
 *
 * It sets up various HTTP methods like GET, POST, PUT, and DELETE for CRUD operations on notes.
 *
 * The routes are associated with corresponding database operations using Ktorm DSL.
 */
fun Application.notesRoutes(){

    val db2 = DatabaseConnection.db
    routing {
        /**
         * Handles GET requests to retrieve all notes.
         *
         * Retrieves all notes from the database and responds with a list of Note objects.
         */
        get("/notes") {
            val notes = db2.from(NoteEntity).select()

                .map {
                    val id = it[NoteEntity.id]
                    val note = it[NoteEntity.note]
                    Note(id ?: -1, note ?: "")
                }
            // call.respondText("Running All Notes")
            call.respond(notes)
        }

        /**
         * Handles POST requests to create a new note.
         *
         * Accepts a NoteRequest object in the request body and inserts the new note into the database.
         * Responds with a success message if the insertion is successful, or an error message if it fails.
         */
        post("/notes") {
            val request = call.receive<NoteRequest>()
            val result = db2.insert(NoteEntity) {
                set(it.note, request.note)
            }
            if (result == 1) {
                // send successfully response to the client
                call.respond(
                    HttpStatusCode.OK, NoteResponse(
                        success = true,
                        data = "Value successfully inserted"
                    )
                )
            } else {
                // send failure to the client
                call.respond(
                    HttpStatusCode.BadRequest, NoteResponse(
                        success = false,
                        data = "Failed to insert value"
                    )
                )
            }
        }

        /**
         * Handles GET requests to retrieve a specific note by its ID.
         *
         * Accepts the ID of the note as a path parameter and retrieves the corresponding note from the database.
         * Responds with the retrieved note if it exists, or an error message if it doesn't.
         */
        get("/notes/{id}") {
            val id = call.parameters["id"]?.toInt() ?: -1

            val note = db2.from(NoteEntity)
                .select()
                .where { NoteEntity.id eq id }
                .map {
                    val id = it[NoteEntity.id]!!
                    val note = it[NoteEntity.note]!!
                    Note(id = id, note = note)
                }.firstOrNull()

            if (note == null) {
                call.respond(
                    HttpStatusCode.NotFound, NoteResponse(
                        success = false,
                        data = "Could Not Found note with id = $id"
                    )
                )
            } else {
                call.respond(
                    HttpStatusCode.OK, NoteResponse(
                        success = true,
                        data = note
                    )
                )
            }
        }

        /**
         * Handles PUT requests to update a specific note by its ID.
         *
         * Accepts the ID of the note as a path parameter and a NoteRequest object in the request body,
         * and updates the corresponding note in the database with the new content.
         * Responds with a success message if the update is successful, or an error message if it fails.
         */
        put("/notes/{id}") {
            val id = call.parameters["id"]?.toInt() ?: -1
            val updateNotes = call.receive<NoteRequest>()

            val rowsEffected = db2.update(NoteEntity) {
                set(it.note, updateNotes.note)
                where {
                    it.id eq id
                }
            }
            if (rowsEffected == 1) {
                call.respond(
                    HttpStatusCode.OK, NoteResponse(
                        success = true,
                        data = "Notes has been updated"
                    )
                )
            } else {
                call.respond(
                    HttpStatusCode.BadRequest, NoteResponse(
                        success = false,
                        data = "Note Failed to update"
                    )
                )
            }
        }

        /**
         * DELETE route for deleting a specific note by its ID.
         *
         * Expects the ID of the note as a path parameter.
         * Deletes the note from the database and returns a NoteResponse object as the response
         * indicating the success or failure of the operation.
         */
        delete("/notes/{id}") {
            val id = call.parameters["id"]?.toInt() ?: -1
            val rowsEffected = db2.delete(NoteEntity) {
                it.id eq id
            }

            if (rowsEffected == 1) {
                call.respond(
                    HttpStatusCode.OK, NoteResponse(
                        success = true,
                        data = "Note Deleted Successfully"
                    )
                )
            } else {
                call.respond(
                    HttpStatusCode.BadRequest, NoteResponse(
                        success = false,
                        data = "Note Failed to Delete"
                    )
                )
            }
        }
    }

}