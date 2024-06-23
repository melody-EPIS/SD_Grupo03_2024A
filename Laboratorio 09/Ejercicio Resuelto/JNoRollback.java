/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JNoRollback {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Obtiene la conexión a la base de datos
        Connection connection = Database.getConnection();
        // Declaración de los PreparedStatement
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;

        try {
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
        } catch (SQLException ex) {
            // Manejo de errores de SQL, imprime el mensaje de error
            System.err.println("ERROR: " + ex.getMessage());
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
