/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    // Nombre de la base de datos
    private final static String bd = "BASE_DE_DATOS";
    // Nombre de usuario para la base de datos
    private final static String login = "root";
    // Contraseña para la base de datos
    private final static String password = "";
    // URL de conexión a la base de datos, incluye el puerto, deshabilita SSL y establece la zona horaria
    private final static String url = "jdbc:mysql://localhost:3306/" + bd + "?useSSL=false&serverTimezone=UTC";

    // Método para obtener una conexión a la base de datos
    public static Connection getConnection() {
        try {
            // Carga el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Intenta establecer la conexión con la base de datos
            Connection conn = DriverManager.getConnection(url, login, password);
            if (conn != null) {
                // Si la conexión se establece con éxito, imprime un mensaje de confirmación
                System.out.println("Conectado a la base de datos [" + bd + "]");
            }
            return conn; // Devuelve la conexión establecida
        } catch (SQLException e) {
            // Manejo de errores de SQL, imprime el mensaje de error
            System.err.println("Error de conexión: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            // Manejo de errores si el driver no se encuentra, imprime el mensaje de error
            System.err.println("Driver no encontrado: " + e.getMessage());
        }
        return null; // Devuelve null si la conexión no se pudo establecer
    }
}

