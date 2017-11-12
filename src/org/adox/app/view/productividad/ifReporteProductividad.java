package org.adox.app.view.productividad;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.adox.app.config.AppConfigLocal;
import org.adox.app.entities.Personal;
import org.adox.app.facade.business.dto.dtoTabla;
import org.adox.app.util.DateUtil;
import org.adox.app.util.LogsUtil;
import org.adox.app.util.ProgressUtil;
import org.adox.app.view.frmPrincipal;
import org.apache.log4j.Logger;

/**
 * @author Adolfo
 * ifPersonal.java
 * Created on 07-abr-2011, 13:36:33
 */
public class ifReporteProductividad extends javax.swing.JInternalFrame {

    static Logger oClass = Logger.getLogger("ifReporteProductividad");
    Personal oPersonal;

    public ifReporteProductividad() {
        initComponents();
        _init();
        ProgressUtil.stop();
    }

    private void _init() {
        modTablaCliente = (DefaultTableModel) tabla.getModel();
        lblPersonal.setText("");
        try {
            fecDesde.setDate(DateUtil.FechaActualDate());
            fecDesde.setFormats(DateUtil.IrFormatoYYYYMMDD());
            fecHasta.setDate(DateUtil.FechaActualDate());
            fecHasta.setFormats(DateUtil.IrFormatoYYYYMMDD());
        } catch (Exception ex) {
            LogsUtil.Show(oClass, ex.getMessage());
        }
        chAprobados.setSelected(true);
        chRechazado.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPersonal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnReporteProductividad = new javax.swing.JButton();
        btnReporteProductividadDetallado = new javax.swing.JButton();
        fecDesde = new org.jdesktop.swingx.JXDatePicker();
        fecHasta = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        chAprobados = new javax.swing.JCheckBox();
        chRechazado = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        lblPersonal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle(" ::: REPORTE DE PRODUCTIVIDAD  ::: "); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/adox.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), 2));
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Personal");
        jLabel1.setName("jLabel1"); // NOI18N

        txtPersonal.setName("txtPersonal"); // NOI18N
        txtPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPersonalActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_buscar.PNG"))); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 0), 2, true));
        jPanel2.setName("jPanel2"); // NOI18N

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setName("btnSalir"); // NOI18N
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_editar.PNG"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLimpiar.setName("btnLimpiar"); // NOI18N
        btnLimpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnReporteProductividad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/u_personal.png"))); // NOI18N
        btnReporteProductividad.setText("Productividad");
        btnReporteProductividad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReporteProductividad.setName("btnReporteProductividad"); // NOI18N
        btnReporteProductividad.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReporteProductividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteProductividadActionPerformed(evt);
            }
        });

        btnReporteProductividadDetallado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_reporte.png"))); // NOI18N
        btnReporteProductividadDetallado.setText("Resumen");
        btnReporteProductividadDetallado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReporteProductividadDetallado.setName("btnReporteProductividadDetallado"); // NOI18N
        btnReporteProductividadDetallado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReporteProductividadDetallado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteProductividadDetalladoActionPerformed(evt);
            }
        });

        fecDesde.setFont(new java.awt.Font("Tahoma", 1, 11));
        fecDesde.setName("fecDesde"); // NOI18N
        fecDesde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fecDesdeMouseClicked(evt);
            }
        });
        fecDesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecDesdeActionPerformed(evt);
            }
        });

        fecHasta.setFont(new java.awt.Font("Tahoma", 1, 11));
        fecHasta.setName("fecHasta"); // NOI18N
        fecHasta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fecHastaMouseClicked(evt);
            }
        });
        fecHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecHastaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Hasta :");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Desde :");
        jLabel3.setName("jLabel3"); // NOI18N

        chAprobados.setBackground(new java.awt.Color(51, 51, 51));
        chAprobados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        chAprobados.setForeground(new java.awt.Color(255, 255, 255));
        chAprobados.setText("Aprobados");
        chAprobados.setName("chAprobados"); // NOI18N

        chRechazado.setBackground(new java.awt.Color(51, 51, 51));
        chRechazado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        chRechazado.setForeground(new java.awt.Color(255, 255, 255));
        chRechazado.setText("Rechazados");
        chRechazado.setName("chRechazado"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fecDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chAprobados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fecHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chRechazado)))
                .addGap(18, 18, 18)
                .addComponent(btnReporteProductividad, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporteProductividadDetallado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporteProductividadDetallado, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporteProductividad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fecDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(chAprobados))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(fecHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chRechazado))))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 2, true));
        jPanel3.setName("jPanel3"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Documento", "Nombre", "Apeliido Paterno", "Apeliido Materno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false
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

        lblPersonal.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblPersonal.setForeground(new java.awt.Color(0, 0, 102));
        lblPersonal.setText("Nombres y Apellidos");
        lblPersonal.setName("lblPersonal"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText("Personal");
        jLabel4.setName("jLabel4"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(34, 34, 34)
                        .addComponent(lblPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblPersonal))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
}//GEN-LAST:event_btnSalirActionPerformed

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

    private void btnReporteProductividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteProductividadActionPerformed
        GestionReporteProductividad();
    }//GEN-LAST:event_btnReporteProductividadActionPerformed

    private void btnReporteProductividadDetalladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteProductividadDetalladoActionPerformed
        // TODO add your handling code here:
        GestionReporteProductividadResumen();
}//GEN-LAST:event_btnReporteProductividadDetalladoActionPerformed

private void fecDesdeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecDesdeMouseClicked
//        txtFechaNacimiento.setText("" + DateUtil.formatDate(cbFecha.getDate()));
}//GEN-LAST:event_fecDesdeMouseClicked

