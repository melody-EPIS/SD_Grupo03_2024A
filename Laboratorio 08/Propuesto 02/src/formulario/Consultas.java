
package formulario;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import lab08.Conector;  

public class Consultas extends javax.swing.JFrame {
    Conector cc = new Conector();
    Connection con = cc.conexion();
    public Consultas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIdDepartamento = new javax.swing.JTextField();
        txtIdProyecto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProyectos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaIngenieros = new javax.swing.JTable();
        btnConsultarProyectos = new javax.swing.JButton();
        btnConsultarIngenieros = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id del departamento : ");

        jLabel2.setText("Id del proyecto : ");

        jLabel3.setText("CONSULTAR INGENIEROS QUE PARTICIPAN EN UN DETERMINADO PROYECTO");

        jLabel4.setText("CONSULTAR PROYECTOS DE UN DETERMINADO DEPARTAMENTO");

        tablaProyectos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "IDProyecto", "NombreProyecto", "FechaIni", "FechaFin"
            }
        ));
        jScrollPane1.setViewportView(tablaProyectos);

        tablaIngenieros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "idInge", "Especialidad", "Cargo"
            }
        ));
        jScrollPane2.setViewportView(tablaIngenieros);

        btnConsultarProyectos.setText("Consultar Proyectos");
        btnConsultarProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarProyectosActionPerformed(evt);
            }
        });

        btnConsultarIngenieros.setText("Consultar Ingenieros");
        btnConsultarIngenieros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarIngenierosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(txtIdProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConsultarIngenieros, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConsultarProyectos)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIdDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(btnConsultarProyectos)
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(btnConsultarIngenieros))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void consultarProyectosPorDepartamento(int idDepartamento) {
    String[] titulos = {"IDProyecto", "NombreProyecto", "FechaIni", "FechaFin"};
    String[] registros = new String[4];
    DefaultTableModel modelo = new DefaultTableModel(null, titulos);
    String SQL = "SELECT * FROM proyectos WHERE idDepartamento = " + idDepartamento;

    try {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(SQL);
        while (rs.next()) {
            registros[0] = rs.getString("idProyecto");
            registros[1] = rs.getString("nombre");
            registros[2] = rs.getString("fechaInicio");
            registros[3] = rs.getString("fechaFin");
            modelo.addRow(registros);
        }
        tablaProyectos.setModel(modelo);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
    private void consultarIngenierosPorProyecto(int idProyecto) {
    String[] titulos = {"idInge", "Especialidad", "Cargo"};
    String[] registros = new String[3];
    DefaultTableModel modelo = new DefaultTableModel(null, titulos);
    String SQL = "SELECT ingenieros.idIngeniero, ingenieros.especialidad, ingenieros.cargo " +
                 "FROM ingenieros " +
                 "JOIN proyectos ON ingenieros.idIngeniero = proyectos.idIngeniero " +
                 "WHERE proyectos.idProyecto = " + idProyecto;

    try {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(SQL);
        while (rs.next()) {
            registros[0] = rs.getString("idIngeniero");
            registros[1] = rs.getString("especialidad");
            registros[2] = rs.getString("cargo");
            modelo.addRow(registros);
        }
        tablaIngenieros.setModel(modelo);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
}
    private void btnConsultarProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarProyectosActionPerformed
        String idDepartamento = txtIdDepartamento.getText();
        consultarProyectosPorDepartamento(Integer.parseInt(idDepartamento));
    }//GEN-LAST:event_btnConsultarProyectosActionPerformed

    private void btnConsultarIngenierosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarIngenierosActionPerformed
        String idProyecto = txtIdProyecto.getText();
        consultarIngenierosPorProyecto(Integer.parseInt(idProyecto));
    }//GEN-LAST:event_btnConsultarIngenierosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarIngenieros;
    private javax.swing.JButton btnConsultarProyectos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaIngenieros;
    private javax.swing.JTable tablaProyectos;
    private javax.swing.JTextField txtIdDepartamento;
    private javax.swing.JTextField txtIdProyecto;
    // End of variables declaration//GEN-END:variables
}
