package org.adox.app.view.productividad;

import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.adox.app.common.ConstantesApp;
import org.adox.app.entities.Actividadpersonal;
import org.adox.app.util.LogsUtil;
import org.adox.app.util.ProgressUtil;
import org.adox.app.view.frmPrincipal;
import org.apache.log4j.Logger;

/**
 * @author ADOLFO
 ifRegistroProductividad.java
 Created on 31/08/2011, 10:01:09 AM
 */
public class ifGestionProductividad extends javax.swing.JInternalFrame {

    static Logger oClass = Logger.getLogger("ifGestionProductividad");
    List<Actividadpersonal> listActividad;
    DefaultTableModel tablitaActividades;
    Vector fila = new Vector();

    public ifGestionProductividad() {
        initComponents();
        _init();
        ProgressUtil.stop();
    }

    private void _init() {
        tablitaActividades = (DefaultTableModel) masterTable.getModel();
        lblPersonal.setText("");
        getCargarPersonal();
//        btnGuardar.setEnabled(false);
    }

    private void getCargarPersonal() {
        fila = frmPrincipal.oNegocioDao.getObtenerPersonalCargo(ConstantesApp.USUARIO);
        this.lista.setListData(fila);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtComentarios = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblPersonal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("::: GESTIÓN DE PRODUCTIVIDAD DEL PERSONAL A CARGO :::"); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/adox.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setName("jPanel1"); // NOI18N

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personal a Cargo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 0))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        lista.setFont(new java.awt.Font("Tahoma", 1, 9));
        lista.setName("lista"); // NOI18N
        lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listaMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(lista);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actividades Registradas por el Personal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 153))); // NOI18N
        jPanel4.setName("jPanel4"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        masterTable.setFont(new java.awt.Font("Tahoma", 0, 10));
        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod.", "Actividad", "Cant.", "Fecha", "Aprob.", "Comentario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        masterTable.setName("masterTable"); // NOI18N
        masterTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masterTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(masterTable);

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        txtComentarios.setColumns(20);
        txtComentarios.setRows(5);
        txtComentarios.setName("txtComentarios"); // NOI18N
        jScrollPane3.setViewportView(txtComentarios);

        jLabel1.setText("Comentarios :");
        jLabel1.setName("jLabel1"); // NOI18N

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_guardar.PNG"))); // NOI18N
        saveButton.setText("Aprobar");
        saveButton.setName("saveButton"); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/btn_remover.png"))); // NOI18N
        deleteButton.setText("Rechazar");
        deleteButton.setName("deleteButton"); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setName("btnSalir"); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblPersonal.setFont(new java.awt.Font("Tahoma", 1, 14));
        lblPersonal.setForeground(new java.awt.Color(0, 0, 102));
        lblPersonal.setText("Personal");
        lblPersonal.setName("lblPersonal"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText("Personal Seleccionado : ");
        jLabel4.setName("jLabel4"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked
    txtComentarios.setText(masterTable.getValueAt(masterTable.getSelectedRow(), 5).toString());
}//GEN-LAST:event_masterTableMouseClicked

private void listaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMousePressed
    SeleccionarPersonal();
}//GEN-LAST:event_listaMousePressed

private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
    Aprobar();
}//GEN-LAST:event_saveButtonActionPerformed

private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
    Rechazar();
}//GEN-LAST:event_deleteButtonActionPerformed

private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    Salir();
}//GEN-LAST:event_btnSalirActionPerformed
//
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblPersonal;
    private javax.swing.JList lista;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextArea txtComentarios;
    // End of variables declaration//GEN-END:variables
    String PersonalSeleccionado;
    String idPersonalSeleccionado;

    private void SeleccionarPersonal() {
        String PersSelecc = (String) lista.getSelectedValue();
        String[] val = new String[2];
        val = PersSelecc.split("-");
        idPersonalSeleccionado = val[0];
        PersonalSeleccionado = val[1];
        lblPersonal.setText(PersonalSeleccionado);
        listActividad = frmPrincipal.oNegocioDao.getObtenerActividadesPersonal(PersonalSeleccionado);
        LogsUtil.Show(oClass,"Datos obtenidos " + listActividad.size());
        for (int i = 0; 0 < tablitaActividades.getRowCount(); i++) {
            tablitaActividades.removeRow(0);
        }
        for (Actividadpersonal item : listActividad) {
            Object[] nuevo = new Object[6];
            nuevo[0] = item.getIdActividadPersonal().toString();
            nuevo[1] = item.getActividad();
            nuevo[2] = item.getCantidad().toString();
            nuevo[3] = item.getFecha().toString();
            nuevo[4] = Boolean.FALSE;
            nuevo[5] = item.getComentario().toString();
            tablitaActividades.addRow(nuevo);
        }
        txtComentarios.setText("");
        personalizarJtable();
    }

    private void personalizarJtable() {
        masterTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        masterTable.getColumnModel().getColumn(0).setResizable(true);
        masterTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        masterTable.getColumnModel().getColumn(1).setResizable(true);
        masterTable.getColumnModel().getColumn(1).setPreferredWidth(330);
        masterTable.getColumnModel().getColumn(2).setResizable(true);
        masterTable.getColumnModel().getColumn(2).setPreferredWidth(40);
        masterTable.getColumnModel().getColumn(3).setResizable(true);
        masterTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        masterTable.getColumnModel().getColumn(4).setResizable(true);
        masterTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        masterTable.getColumnModel().getColumn(5).setResizable(true);
        masterTable.getColumnModel().getColumn(5).setPreferredWidth(0);
    }

    private void Aprobar() {
        for (int i = 0; i < masterTable.getRowCount(); i++) {
            String estado = masterTable.getValueAt(i, 4).toString();
            LogsUtil.Show(oClass,estado);
            if (estado.equals("true")) {
                Actividadpersonal ap = new Actividadpersonal();
                ap.setIdActividadPersonal(Integer.parseInt(masterTable.getValueAt(i, 0).toString()));
                ap.setEstado(ConstantesApp.ESTADO_PRODUCTIVIDAD_APROBADO);
                ap.setPersonalCalificacion(ConstantesApp.USUARIO);
                String registro = frmPrincipal.oNegocioDao.getActualizarActividadesPersonal(ap);
                if (!(registro.trim().equals(""))) {
                    LogsUtil.Msg(oClass, "CALIFICACION EXITOSA DE PRODUCTIVIDAD", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    LogsUtil.Msg(oClass, "FALLO CALIFICACION DE PRODUCTIVIDAD", "ATENCION", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        SeleccionarPersonal();
    }

    private void Rechazar() {
        for (int i = 0; i < masterTable.getRowCount(); i++) {
            String estado = masterTable.getValueAt(i, 4).toString();
            LogsUtil.Show(oClass,estado);
            if (estado.equals("true")) {
                Actividadpersonal ap = new Actividadpersonal();
                ap.setIdActividadPersonal(Integer.parseInt(masterTable.getValueAt(i, 0).toString()));
                ap.setEstado(ConstantesApp.ESTADO_PRODUCTIVIDAD_RECHAZADO);
                ap.setPersonalCalificacion(ConstantesApp.USUARIO);
                String registro = frmPrincipal.oNegocioDao.getActualizarActividadesPersonal(ap);
                if (!(registro.trim().equals(""))) {
                    LogsUtil.Msg(oClass, "RECHAZO EXITOSO DE PRODUCTIVIDAD", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    LogsUtil.Msg(oClass, "FALLO RECHAZO DE PRODUCTIVIDAD", "ATENCION", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        SeleccionarPersonal();
    }

    private void Salir() {
        dispose();
    }
}
