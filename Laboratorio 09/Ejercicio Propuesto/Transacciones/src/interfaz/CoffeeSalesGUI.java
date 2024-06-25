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

    // URL de conexión a la base de datos MySQL
    private static final String url = "jdbc:mysql://localhost:3307/coffee_shop";
    private static final String user = "root"; // Usuario de MySQL
    private static final String password = ""; // Contraseña de MySQL (dejar en blanco si no hay contraseña)
    private Connection con; // Objeto de conexión a la base de datos

    // Mapa para almacenar los campos de texto de las ventas de café
    private Map<String, JTextField> coffeeSalesFields;

    public CoffeeSalesGUI() {
        initComponents(); // Método para inicializar los componentes de la GUI
        initializeConnection(); // Método para inicializar la conexión a la base de datos
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Establece el cierre de la ventana como operación de salida
        setTitle("Ventas de Café"); // Establece el título de la ventana

        JPanel panel = new JPanel(new GridLayout(0, 2)); // Crea un panel con disposición de cuadrícula 2 columnas

        coffeeSalesFields = new HashMap<>(); // Inicializa el mapa para los campos de ventas de café
        coffeeSalesFields.put("Colombian", new JTextField(10)); // Añade un JTextField para el café Colombian
        coffeeSalesFields.put("French_Roast", new JTextField(10)); // Añade un JTextField para el café French Roast
        coffeeSalesFields.put("Espresso", new JTextField(10)); // Añade un JTextField para el café Espresso

        // Agrega etiquetas y campos de texto al panel
        for (String coffee : coffeeSalesFields.keySet()) {
            panel.add(new JLabel(coffee)); // Añade una etiqueta con el nombre del café
            panel.add(coffeeSalesFields.get(coffee)); // Añade el campo de texto correspondiente al café
        }

        JButton updateButton = new JButton("Completar venta"); // Crea un botón para actualizar las ventas
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSales(); // Método que se llama al hacer clic en el botón
            }
        });

        panel.add(updateButton); // Agrega el botón al panel

        getContentPane().add(panel, BorderLayout.CENTER); // Agrega el panel al contenido principal de la ventana
        pack(); // Ajusta automáticamente el tamaño de la ventana según su contenido
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
    }

    private void initializeConnection() {
        try {
            con = DriverManager.getConnection(url, user, password); // Establece la conexión a la base de datos
            con.setAutoCommit(true); // Habilita el autocommit por defecto
        } catch (SQLException e) {
            // Muestra un mensaje de error si no se puede conectar a la base de datos
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace(); // Imprime la traza del error en la consola
            System.exit(1); // Sale del programa con código de error 1
        }
    }

    private void updateSales() {
        String updateSalesString = "UPDATE COFFEES SET SALES = ?, TOTAL = TOTAL + ? WHERE COF_NAME = ?";

        try {
            if (con == null || con.isClosed()) {
                con = DriverManager.getConnection(url, user, password); // Reconecta si la conexión está cerrada
            }

            con.setAutoCommit(false); // Desactiva el autocommit para iniciar una transacción

            try (PreparedStatement updateSales = con.prepareStatement(updateSalesString)) {
                // Itera sobre los campos de ventas de café para actualizar la base de datos
                for (String coffee : coffeeSalesFields.keySet()) {
                    int sales = Integer.parseInt(coffeeSalesFields.get(coffee).getText()); // Obtiene las ventas del JTextField
                    updateSales.setInt(1, sales); // Establece el valor de SALES en la consulta preparada
                    updateSales.setInt(2, sales); // Establece el valor de TOTAL en la consulta preparada
                    updateSales.setString(3, coffee); // Establece el nombre del café en la consulta preparada
                    updateSales.executeUpdate(); // Ejecuta la actualización en la base de datos
                }

                con.commit(); // Confirma la transacción si todas las actualizaciones son exitosas
                JOptionPane.showMessageDialog(this, "Ventas actualizadas correctamente."); // Muestra un mensaje de éxito
            } catch (SQLException ex) {
                con.rollback(); // Deshace la transacción en caso de error
                JOptionPane.showMessageDialog(this, "Error al actualizar ventas: " + ex.getMessage()); // Muestra un mensaje de error
                ex.printStackTrace(); // Imprime la traza del error en la consola
            } finally {
                con.setAutoCommit(true); // Vuelve a habilitar el autocommit después de la transacción
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos: " + ex.getMessage()); // Muestra un mensaje de error de conexión
            ex.printStackTrace(); // Imprime la traza del error en la consola
        }
    }

    public static void main(String[] args) {
        // Ejecuta la creación de la GUI en el hilo de despacho de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CoffeeSalesGUI().setVisible(true); // Crea una instancia de la GUI y la hace visible
            }
        });
    }
}
