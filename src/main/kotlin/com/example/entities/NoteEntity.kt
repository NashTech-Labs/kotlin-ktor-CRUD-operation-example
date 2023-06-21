package com.example.entities

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

/**
 *
 * Represents the NoteEntity table in the database.
 * The NoteEntity table is used to store notes with their corresponding IDs.
 * It defines the structure and schema of the NoteEntity table using the Ktorm library.
 * Usage:
 * To interact with the NoteEntity table, use the defined properties and methods of this object.
 */
object NoteEntity : Table<Nothing>("note"){
    /**
     * Represents the 'id' column in the NoteEntity table.
     * It is an integer column and serves as the primary key for the table.
     */
    val id = int("id").primaryKey()

    /**
     * Represents the 'note' column in the NoteEntity table.
     * It is a varchar column used to store the notes.
     */
    val note = varchar("note")

}