package com.example.plugins

import com.example.routing.notesRoutes
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

/**
 *
 * The com.example.plugins package contains plugins and configurations related to routing in the application.
 * Configures the routing for the application.
 * This function is called to configure the routes and endpoints for handling incoming HTTP requests.
 * It sets up the root route ("/") to respond with "Hello World!" text, and calls the notesRoutes() function
 * to configure the routes related to notes.
 */
fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
    notesRoutes()   // call userdefined function
}
