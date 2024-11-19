
package glapp;

import conexion.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFrameJefeCuadrilla extends javax.swing.JFrame {
    
    DatabaseConnection con1 = new DatabaseConnection();
    Connection conet;
    DefaultTableModel modelo;
    Statement st;
    ResultSet rs;
    int idc;

    int jefeCuadrilla_id;
    String nombre;
    String email;
    String telefono;
    String usuario;
    String contraseña;
       
    public boolean cargarDatos() {
        // Verifica si alguno de los campos está vacío
        if (txtIdJefeCuadrilla.getText().isEmpty() || 
            txtNombreJefeCuadrilla.getText().isEmpty() || 
            txtCorreoJefeCuadrilla.getText().isEmpty() || 
            txtTelefonoJefeCuadrilla.getText().isEmpty() ||
            txtUsuario.getText().isEmpty() || 
            txtContraseña.getText().isEmpty()) {

            // Muestra un mensaje de error
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos", "Error", 2);
            return false;
        }
        // Si todos los campos tienen datos, se procede a asignar los valores
        jefeCuadrilla_id = Integer.parseInt(txtIdJefeCuadrilla.getText());
        nombre = txtNombreJefeCuadrilla.getText();
        email = txtCorreoJefeCuadrilla.getText();
        telefono = txtTelefonoJefeCuadrilla.getText();
        usuario = txtUsuario.getText();
        contraseña = txtContraseña.getText();
        return true;
    }
    
    public JFrameJefeCuadrilla() {
        initComponents();
        setLocationRelativeTo(null);
        consultar();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdJefeCuadrilla = new javax.swing.JTextField();
        txtNombreJefeCuadrilla = new javax.swing.JTextField();
        txtCorreoJefeCuadrilla = new javax.swing.JTextField();
        txtTelefonoJefeCuadrilla = new javax.swing.JTextField();
        btnAgregarJefeCuadrilla = new javax.swing.JButton();
        btnEditarJefeCuadrilla = new javax.swing.JButton();
        btnEliminarJefeCuadrilla = new javax.swing.JButton();
        btnBuscarJefeCuadrilla = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJefeCuadrilla = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        btnColonias = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("JEFE CUADRILLA");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("OPERACIONES"));

        jLabel2.setText("ID del Jefe Cuadrilla:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Correo:");

        jLabel5.setText("Telefono:");

        txtIdJefeCuadrilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdJefeCuadrillaActionPerformed(evt);
            }
        });

        btnAgregarJefeCuadrilla.setText("Agregar");
        btnAgregarJefeCuadrilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarJefeCuadrillaActionPerformed(evt);
            }
        });

        btnEditarJefeCuadrilla.setText("Editar");
        btnEditarJefeCuadrilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarJefeCuadrillaActionPerformed(evt);
            }
        });

        btnEliminarJefeCuadrilla.setText("Eliminar");
        btnEliminarJefeCuadrilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarJefeCuadrillaActionPerformed(evt);
            }
        });

        btnBuscarJefeCuadrilla.setText("Buscar por ID");
        btnBuscarJefeCuadrilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarJefeCuadrillaActionPerformed(evt);
            }
        });

        jLabel6.setText("Usuario:");

        jLabel7.setText("Contraseña:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContraseña))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsuario))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdJefeCuadrilla, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefonoJefeCuadrilla)
                            .addComponent(txtNombreJefeCuadrilla)
                            .addComponent(txtCorreoJefeCuadrilla))))
                .addGap(148, 148, 148)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregarJefeCuadrilla)
                    .addComponent(btnEliminarJefeCuadrilla))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditarJefeCuadrilla)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnBuscarJefeCuadrilla)))
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdJefeCuadrilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtNombreJefeCuadrilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCorreoJefeCuadrilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTelefonoJefeCuadrilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarJefeCuadrilla)
                            .addComponent(btnEditarJefeCuadrilla))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarJefeCuadrilla)
                            .addComponent(btnBuscarJefeCuadrilla))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS"));

        tablaJefeCuadrilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "JefeCuadrilla_id", "nombre", "email", "telefono", "usuario", "contrasena"
            }
        ));
        tablaJefeCuadrilla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaJefeCuadrillaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaJefeCuadrilla);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("VENTANAS")));

        btnInicio.setText("Inicio");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnColonias.setText("Colonias");
        btnColonias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColoniasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(btnInicio)
                    .addGap(29, 29, 29)
                    .addComponent(btnColonias)
                    .addContainerGap(467, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnInicio)
                        .addComponent(btnColonias))
                    .addContainerGap(39, Short.MAX_VALUE)))
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdJefeCuadrillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdJefeCuadrillaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdJefeCuadrillaActionPerformed

    private void btnAgregarJefeCuadrillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarJefeCuadrillaActionPerformed
       
        try {
           if (cargarDatos()) {
               // Usamos el Builder para crear la instancia de JefeCuadrilla
            JefeCuadrilla metodos = new JefeCuadrilla.Builder()
                .setJefeCuadrilla_id(jefeCuadrilla_id)  // Asegúrate de que estas variables están definidas
                .setNombre(nombre)
                .setEmail(email)
                .setTelefono(telefono)
                .setUsuario(usuario)
                .setContrasena(contraseña)
                .build();  // Llamamos al método build() para obtener la instancia
               metodos.guardar();
           }
       } catch (NumberFormatException e) {
           JOptionPane.showMessageDialog(this, "El ID debe ser un número entero.", "ERROR", JOptionPane.ERROR_MESSAGE);
       }
       consultar();
    }//GEN-LAST:event_btnAgregarJefeCuadrillaActionPerformed

    private void btnEliminarJefeCuadrillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarJefeCuadrillaActionPerformed

            // Llamamos a cargarDatos solo para obtener el ID y verificar si está vacío
       if (!txtIdJefeCuadrilla.getText().isEmpty()) {
           try {
               // Obtener el ID del jefe de cuadrilla desde el campo de texto ya validado
               int jefeCuadrillaId = Integer.parseInt(txtIdJefeCuadrilla.getText());

               // Llamar al método estático eliminar de JefeCuadrilla
               JefeCuadrilla.eliminar(jefeCuadrillaId);

               // Mostrar mensaje de éxito
               JOptionPane.showMessageDialog(this, "Jefe de cuadrilla eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

           } catch (NumberFormatException e) {
               // Capturar si el ID ingresado no es un número válido
               JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
           }
       } else {
           JOptionPane.showMessageDialog(this, "Por favor ingrese el ID del jefe de cuadrilla a eliminar", "Error", JOptionPane.ERROR_MESSAGE);
       }
       consultar();
    }//GEN-LAST:event_btnEliminarJefeCuadrillaActionPerformed

    private void btnEditarJefeCuadrillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarJefeCuadrillaActionPerformed
        try {
            // Verifica si todos los campos están completos y carga los datos
            if (cargarDatos()) {
                // Usamos el Builder para crear la instancia de JefeCuadrilla
            JefeCuadrilla metodos = new JefeCuadrilla.Builder()
                .setJefeCuadrilla_id(jefeCuadrilla_id)  // Asegúrate de que estas variables están definidas
                .setNombre(nombre)
                .setEmail(email)
                .setTelefono(telefono)
                .setUsuario(usuario)
                .setContrasena(contraseña)
                .build();  // Llamamos al método build() para obtener la instancia
                metodos.actualizar();
            }
        } catch (NumberFormatException e) {
            // Muestra un mensaje de error si el ID no es un número válido
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        consultar();
    }//GEN-LAST:event_btnEditarJefeCuadrillaActionPerformed

    private void tablaJefeCuadrillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaJefeCuadrillaMouseClicked
    // Obtiene la fila seleccionada
       int fila = tablaJefeCuadrilla.getSelectedRow();

       if (fila == -1) {
           // Si no se seleccionó ninguna fila
           JOptionPane.showMessageDialog(null, "No se seleccionó ninguna fila");
       } else {
           // Recupera los datos de la fila seleccionada
           int idc = Integer.parseInt(tablaJefeCuadrilla.getValueAt(fila, 0).toString());  // ID
           String nombre = (String) tablaJefeCuadrilla.getValueAt(fila, 1);  // Nombre
           String email = (String) tablaJefeCuadrilla.getValueAt(fila, 2);   // Email
           String telefono = (String) tablaJefeCuadrilla.getValueAt(fila, 3); // Teléfono
           String usuario = (String) tablaJefeCuadrilla.getValueAt(fila, 4);  // Usuario
           String contraseña = (String) tablaJefeCuadrilla.getValueAt(fila, 5); // Contraseña

           // Rellenar los campos con los datos del Jefe de Cuadrilla seleccionado
           txtIdJefeCuadrilla.setText(String.valueOf(idc));  
           txtNombreJefeCuadrilla.setText(nombre);  
           txtCorreoJefeCuadrilla.setText(email);   
           txtTelefonoJefeCuadrilla.setText(telefono);  
           txtUsuario.setText(usuario);  // Asignar usuario
           txtContraseña.setText(contraseña);  // Asignar contraseña
       }
    }//GEN-LAST:event_tablaJefeCuadrillaMouseClicked

    private void btnBuscarJefeCuadrillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarJefeCuadrillaActionPerformed
        // Obtener el ID ingresado por el usuario
        String idTexto = txtIdJefeCuadrilla.getText();

        if (idTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un ID para buscar.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir si el ID está vacío
        }

        try {
            // Convertir el texto a un entero
            int jefeCuadrilla_id = Integer.parseInt(idTexto);

            // Llamar al método para obtener el Jefe de Cuadrilla por ID
            JefeCuadrilla jefe = JefeCuadrilla.obtenerPorId(jefeCuadrilla_id);

            if (jefe != null) {
                // Si se encuentra el Jefe de Cuadrilla, llenar los campos con los datos
                txtIdJefeCuadrilla.setText(String.valueOf(jefe.getJefeCuadrilla_id()));
                txtNombreJefeCuadrilla.setText(jefe.getNombre());
                txtCorreoJefeCuadrilla.setText(jefe.getEmail());
                txtTelefonoJefeCuadrilla.setText(jefe.getTelefono());
                txtUsuario.setText(jefe.getUsuario());  // Campo para usuario
                txtContraseña.setText(jefe.getContrasena()); // Campo para contraseña
            } else {
                // Si no se encuentra el Jefe de Cuadrilla
                JOptionPane.showMessageDialog(this, "No se encontró un Jefe de Cuadrilla con ese ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            // Manejo de error si el ID no es un número válido
            JOptionPane.showMessageDialog(this, "El ID ingresado no es válido. Por favor ingrese un número.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarJefeCuadrillaActionPerformed

    private void btnColoniasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColoniasActionPerformed
   // Crea una nueva instancia del segundo JFrame
    JFrameColonias frameColonia = new JFrameColonias();

    // Muestra el segundo JFrame
    frameColonia.setVisible(true);

    this.dispose();          
    }//GEN-LAST:event_btnColoniasActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
         
    }//GEN-LAST:event_btnInicioActionPerformed

    
    void limpiarTabla() {
        // Recorre las filas de la tabla de abajo hacia arriba
        for (int i = tablaJefeCuadrilla.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    void consultar(){
        limpiarTabla();
        String sql = "select * from jefecuadrilla";
        try {
            conet = con1.getConnection();
            st = conet.createStatement();
            rs = st.executeQuery(sql);
            Object [] jefe = new Object[6];
            modelo = (DefaultTableModel) tablaJefeCuadrilla.getModel();
            
            while(rs.next()){
                jefe [0] = rs.getInt("JefeCuadrilla_id");
                jefe [1] = rs.getString("nombre");
                jefe [2] = rs.getString("email");
                jefe [3] = rs.getString("telefono");
                jefe [4] = rs.getString("usuario");
                jefe [5] = rs.getString("contrasena");
                
                modelo.addRow(jefe);
            }
            tablaJefeCuadrilla.setModel(modelo);
        } catch(Exception e){
            
        }
    }

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
            java.util.logging.Logger.getLogger(JFrameJefeCuadrilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameJefeCuadrilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameJefeCuadrilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameJefeCuadrilla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameJefeCuadrilla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarJefeCuadrilla;
    private javax.swing.JButton btnBuscarJefeCuadrilla;
    private javax.swing.JButton btnColonias;
    private javax.swing.JButton btnEditarJefeCuadrilla;
    private javax.swing.JButton btnEliminarJefeCuadrilla;
    private javax.swing.JButton btnInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaJefeCuadrilla;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtCorreoJefeCuadrilla;
    private javax.swing.JTextField txtIdJefeCuadrilla;
    private javax.swing.JTextField txtNombreJefeCuadrilla;
    private javax.swing.JTextField txtTelefonoJefeCuadrilla;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
