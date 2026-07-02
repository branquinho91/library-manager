package com.branquinho.librarymanager.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost:5432/library_manager";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    private ConnectionFactory() {
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );
        } catch (SQLException e) {
            throw new RuntimeException("Failed to establish database connection.", e);
        }
    }
}
