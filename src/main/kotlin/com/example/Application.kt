package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import com.example.plugins.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*

/**
 *
 * This function starts the Ktor server and configures the necessary plugins and routes.
 *
 * It installs the ContentNegotiation plugin to enable JSON serialization/deserialization.
 *
 * The server is started using the Netty engine on port 8080 and listens to all available network interfaces.
 *
 * The server runs in a blocking mode and waits for incoming requests.
 *
 */
fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(ContentNegotiation) {
            json()
        }

        configureRouting()

   }  .start(wait = true)

}
