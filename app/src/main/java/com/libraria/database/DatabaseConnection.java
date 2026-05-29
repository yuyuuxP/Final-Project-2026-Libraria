package com.libraria.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL =
            "jdbc:sqlite:libraria.db";

    public static Connection connect() {
        try {
            Connection conn = DriverManager.getConnection(URL);
            createTable(conn);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void createTable(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS users (
                email TEXT NOT NULL UNIQUE, 
                password TEXT NOT NULL, 
                secretquestion TEXT NOT NULL, 
                secretanswer TEXT NOT NULL
                )
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS books(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    title TEXT,
                    author TEXT,
                    category TEXT,
                    genre TEXT,
                    status TEXT
                )
            """);
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS borrowed_books(
                    book_title TEXT,
                    borrower_name TEXT,
                    borrow_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                )
            """);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}