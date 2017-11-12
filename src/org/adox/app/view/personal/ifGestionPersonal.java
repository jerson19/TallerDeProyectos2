package org.adox.app.view.personal;

import java.beans.PropertyVetoException;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.adox.app.common.ConstantesApp;
import org.adox.app.entities.Personal;
import org.adox.app.util.LogsUtil;
import org.adox.app.util.ProgressUtil;
import org.adox.app.view.aplicacion.ifAsistenciasManuales;
import org.adox.app.view.frmPrincipal;
import org.apache.log4j.Logger;

/**
 * @author Adolfo
 ifPersonal.java
 Created on 07-abr-2011, 13:36:33
 */
public class ifGestionPersonal extends javax.swing.JInternalFrame {

    static Logger oClass = Logger.getLogger("ifGestionPersonal");
    Personal oPersonal;

    public ifGestionPersonal() {
        initComponents();
        _init();
        ProgressUtil.stop();
    }

    private void _init() {
        modTablaCliente = (DefaultTableModel) tabla.getModel();
        lblPersonal.setText("");
        if (ConstantesApp.ID_ROL.equals("2")) {
            btnAsistencia.setVisible(false);
            btnPermisos.setVisible(false);
        }
        if (ConstantesApp.ID_ROL.equals("3")) {
            btnNuevo.setVisible(false);
            btnEditar.setVisible(false);
            btnPermisos.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPersonal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        lblPersonal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanelBotones = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnAsistencia = new javax.swing.JButton();
        btnPermisos = new javax.swing.JButton();
        btnPermisos1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle(" ::: BÚSQUEDA DEL PERSONAL ::: "); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/adox.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Búsqueda de Docente");
        jLabel1.setName("jLabel1"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(4, 48, 4, 26);
        jPanel1.add(jLabel1, gridBagConstraints);

        txtPersonal.setName("txtPersonal"); // NOI18N
        txtPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPersonalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 513;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        jPanel1.add(txtPersonal, gridBagConstraints);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_buscar.PNG"))); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 11);
        jPanel1.add(jButton1, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(840, 374));

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Documento", "Nombre", "Apeliido Paterno", "Apeliido Materno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setName("tabla"); // NOI18N
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        lblPersonal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersonal.setForeground(new java.awt.Color(0, 0, 102));
        lblPersonal.setText("Nombres y Apellidos");
        lblPersonal.setName("lblPersonal"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Personal");
        jLabel4.setName("jLabel4"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(34, 34, 34)
                        .addComponent(lblPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblPersonal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelBotones.setBackground(new java.awt.Color(51, 51, 51));
        jPanelBotones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jPanelBotones.setName("jPanelBotones"); // NOI18N

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSalir.setName("btnSalir"); // NOI18N
        btnSalir.setPreferredSize(new java.awt.Dimension(100, 60));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_agregar.png"))); // NOI18N
        btnNuevo.setText("Agregar");
        btnNuevo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNuevo.setName("btnNuevo"); // NOI18N
        btnNuevo.setPreferredSize(new java.awt.Dimension(100, 60));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_editar.PNG"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEditar.setName("btnEditar"); // NOI18N
        btnEditar.setPreferredSize(new java.awt.Dimension(100, 60));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnLimpiar.setName("btnLimpiar"); // NOI18N
        btnLimpiar.setPreferredSize(new java.awt.Dimension(100, 60));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnAsistencia.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/u_personal.png"))); // NOI18N
        btnAsistencia.setText("Justificar");
        btnAsistencia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAsistencia.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAsistencia.setName("btnAsistencia"); // NOI18N
        btnAsistencia.setPreferredSize(new java.awt.Dimension(100, 60));
        btnAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciaActionPerformed(evt);
            }
        });

        btnPermisos.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnPermisos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/btn_seguridad.png"))); // NOI18N
        btnPermisos.setText("Permisos");
        btnPermisos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPermisos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPermisos.setName("btnPermisos"); // NOI18N
        btnPermisos.setPreferredSize(new java.awt.Dimension(100, 60));
        btnPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermisosActionPerformed(evt);
            }
        });

