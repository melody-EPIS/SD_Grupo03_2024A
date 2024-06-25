/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package transacciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initializeDatabase() throws SQLException {
        String url = "jdbc:mysql://localhost:3307/";
        String user = "root";
        String password = ""; 
        String dbName = "coffee_shop";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement()) {

            // Crear la base de datos si no existe
            String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + dbName;
            stmt.executeUpdate(createDatabaseSQL);

            // Conectar a la base de datos específica
            String dbUrl = url + dbName;
            try (Connection dbCon = DriverManager.getConnection(dbUrl, user, password);
                 Statement dbStmt = dbCon.createStatement()) {

                // Crear la tabla COFFEES si no existe
                String createTableSQL = "CREATE TABLE IF NOT EXISTS COFFEES (" +
                                        "COF_NAME VARCHAR(32) PRIMARY KEY, " +
                                        "SALES INT, " +
                                        "TOTAL INT)";
                dbStmt.executeUpdate(createTableSQL);

                // Insertar datos iniciales si no existen
                String insertDataSQL = "INSERT INTO COFFEES (COF_NAME, SALES, TOTAL) VALUES " +
                                       "('Colombian', 0, 0) " +
                                       "ON DUPLICATE KEY UPDATE COF_NAME=COF_NAME;";
                dbStmt.executeUpdate(insertDataSQL);

                insertDataSQL = "INSERT INTO COFFEES (COF_NAME, SALES, TOTAL) VALUES " +
                                "('French_Roast', 0, 0) " +
                                "ON DUPLICATE KEY UPDATE COF_NAME=COF_NAME;";
                dbStmt.executeUpdate(insertDataSQL);

                insertDataSQL = "INSERT INTO COFFEES (COF_NAME, SALES, TOTAL) VALUES " +
                                "('Espresso', 0, 0) " +
                                "ON DUPLICATE KEY UPDATE COF_NAME=COF_NAME;";
                dbStmt.executeUpdate(insertDataSQL);
            }
        }
    }

    public static void main(String[] args) {
        try {
            initializeDatabase();
            System.out.println("Database initialized successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

