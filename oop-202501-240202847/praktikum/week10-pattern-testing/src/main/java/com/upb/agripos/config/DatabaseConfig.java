package com.upb.agripos.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    // Nama variabel instance harus sesuai dengan nama class
    private static DatabaseConfig instance; 
    private Connection connection;

    // Pastikan database name sesuai dengan yang ada di pgAdmin (agripos)
    private static final String URL = "jdbc:postgresql://localhost:5432/agripos";
    private static final String USER = "postgres";
    private static final String PASSWORD = "rizalramadani01";

    // Nama Constructor WAJIB sama dengan nama Class
    private DatabaseConfig() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            throw new SQLException("PostgreSQL Driver tidak ditemukan!", ex);
        }
    }

    // Nama Return Type harus DatabaseConfig
    public static DatabaseConfig getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConfig();
        }
        return instance;
    }

    // Method pembantu (Helper) untuk mendapatkan koneksi langsung
    public static Connection getConnection() throws SQLException {
        return getInstance().getInternalConnection();
    }

    // Method internal untuk mengambil variabel connection
    public Connection getInternalConnection() {
        return connection;
    }

    public void executeQuery(String query) {
        System.out.println("Executing query: " + query);
    }
}