        btnPermisos1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnPermisos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/u_cliente.png"))); // NOI18N
        btnPermisos1.setText("Cargar Personal");
        btnPermisos1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPermisos1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPermisos1.setName("btnPermisos1"); // NOI18N
        btnPermisos1.setPreferredSize(new java.awt.Dimension(100, 60));
        btnPermisos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermisos1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(jPanelBotones);
        jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPermisos, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPermisos1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBotonesLayout.setVerticalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPermisos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPermisos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
}//GEN-LAST:event_btnSalirActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        Perfil = "N";
        GestionPersonal();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        Perfil = "E";
        GestionPersonal();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        seleccionar();
    }//GEN-LAST:event_tablaMouseClicked

    private void txtPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPersonalActionPerformed
        buscar();
    }//GEN-LAST:event_txtPersonalActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarTabla();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsistenciaActionPerformed
        GestionAsistenciaManual();
    }//GEN-LAST:event_btnAsistenciaActionPerformed

    private void btnPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPermisosActionPerformed
        // TODO add your handling code here:
        Permisos();
}//GEN-LAST:event_btnPermisosActionPerformed

    private void btnPermisos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPermisos1ActionPerformed
        CargarPersonal();
    }//GEN-LAST:event_btnPermisos1ActionPerformed

    private void Permisos() {
        ProgressUtil oProgressUtil = new ProgressUtil();
        oProgressUtil.load();
        Thread p = new Thread() {

            public void run() {
                abrirPermisos();
            }
        };
        p.start();
    }
    JInternalFrame gPermisos;

    private void abrirPermisos() {
        if (idPersonal.equals("")) {
            JOptionPane.showMessageDialog(this, "Seleccione un personal", "Atención", JOptionPane.INFORMATION_MESSAGE);
            ProgressUtil.stop();
            return;
        }
        if (estacerrado(gPermisos)) {
            gPermisos = new JInternalFrame("::: GESTIÓN DE PERMISOS :::");
            ifUsuarios obj = new ifUsuarios(idPersonal);
            gPermisos.add(obj);
            gPermisos.setIconifiable(true);
            gPermisos.setClosable(true);
            gPermisos.pack();
            abrirMarcoInterno(gPermisos);
        } else {
            JOptionPane.showMessageDialog(this, ConstantesApp.MENSAJE_FORMULARIO_ABIERTO);
        }
        ProgressUtil.stop();
    }

    private void GestionAsistenciaManual() {
        ProgressUtil oProgressUtil = new ProgressUtil();
        oProgressUtil.load();
        Thread p = new Thread() {

            public void run() {
                abrirAsistenciaManual();
            }
        };
        p.start();
    }
    String Perfil;

    private void GestionPersonal() {
        ProgressUtil oProgressUtil = new ProgressUtil();
        oProgressUtil.load();
        Thread p = new Thread() {

            public void run() {
                abrirPersonal();
            }
        };
        p.start();
    }
    //cambiar aca
    public static ifPersonal gPersonal;
    public static frmRegistroPersonalManual gPersonalManual;

    private void abrirPersonal() {
        try {
            if (estacerrado(gPersonal)) {
                if (Perfil.equals("N")) {
                    gPersonal = new ifPersonal(Perfil);
                    abrirMarcoInterno(gPersonal);
                }
                if (Perfil.equals("E")) {
                    if (idPersonal.equals("")) {
                        JOptionPane.showMessageDialog(this, "Seleccione un personal", "Atención", JOptionPane.INFORMATION_MESSAGE);
                        ProgressUtil.stop();
                        return;
                    }
                    gPersonal = new ifPersonal(Perfil, idPersonal);
                    abrirMarcoInterno(gPersonal);
                }
            } else {
                JOptionPane.showMessageDialog(this, ConstantesApp.MENSAJE_FORMULARIO_ABIERTO);
            }
        } catch (Exception e) {
            LogsUtil.Msg(oClass, "INTENTE NUEVAMENTE POR FAVOR \nDESCRIPCION ERROR " + e.getMessage(), "ATENCION", JOptionPane.INFORMATION_MESSAGE);
        }
        ProgressUtil.stop();
    }
    ifAsistenciasManuales gAsistencia;

    private void abrirAsistenciaManual() {
        if (idPersonal.equals("")) {
            JOptionPane.showMessageDialog(this, "Seleccione un personal", "Atención", JOptionPane.INFORMATION_MESSAGE);
            ProgressUtil.stop();
            return;
        }
        if (estacerrado(gAsistencia)) {
            gAsistencia = new ifAsistenciasManuales(idPersonal, documento, Personal);
            abrirMarcoInterno(gAsistencia);
        } else {
            JOptionPane.showMessageDialog(this, ConstantesApp.MENSAJE_FORMULARIO_ABIERTO);
        }
        ProgressUtil.stop();
    }
    /**/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsistencia;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPermisos;
    private javax.swing.JButton btnPermisos1;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPersonal;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtPersonal;
    // End of variables declaration//GEN-END:variables
   /* ABRIR MARCOS INTERNOS */
    private int xSigMarco;
    private int ySigMarco;
    private int distanciaEntreMarcos;

    private void abrirMarcoInterno(JInternalFrame oJInternalFrame) {
        oJInternalFrame.setLocation(xSigMarco, ySigMarco);
        oJInternalFrame.setVisible(true);
        frmPrincipal.contenedorIf.add(oJInternalFrame);
        try {
            oJInternalFrame.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/adox.png")));
            oJInternalFrame.setAutoscrolls(true);
            oJInternalFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
            LogsUtil.LogsApp(oClass, "ERROR AL ABRIR UN FORMULARIO INTERNO " + ex, ConstantesApp.ERROR_ERROR);
        }

        if (distanciaEntreMarcos == 0) {
            distanciaEntreMarcos = oJInternalFrame.getHeight() - oJInternalFrame.getContentPane().getHeight();
        }

        xSigMarco += distanciaEntreMarcos;
        ySigMarco += distanciaEntreMarcos;

        if (xSigMarco + oJInternalFrame.getWidth() > frmPrincipal.contenedorIf.getWidth()) {
            xSigMarco = 0;
        }
        if (ySigMarco + oJInternalFrame.getHeight() > frmPrincipal.contenedorIf.getHeight()) {
            ySigMarco = 0;
        }
        repaint();
    }

