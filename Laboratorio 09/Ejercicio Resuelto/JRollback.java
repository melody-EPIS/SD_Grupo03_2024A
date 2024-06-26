/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JRollback {
    public static void main(String[] args) {
        // Obtiene la conexión a la base de datos
        Connection connection = Database.getConnection();
        // Declaración de los PreparedStatement
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;

        try {
            // Desactiva el autocommit para controlar manualmente las transacciones
            connection.setAutoCommit(false);
            // Prepara la declaración para insertar en la tabla "miTabla"
            stmt1 = connection.prepareStatement("INSERT INTO miTabla VALUES( ?, ? );");
            // Prepara la declaración para insertar en la tabla "miOtraTabla"
            stmt2 = connection.prepareStatement("INSERT INTO miOtraTabla VALUES( ?, ?, ? );");
            
            // Primer INSERT en la tabla "miTabla"
            System.out.println("Primer INSERT tabla [miTabla]");
            stmt1.setString(1, "000001");
            stmt1.setString(2, "micorreo@mail.com");
            stmt1.executeUpdate();
            
            // Segundo INSERT en la tabla "miTabla"
            System.out.println("Segundo INSERT tabla [miTabla]");
            stmt1.setString(1, "000002");
            stmt1.setString(2, "amayuya@mail.com");
            stmt1.executeUpdate();
            
            // Tercer INSERT en la tabla "miTabla"
            System.out.println("Tercer INSERT tabla [miTabla]");
            stmt1.setString(1, "000003");
            stmt1.setString(2, "diosdado@mail.com");
            stmt1.executeUpdate();
            
            // Primer INSERT en la tabla "miOtraTabla"
            System.out.println("Primer INSERT tabla [miOtraTabla]");
            stmt2.setString(1, "Juan");
            stmt2.setString(2, "Perez");
            stmt2.setString(3, "Hola soy un error"); // Tipo de dato INCORRECTO
            stmt2.executeUpdate();
            
            // Si todos los INSERT son exitosos, se realiza el commit de la transacción
            connection.commit();
            
        } catch (SQLException ex) {
            // Manejo de errores de SQL, imprime el mensaje de error
            System.err.println("ERROR: " + ex.getMessage());
            if (connection != null) {
                System.out.println("Rollback");
                try {
                    // Si ocurre un error, se realiza el rollback de la transacción
                    connection.rollback();
                } catch (SQLException ex1) {
                    // Manejo de errores al realizar el rollback, imprime el mensaje de error
                    System.err.println("No se pudo deshacer: " + ex1.getMessage());
                }
            }
        } finally {
            // Cierra la conexión y los PreparedStatement
            System.out.println("Cierra conexión a la base de datos");
            try {
                if (stmt1 != null) stmt1.close();
                if (stmt2 != null) stmt2.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                // Manejo de errores al cerrar los recursos, imprime el mensaje de error
                System.err.println(ex.getMessage());
            }
        }
    }
}