private void fecDesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecDesdeActionPerformed
    //    txtFechaNacimiento.setText("" + DateUtil.formatDate(cbFecha.getDate()));
}//GEN-LAST:event_fecDesdeActionPerformed

private void fecHastaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecHastaMouseClicked
// TODO add your handling code here:
}//GEN-LAST:event_fecHastaMouseClicked

private void fecHastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecHastaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_fecHastaActionPerformed

    private void GestionReporteProductividadResumen() {
        ProgressUtil oProgressUtil = new ProgressUtil();
        oProgressUtil.load();
        Thread p = new Thread() {

            public void run() {
                abrirReporteProductividadResumen();
            }
        };
        p.start();
    }
    JInternalFrame gPermisos;

    private void abrirReporteProductividadResumen() {
        if (idPersonal.equals("")) {
            JOptionPane.showMessageDialog(this, "Seleccione un personal", "Atención", JOptionPane.INFORMATION_MESSAGE);
            ProgressUtil.stop();
            return;
        }
        String estado = "";
        if (chAprobados.isSelected()) {
            estado = "2";
        }
        if (chRechazado.isSelected()) {
            estado = "0";
        }

        if (chAprobados.isSelected() && chRechazado.isSelected()) {
            estado = "";
        }
        viewReporteProductividadResumen(estado);
    }

    private void viewReporteProductividadResumen(String estado) {
        List<dtoTabla> parametros = new ArrayList<dtoTabla>();
        dtoTabla par = new dtoTabla();
        par.setId("fecdesde");
        par.setDescripcion(DateUtil.formatoFechaYYYYMMDD(fecDesde.getDate()).trim());
        parametros.add(par);
        par = new dtoTabla();
        par.setId("fechasta");
        par.setDescripcion(DateUtil.formatoFechaYYYYMMDD(fecHasta.getDate()).trim());
        parametros.add(par);
        par = new dtoTabla();
        par.setId("estado");
        par.setDescripcion(estado);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("persona");
        par.setDescripcion(lblPersonal.getText().trim());
        parametros.add(par);
        frmPrincipal.oReporte.viewReporte("::: REPORTE DE RESUMEN PRODUCTIVIDAD ::: " + lblPersonal.getText().trim(), AppConfigLocal.RUTA_RPTPRODUCTIVIDADRESUMEN, parametros);
    }

    private void GestionReporteProductividad() {
        ProgressUtil oProgressUtil = new ProgressUtil();
        oProgressUtil.load();
        Thread p = new Thread() {

            public void run() {
                abrirReporteProductividad();
            }
        };
        p.start();
    }

    private void abrirReporteProductividad() {
        if (idPersonal.equals("")) {
            JOptionPane.showMessageDialog(this, "Seleccione un personal", "Atención", JOptionPane.INFORMATION_MESSAGE);
            ProgressUtil.stop();
            return;
        }
        String estado = "";
        if (chAprobados.isSelected()) {
            estado = "2";
        }
        if (chRechazado.isSelected()) {
            estado = "0";
        }

        if (chAprobados.isSelected() && chRechazado.isSelected()) {
            estado = "";
        }
        viewReporteProductividad(estado);
    }

    private void viewReporteProductividad(String estado) {
        List<dtoTabla> parametros = new ArrayList<dtoTabla>();
        dtoTabla par = new dtoTabla();
        par.setId("fecdesde");
        par.setDescripcion(DateUtil.formatoFechaYYYYMMDD(fecDesde.getDate()).trim());
        parametros.add(par);
        par = new dtoTabla();
        par.setId("fechasta");
        par.setDescripcion(DateUtil.formatoFechaYYYYMMDD(fecHasta.getDate()).trim());
        parametros.add(par);
        par = new dtoTabla();
        par.setId("estado");
        par.setDescripcion(estado);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("persona");
        par.setDescripcion(lblPersonal.getText().trim());
        parametros.add(par);
        frmPrincipal.oReporte.viewReporte("::: REPORTE DE PRODUCTIVIDAD ::: " + lblPersonal.getText().trim(), AppConfigLocal.RUTA_RPTPRODUCTIVIDAD, parametros);
    }
    /**/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnReporteProductividad;
    private javax.swing.JButton btnReporteProductividadDetallado;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox chAprobados;
    private javax.swing.JCheckBox chRechazado;
    private org.jdesktop.swingx.JXDatePicker fecDesde;
    private org.jdesktop.swingx.JXDatePicker fecHasta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPersonal;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtPersonal;
    // End of variables declaration//GEN-END:variables
    List<Personal> listPersonal;
    DefaultTableModel modTablaCliente;

    private void buscar() {
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
    }

    private void personalizarJtable() {
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.getColumnModel().getColumn(0).setResizable(true);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabla.getColumnModel().getColumn(1).setResizable(true);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(2).setResizable(true);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(170);
        tabla.getColumnModel().getColumn(3).setResizable(true);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(170);
        tabla.getColumnModel().getColumn(4).setResizable(true);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(170);
    }
    String idPersonal = "";
    String documento = "";
    String Personal = "";

    private void seleccionar() {
        lblPersonal.setText(tabla.getValueAt(tabla.getSelectedRow(), 2).toString().trim() + " " + tabla.getValueAt(tabla.getSelectedRow(), 3).toString().trim() + " " + tabla.getValueAt(tabla.getSelectedRow(), 4).toString().trim());
        idPersonal = (String) tabla.getValueAt(tabla.getSelectedRow(), 0);
        documento = (String) tabla.getValueAt(tabla.getSelectedRow(), 1);
        Personal = lblPersonal.getText();
    }

    private void limpiarTabla() {
        modTablaCliente = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < modTablaCliente.getRowCount(); i++) {
            modTablaCliente.removeRow(0);
        }
    }
}
