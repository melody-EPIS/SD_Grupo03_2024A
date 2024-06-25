package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CoffeeSalesGUI extends JFrame {

    private static final String url = "jdbc:mysql://localhost:3307/coffee_shop";
    private static final String user = "root";
    private static final String password = "";
    private Connection con;

    private Map<String, JTextField> coffeeSalesFields;

    public CoffeeSalesGUI() {
        initComponents();
        initializeConnection();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ventas de Café");

        JPanel panel = new JPanel(new GridLayout(0, 2));

        coffeeSalesFields = new HashMap<>();
        coffeeSalesFields.put("Colombian", new JTextField(10));
        coffeeSalesFields.put("French_Roast", new JTextField(10));
        coffeeSalesFields.put("Espresso", new JTextField(10));

        for (String coffee : coffeeSalesFields.keySet()) {
            panel.add(new JLabel(coffee));
            panel.add(coffeeSalesFields.get(coffee));
        }

        JButton updateButton = new JButton("Completar venta");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSales();
            }
        });

        panel.add(updateButton);

        getContentPane().add(panel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private void initializeConnection() {
        try {
            con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(true); // Habilitar autocommit por defecto
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void updateSales() {
        String updateSalesString = "UPDATE COFFEES SET SALES = ?, TOTAL = TOTAL + ? WHERE COF_NAME = ?";

        try {
            if (con == null || con.isClosed()) {
                con = DriverManager.getConnection(url, user, password);
            }

            con.setAutoCommit(false); // Desactivar autocommit para iniciar una transacción

            try (PreparedStatement updateSales = con.prepareStatement(updateSalesString)) {
                for (String coffee : coffeeSalesFields.keySet()) {
                    int sales = Integer.parseInt(coffeeSalesFields.get(coffee).getText());
                    updateSales.setInt(1, sales);
                    updateSales.setInt(2, sales);
                    updateSales.setString(3, coffee);
                    updateSales.executeUpdate();
                }

                con.commit(); // Confirmar la transacción
                JOptionPane.showMessageDialog(this, "Ventas actualizadas correctamente.");
            } catch (SQLException ex) {
                con.rollback(); // Deshacer la transacción en caso de error
                JOptionPane.showMessageDialog(this, "Error al actualizar ventas: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                con.setAutoCommit(true); // Volver a habilitar autocommit
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CoffeeSalesGUI().setVisible(true);
            }
        });
    }
}