//METODO QUE DEVUELVE UN VALOR BOOLEAN PARA SABER SI UN JINTERNALFRAME ESTA ABIERTO O NO
    public boolean estacerrado(Object obj) {
        JInternalFrame[] activos = frmPrincipal.contenedorIf.getAllFrames();
        boolean cerrado = true;
        int i = 0;
        while (i < activos.length && cerrado) {
            if (activos[i] == obj) {
                cerrado = false;
            }
            i++;
        }
        return cerrado;
    }
    List<Personal> listPersonal;
    DefaultTableModel modTablaCliente;

    private void buscar() {
        ProgressUtil oProgressUtil = new ProgressUtil();
        oProgressUtil.load();
        Thread p = new Thread() {

            public void run() {
                buscarImpl();
            }
        };
        p.start();
    }

    private void buscarImpl() {
        documento = "";
        idPersonal = "";
        lblPersonal.setText("");
        listPersonal = frmPrincipal.oNegocioDao.getBuscarPersonal(txtPersonal.getText().trim().toUpperCase());
        LogsUtil.Show(oClass, "Datos obtenidos " + listPersonal.size());
        oPersonal = new Personal();
        for (int i = 0; 0 < modTablaCliente.getRowCount(); i++) {
            modTablaCliente.removeRow(0);
        }
        for (Personal item : listPersonal) {
            String[] nuevo = new String[6];
            nuevo[0] = item.getIdpersonal().toString();
            nuevo[1] = item.getNrodocumento();
            nuevo[2] = item.getNombre();
            nuevo[3] = item.getApepat();
            nuevo[4] = item.getApemat();
//            nuevo[5] = item.getCodPersonal();
            modTablaCliente.addRow(nuevo);
        }
        personalizarJtable();
        ProgressUtil.stop();
    }

    private void personalizarJtable() {
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.getColumnModel().getColumn(0).setResizable(true);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(1).setResizable(true);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(110);
        tabla.getColumnModel().getColumn(2).setResizable(true);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(3).setResizable(true);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(210);
        tabla.getColumnModel().getColumn(4).setResizable(true);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(210);
    }
    String idPersonal = "";
    String documento = "";
    String Personal = "";

    private void seleccionar() {
        try {
            lblPersonal.setText(tabla.getValueAt(tabla.getSelectedRow(), 2).toString().trim() + " " + tabla.getValueAt(tabla.getSelectedRow(), 3).toString().trim() + " " + tabla.getValueAt(tabla.getSelectedRow(), 4).toString().trim());
            idPersonal = (String) tabla.getValueAt(tabla.getSelectedRow(), 0);
            documento = (String) tabla.getValueAt(tabla.getSelectedRow(), 1);
            Personal = lblPersonal.getText();
        } catch (Exception e) {
            lblPersonal.setText("");
            idPersonal = "";
            documento = "";
            Personal = lblPersonal.getText();
            LogsUtil.Show(oClass, "ERROR EN CAPTURA DE DATOS " + e);
        }
    }

    private void limpiarTabla() {
        modTablaCliente = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < modTablaCliente.getRowCount(); i++) {
            modTablaCliente.removeRow(0);
        }
    }

    private void CargarPersonal() {
        try {
            if (estacerrado(gPersonalManual)) {
                gPersonalManual = new frmRegistroPersonalManual();
                abrirMarcoInterno(gPersonalManual);
            } else {
                JOptionPane.showMessageDialog(this, ConstantesApp.MENSAJE_FORMULARIO_ABIERTO);
            }
        } catch (Exception e) {
            LogsUtil.Msg(oClass, "INTENTE NUEVAMENTE POR FAVOR \nDESCRIPCION ERROR " + e.getMessage(), "ATENCION", JOptionPane.INFORMATION_MESSAGE);
        }
        ProgressUtil.stop();
    }
}
