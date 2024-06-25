package transacciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Transaccion {

    // Método para actualizar las ventas de café
    public static void updateCoffeeSales(Connection con, HashMap<String, Integer> salesForWeek) throws SQLException {
        // Consultas SQL para actualizar las ventas y el total de ventas
        String updateSalesString = "UPDATE COFFEES SET SALES = ? WHERE COF_NAME = ?";
        String updateTotalString = "UPDATE COFFEES SET TOTAL = TOTAL + ? WHERE COF_NAME = ?";

        try (PreparedStatement updateSales = con.prepareStatement(updateSalesString);
             PreparedStatement updateTotal = con.prepareStatement(updateTotalString)) {

            con.setAutoCommit(false); // Desactivar autocommit

            // Iterar sobre las ventas semanales proporcionadas
            for (Map.Entry<String, Integer> entry : salesForWeek.entrySet()) {
                // Configurar los parámetros para la consulta de actualización de SALES
                updateSales.setInt(1, entry.getValue());
                updateSales.setString(2, entry.getKey());
                updateSales.executeUpdate(); // Ejecutar la consulta de actualización de SALES

                // Configurar los parámetros para la consulta de actualización de TOTAL
                updateTotal.setInt(1, entry.getValue());
                updateTotal.setString(2, entry.getKey());
                updateTotal.executeUpdate(); // Ejecutar la consulta de actualización de TOTAL
            }

            con.commit(); // Confirmar la transacción
            System.out.println("Transaction committed successfully.");
        } catch (SQLException e) {
            if (con != null) {
                try {
                    con.rollback(); // Deshacer la transacción en caso de error
                    System.err.println("Transaction is being rolled back.");
                } catch (SQLException excep) {
                    excep.printStackTrace();
                }
            }
            e.printStackTrace(); // Imprimir la traza de la excepción
        } finally {
            con.setAutoCommit(true); // Volver a habilitar autocommit
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/coffee_shop"; // URL de la base de datos
        String user = "root"; // Usuario de MySQL
        String password = ""; // Contraseña de MySQL (deja en blanco si no tienes contraseña)

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            // Crear un mapa para almacenar las ventas semanales de café
            HashMap<String, Integer> salesForWeek = new HashMap<>();
            salesForWeek.put("Colombian", 50);
            salesForWeek.put("French_Roast", 75);
            salesForWeek.put("Espresso", 100);

            // Llamar al método para actualizar las ventas de café
            updateCoffeeSales(con, salesForWeek);
        } catch (SQLException e) {
            e.printStackTrace(); // Imprimir la traza de la excepción si ocurre un error SQL
        }
    }
}
