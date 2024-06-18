package lab08;

import java.sql.Connection;  // Importa la clase Connection para manejar la conexión a la base de datos
import java.sql.DriverManager;  // Importa la clase DriverManager para gestionar los drivers de la base de datos
import java.sql.SQLException;  // Importa la clase SQLException para manejar excepciones SQL
import javax.swing.JOptionPane;  // Importa la clase JOptionPane para mostrar cuadros de diálogo

public class Conector {
    private Connection conectar = null;  // Declara una variable de tipo Connection para mantener la conexión

    // Método para establecer la conexión a la base de datos
    public Connection conexion() {
        try {
            // Carga el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establece la conexión con la base de datos especificada (URL, usuario, contraseña)
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "123456");
            // Muestra un mensaje de éxito si la conexión es exitosa
            JOptionPane.showMessageDialog(null, "Conexión exitosa");
        } catch (ClassNotFoundException e) {
            // Maneja la excepción si no se encuentra el driver de la base de datos
            JOptionPane.showMessageDialog(null, "Error: No se encuentra el driver de la base de datos");
        } catch (SQLException e) {
            // Maneja las excepciones SQL y muestra el mensaje de error correspondiente
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
        }
        // Retorna la conexión establecida (o null si no se pudo establecer)
        return conectar;
    }
}
