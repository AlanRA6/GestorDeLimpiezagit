
package glapp;

import conexion.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFrameColonias extends javax.swing.JFrame {

    DatabaseConnection con1 = new DatabaseConnection();
    Connection conet;
    DefaultTableModel modelo;
    Statement st;
    ResultSet rs;
    int idc;
    
    int colonia_id;
    String nombre;
    String direccion;
    String codigoPostal;
 
    public JFrameColonias() {
        initComponents();
        setLocationRelativeTo(null);
        consultar();
    }
    
    
    
    public boolean cargarDatos(){
        // Verifica si alguno de los campos está vacío
        if (txtIdColonia.getText().isEmpty() || 
            txtNombreColonia.getText().isEmpty() || 
            txtCodigoPostalColonia.getText().isEmpty() || 
            txtDireccionColonia.getText().isEmpty()) {

            // Muestra un mensaje de error
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Si todos los campos tienen datos, se procede a asignar los valores
        colonia_id = Integer.parseInt(txtIdColonia.getText());
        nombre = txtNombreColonia.getText();
        direccion = txtDireccionColonia.getText();
        codigoPostal = txtCodigoPostalColonia.getText();

        return true;
    }


        
    void limpiarTabla() {
        // Recorre las filas de la tabla de abajo hacia arriba
        for (int i = tablaColonias.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    void consultar(){
        limpiarTabla();
        String sql = "select * from Colonias";
        try {
            conet = con1.getConnection();
            st = conet.createStatement();
            rs = st.executeQuery(sql);
            Object [] colonia = new Object[4];
            modelo = (DefaultTableModel) tablaColonias.getModel();
            
            while(rs.next()){
                colonia [0] = rs.getInt("colonia_id");
                colonia [1] = rs.getString("nombre");
                colonia [2] = rs.getString("direccion");
                colonia [3] = rs.getString("codigo_postal");
                
                modelo.addRow(colonia);
            }
            tablaColonias.setModel(modelo);
        } catch(Exception e){
            
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdColonia = new javax.swing.JTextField();
        txtNombreColonia = new javax.swing.JTextField();
        txtDireccionColonia = new javax.swing.JTextField();
        txtCodigoPostalColonia = new javax.swing.JTextField();
        btnAgregarColonia = new javax.swing.JButton();
        btnEditarColonia = new javax.swing.JButton();
        btnEliminarColonia = new javax.swing.JButton();
        btnBuscarPorIdColonia = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaColonias = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        btnJefeCuadrilla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("COLONIAS");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("OPERACIONES"));

        jLabel2.setText("ID de la Colonia:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Direccion:");

        jLabel5.setText("Codigo Postal:");

        btnAgregarColonia.setText("Agregar");
        btnAgregarColonia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarColoniaActionPerformed(evt);
            }
        });

        btnEditarColonia.setText("Editar");
        btnEditarColonia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarColoniaActionPerformed(evt);
            }
        });

        btnEliminarColonia.setText("Eliminar");
        btnEliminarColonia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarColoniaActionPerformed(evt);
            }
        });

        btnBuscarPorIdColonia.setText("Buscar por Id");
        btnBuscarPorIdColonia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorIdColoniaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdColonia))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoPostalColonia))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccionColonia, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(128, 128, 128)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarColonia)
                    .addComponent(btnEliminarColonia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarPorIdColonia)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEditarColonia)
                        .addGap(12, 12, 12)))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarColonia)
                    .addComponent(btnEditarColonia))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombreColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarColonia)
                            .addComponent(btnBuscarPorIdColonia))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDireccionColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCodigoPostalColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS"));

        tablaColonias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "colonia_id", "nombre", "direccion", "codigo_postal"
            }
        ));
        tablaColonias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaColoniasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaColonias);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("VENTANAS"));

        btnInicio.setText("Inicio");

        btnJefeCuadrilla.setText("Jefe Cuadrillas");
        btnJefeCuadrilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJefeCuadrillaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnJefeCuadrilla)
                .addContainerGap(488, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInicio)
                    .addComponent(btnJefeCuadrilla))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarColoniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarColoniaActionPerformed
            // Verifica si los datos se cargan correctamente
        try {
            // Intenta convertir el texto a un número
            colonia_id = Integer.parseInt(txtIdColonia.getText());

            // Llama a cargarDatosColonia para verificar los otros campos
            if (cargarDatos()) {
                // Crea un nuevo objeto de la clase Colonias y guarda la colonia
                Colonias metodos = new Colonias(colonia_id, nombre, direccion, codigoPostal);
                metodos.guardar();
            }
        } catch (NumberFormatException e) {
            // Muestra una alerta si el ID no es un número válido
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         consultar();        
    }//GEN-LAST:event_btnAgregarColoniaActionPerformed

    private void btnEditarColoniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarColoniaActionPerformed
        try {
            // Verifica si todos los campos están completos y carga los datos
            if (cargarDatos()) {
                // Crea una instancia de JefeCuadrilla con los datos cargados y llama a actualizar
                Colonias metodos = new Colonias(colonia_id, nombre, direccion, codigoPostal);
                metodos.actualizarDireccion(direccion,codigoPostal);
            }
        } catch (NumberFormatException e) {
            // Muestra un mensaje de error si el ID no es un número válido
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        consultar();
    }//GEN-LAST:event_btnEditarColoniaActionPerformed

    private void tablaColoniasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaColoniasMouseClicked
    // Obtiene la fila seleccionada
     int fila = tablaColonias.getSelectedRow();

     if (fila == -1) {
         // Si no se seleccionó ninguna fila
         JOptionPane.showMessageDialog(null, "No se seleccionó ninguna fila");
     } else {
         // Recupera los datos de la fila seleccionada
         int idc = Integer.parseInt(tablaColonias.getValueAt(fila, 0).toString());  // colonia_id
         String nombre = (String) tablaColonias.getValueAt(fila, 1);  // Nombre
         String direccion = (String) tablaColonias.getValueAt(fila, 2);  // Dirección
         String codigoPostal = (String) tablaColonias.getValueAt(fila, 3);  // Código Postal

         // Rellenar los campos con los datos de la colonia seleccionada
         txtIdColonia.setText(""+idc);  
         txtNombreColonia.setText(nombre);  // Asignar el nombre al campo de texto
         txtDireccionColonia.setText(direccion);  // Asignar la dirección al campo de texto
         txtCodigoPostalColonia.setText(codigoPostal);  // Asignar el código postal al campo de texto

         // Si deseas utilizar algún combo box o campo adicional, puedes adaptarlo aquí también
     }
    }//GEN-LAST:event_tablaColoniasMouseClicked

    private void btnEliminarColoniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarColoniaActionPerformed
      // Llamamos a cargarDatosColonia solo para obtener el ID y verificar si está vacío
    if (!txtIdColonia.getText().isEmpty()) {
        try {
            // Obtener el ID de la colonia desde el campo de texto ya validado
            int coloniaId = Integer.parseInt(txtIdColonia.getText());

            // Crear una nueva instancia de Colonias con el ID proporcionado
            Colonias metodos = new Colonias(coloniaId, "", "", ""); // Los otros campos no se usan, pero es necesario para el constructor

            // Llamar al método eliminar de la clase Colonias
            metodos.eliminar();
           
            JOptionPane.showMessageDialog(this, "Colonia eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
          
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor ingrese el ID de la colonia a eliminar", "Error", JOptionPane.ERROR_MESSAGE);
    }
    consultar(); 
    }//GEN-LAST:event_btnEliminarColoniaActionPerformed

    private void btnBuscarPorIdColoniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorIdColoniaActionPerformed
            // Obtener el ID ingresado por el usuario
         String idTexto = txtIdColonia.getText();

         if (idTexto.isEmpty()) {
             JOptionPane.showMessageDialog(this, "Por favor ingrese un ID para buscar.", "Error", JOptionPane.ERROR_MESSAGE);
             return; // Salir si el ID está vacío
         }

         try {
             
             int colonia_id = Integer.parseInt(idTexto);
             
             Colonias colonia = Colonias.obtenerPorId(colonia_id);

             if (colonia != null) {
                 // Si se encuentra la colonia, llenar los campos con los datos
                 txtIdColonia.setText(String.valueOf(colonia.getColonia_id()));
                 txtNombreColonia.setText(colonia.getNombre());
                 txtDireccionColonia.setText(colonia.getDireccion());
                 txtCodigoPostalColonia.setText(colonia.getCodigoPostal());
             } else {
                 // Si no se encuentra la colonia
                 JOptionPane.showMessageDialog(this, "No se encontró una Colonia con ese ID.", "Error", JOptionPane.ERROR_MESSAGE);
             }
         } catch (NumberFormatException e) {
             // Manejo de error si el ID no es un número válido
             JOptionPane.showMessageDialog(this, "El ID ingresado no es válido. Por favor ingrese un número.", "Error", JOptionPane.ERROR_MESSAGE);
         }
    }//GEN-LAST:event_btnBuscarPorIdColoniaActionPerformed

    private void btnJefeCuadrillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJefeCuadrillaActionPerformed
   // Crea una nueva instancia del segundo JFrame
    JFrameJefeCuadrilla frameJefe = new JFrameJefeCuadrilla();

    // Muestra el segundo JFrame
    frameJefe.setVisible(true);

    this.dispose();      
    }//GEN-LAST:event_btnJefeCuadrillaActionPerformed


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
            java.util.logging.Logger.getLogger(JFrameColonias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameColonias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameColonias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameColonias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameColonias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarColonia;
    private javax.swing.JButton btnBuscarPorIdColonia;
    private javax.swing.JButton btnEditarColonia;
    private javax.swing.JButton btnEliminarColonia;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnJefeCuadrilla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaColonias;
    private javax.swing.JTextField txtCodigoPostalColonia;
    private javax.swing.JTextField txtDireccionColonia;
    private javax.swing.JTextField txtIdColonia;
    private javax.swing.JTextField txtNombreColonia;
    // End of variables declaration//GEN-END:variables
}
