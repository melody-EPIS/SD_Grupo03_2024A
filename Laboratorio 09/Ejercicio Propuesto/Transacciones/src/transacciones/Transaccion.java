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
        String updateSalesString = "UPDATE COFFEES SET SALES = ? WHERE COF_NAME = ?";
        String updateTotalString = "UPDATE COFFEES SET TOTAL = TOTAL + ? WHERE COF_NAME = ?";

        try (PreparedStatement updateSales = con.prepareStatement(updateSalesString);
             PreparedStatement updateTotal = con.prepareStatement(updateTotalString)) {

            con.setAutoCommit(false); // Desactivar autocommit

            for (Map.Entry<String, Integer> entry : salesForWeek.entrySet()) {
                updateSales.setInt(1, entry.getValue());
                updateSales.setString(2, entry.getKey());
                updateSales.executeUpdate();

                updateTotal.setInt(1, entry.getValue());
                updateTotal.setString(2, entry.getKey());
                updateTotal.executeUpdate();
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
            e.printStackTrace();
        } finally {
            con.setAutoCommit(true); // Volver a habilitar autocommit
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/coffee_shop"; // URL de la base de datos
        String user = "root"; // Usuario de MySQL
        String password = ""; // Contraseña de MySQL (deja en blanco si no tienes contraseña)

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            HashMap<String, Integer> salesForWeek = new HashMap<>();
            salesForWeek.put("Colombian", 50);
            salesForWeek.put("French_Roast", 75);
            salesForWeek.put("Espresso", 100);

            updateCoffeeSales(con, salesForWeek); // Actualizar ventas de café
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
