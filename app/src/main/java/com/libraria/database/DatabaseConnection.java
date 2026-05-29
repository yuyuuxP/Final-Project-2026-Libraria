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
                secretanswer TEXT NOT NULL,
                role TEXT NOT NULL DEFAULT 'member'
                )
            """);

            stmt.execute("INSERT OR IGNORE INTO users (email, password, secretquestion, secretanswer, role) VALUES ('admin@libraria.com', 'admin12345', '-', '-', 'admin')");

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}