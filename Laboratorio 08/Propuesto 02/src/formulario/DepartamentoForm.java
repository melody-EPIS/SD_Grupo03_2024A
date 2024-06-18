package formulario;

import javax.swing.*;  // Importa todas las clases del paquete javax.swing para la GUI
import java.sql.*;  // Importa todas las clases del paquete java.sql para manejar la base de datos
import javax.swing.table.DefaultTableModel;  // Importa DefaultTableModel para manejar los datos en la tabla
import lab08.Conector;  // Importa la clase Conector del paquete lab08

public class DepartamentoForm extends javax.swing.JFrame {

    Conector cc = new Conector();  // Crea una instancia de la clase Conector
    Connection con = cc.conexion();  // Establece la conexión a la base de datos

    public DepartamentoForm() {
        initComponents();  // Inicializa los componentes de la interfaz gráfica
        this.setLocationRelativeTo(null);  // Centra la ventana en la pantalla
        this.getContentPane().setBackground(getBackground());  // Establece el fondo del contenido de la ventana
        mostrarDatos();  // Llama al método para mostrar los datos de la base de datos en la tabla
    }

    /**
     * Este método es llamado desde el constructor para inicializar el formulario.
     * ADVERTENCIA: No modificar este código. El contenido de este método es siempre
     * regenerado por el Editor de Formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();  // Etiqueta para el título
        jLabel2 = new javax.swing.JLabel();  // Etiqueta para el ID del Departamento
        txtIdDepartamento = new javax.swing.JTextField();  // Campo de texto para el ID del Departamento
        jLabel3 = new javax.swing.JLabel();  // Etiqueta para el Teléfono
        txtTelefono = new javax.swing.JTextField();  // Campo de texto para el Teléfono
        txtNombre = new javax.swing.JTextField();  // Campo de texto para el Nombre
        txtFax = new javax.swing.JTextField();  // Campo de texto para el Fax
        jLabel4 = new javax.swing.JLabel();  // Etiqueta para el Fax
        jLabel5 = new javax.swing.JLabel();  // Etiqueta para el Nombre
        btnNuevo = new javax.swing.JButton();  // Botón para Nuevo
        btnInsertar = new javax.swing.JButton();  // Botón para Insertar
        btnEliminar = new javax.swing.JButton();  // Botón para Eliminar
        btnActualizar = new javax.swing.JButton();  // Botón para Actualizar
        jScrollPane1 = new javax.swing.JScrollPane();  // Scroll pane para la tabla
        tablaDepartamentos = new javax.swing.JTable();  // Tabla para mostrar los departamentos

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);  // Configura la operación de cierre de la ventana
        setTitle("DEPARTAMENTOS");  // Establece el título de la ventana
        setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N  // Establece la fuente de la ventana
        setLocation(new java.awt.Point(30, 60));  // Establece la ubicación de la ventana

        jLabel1.setText("DEPARTAMENTOS\n");  // Establece el texto del título

        jLabel2.setText("id del Departamento");  // Establece el texto para el ID del Departamento

        txtIdDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdDepartamentoActionPerformed(evt);  // Método para manejar la acción cuando se ingresa un ID de Departamento
            }
        });

        jLabel3.setText("Telefono");  // Establece el texto para el Teléfono

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);  // Método para manejar la acción cuando se ingresa un Nombre
            }
        });

        txtFax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFaxActionPerformed(evt);  // Método para manejar la acción cuando se ingresa un Fax
            }
        });

        jLabel4.setText("FAX");  // Establece el texto para el Fax

        jLabel5.setText("Nombre");  // Establece el texto para el Nombre

        btnNuevo.setText("Nuevo");  // Establece el texto del botón Nuevo
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);  // Método para manejar la acción del botón Nuevo
            }
        });

        btnInsertar.setText("Guardar");  // Establece el texto del botón Insertar
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);  // Método para manejar la acción del botón Insertar
            }
        });

        btnEliminar.setText("Eliminar");  // Establece el texto del botón Eliminar
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);  // Método para manejar la acción del botón Eliminar
            }
        });

        btnActualizar.setText("Actualizar");  // Establece el texto del botón Actualizar
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);  // Método para manejar la acción del botón Actualizar
            }
        });

        tablaDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));  // Modelo de tabla predeterminado
        jScrollPane1.setViewportView(tablaDepartamentos);  // Establece la tabla en el scroll pane

        // Configuración del layout de la ventana
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(txtIdDepartamento))
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre)
                            .addComponent(txtFax, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addGap(0, 92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18
