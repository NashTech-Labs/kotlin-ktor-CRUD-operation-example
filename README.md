
# kotlin-ktor-CRUD-operation-example
This is a sample application that demonstrates note management using Ktor, Kotlin, and a PostgreSQL database.

## Ktor Server
This is the main function that starts the Ktor server and configures the necessary plugins and routes.



### Features
- Retrieve all notes
- Create a new note
- Retrieve a specific note by ID
- Update a specific note
- Delete a specific note
  
### Requirements

- Java 8 or higher
- PostgreSQL database
* Getting Started
- Clone the repository:

```
git clone https://github.com/knoldus/kotlin-ktor-CRUD-operation-example.git
```
### Configure the database connection:

- Open the application.conf file in the src/main/resources directory.
- Update the database connection URL, username, and password according to your PostgreSQL database configuration.
### Build the application:

```
./gradlew build
```
#### Run the application:
```
./gradlew run
```
* The application will start on http://localhost:8080.

### Test the API endpoints:

- Retrieve all notes: GET http://localhost:8080/notes
- Create a new note: POST http://localhost:8080/notes
- Retrieve a specific note: GET http://localhost:8080/notes/{id}
- Update a specific note: PUT http://localhost:8080/notes/{id}
- Delete a specific note: DELETE http://localhost:8080/notes/{id}
  
### Technologies Used

* Kotlin
* Ktor
* PostgreSQL
* Ktorm (ORM library for Kotlin)
  

>> main Function
Starts the Ktor server and sets up the required configurations.

* Plugins
ContentNegotiation Plugin

The ContentNegotiation plugin is installed to enable JSON serialization and deserialization. It allows the server to handle requests and responses in JSON format.

#### Server Configuration
Engine: Netty

The server is started using the Netty engine, which is a high-performance web server for Kotlin. It provides scalability and handles multiple concurrent connections efficiently.

* Port: 8080

The server is configured to listen on port 8080. This is the port number that the server will use to accept incoming requests.

* Host: 0.0.0.0

The server is configured to listen on all available network interfaces. This means that it will accept requests from any IP address or hostname that can reach the server.

#### Starting the Server
* Blocking Mode

The server runs in a blocking mode, which means that it waits for incoming requests and handles them synchronously. This ensures that the server is responsive and processes each request before moving on to the next one.

* Start and Wait

The server is started using the start function, and the wait parameter is set to true. This causes the server to start and wait for incoming requests indefinitely. The server will continue to run until it is manually stopped or an exception occurs.

## Routes
### GET /notes

Retrieves all notes from the database and responds with a list of Note objects.

### POST /notes

Accepts a NoteRequest object in the request body and inserts a new note into the database. Responds with a success message if the insertion is successful, or an error message if it fails.

### GET /notes/{id}

Accepts the ID of a note as a path parameter and retrieves the corresponding note from the database. Responds with the retrieved note if it exists, or an error message if it doesn't.

### PUT /notes/{id}

Accepts the ID of a note as a path parameter and a NoteRequest object in the request body. Updates the corresponding note in the database with the new content. Responds with a success message if the update is successful, or an error message if it fails.

### DELETE /notes/{id}

Accepts the ID of a note as a path parameter. Deletes the note from the database and returns a response indicating the success or failure of the operation.

### Dependencies
* The following dependencies are required to use the note routing:
````
com.example.db.DatabaseConnection:               Provides a database connection object.
com.example.entities.NoteEntity:                 Represents the database table for notes.
com.example.models.Note:                         Represents a note object.
com.example.models.NoteRequest:                  Represents the request object for creating or updating a note.
com.example.models.NoteResponse:                 Represents the response object for note operations.
io.ktor.http.HttpStatusCode:                     Provides HTTP status codes for the responses.
io.ktor.server.application.Application:          Represents the Ktor application.
io.ktor.server.request.call:                     Provides information about the current request.
io.ktor.server.response.call.respond:            Sends a response to the client.
io.ktor.server.routing.routing:                  Handles routing configurations.
org.ktorm.dsl.*:                                 Provides DSL for querying the database.
````

### License
This project is licensed under the MIT License. See the LICENSE file for details.

### Acknowledgements
This application was developed as a sample project for learning purposes.

### Contributing
Contributions are welcome! If you find any issues or have suggestions for improvements, please feel free to open an issue or submit a pull request.

