package com.example.db

import org.ktorm.database.Database

/**
 * Singleton object representing the database connection.
 * The DatabaseConnection object provides access to the underlying database using the Ktorm library.
 * It establishes a connection to a MySQL database using the provided URL, driver, username, and password.
 * Usage:
 * To obtain the instance of the database connection, access the 'db' property of the DatabaseConnection object.
 */
object DatabaseConnection {

     /**
     * @property db The instance of the connected database.
     *
     */
     val db by lazy {
         val url = System.getenv("DB_URL")
         val driver = System.getenv("DB_DRIVER")
         val user = System.getenv("DB_USER")
         val password = System.getenv("DB_PASSWORD")

         Database.connect(url, driver, user, password)
     }
}