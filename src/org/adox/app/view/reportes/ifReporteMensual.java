package org.adox.app.view.reportes;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.adox.app.common.ConstantesApp;
import org.adox.app.config.AppConfigLocal;
import org.adox.app.facade.business.dto.dtoTabla;
import org.adox.app.util.DateUtil;
import org.adox.app.util.LogsUtil;
import org.adox.app.util.ProgressUtil;
import org.adox.app.view.frmPrincipal;
import org.apache.log4j.Logger;

/**
 * @author Adolfo
 ifCrudProveedor.java
 Created on 03-nov-2010, 17:25:06
 */
public class ifReporteMensual extends javax.swing.JInternalFrame {

    static Logger oClass = Logger.getLogger("ifReporteMensual");
    DefaultTableModel tablita;

    public ifReporteMensual() {
        initComponents();
        _init();
        ProgressUtil.stop();
    }

    private void _init() {
        try {
            cbFecha.setDate(DateUtil.FechaActualDate());
            cbFecha.setFormats(DateUtil.IrFormatoDDMMYYY());
        } catch (ParseException ex) {
            LogsUtil.LogsApp(oClass, "Ocurrio porblemas al inicializar componente fecha " + ex.getMessage(), ConstantesApp.ERROR_ERROR);
        }
    }
    String fechaIni = "";
    String fechaFin = "";

    private void ReporteAsistenciaMensual() {
        ProgressUtil oProgressUtil = new ProgressUtil();
        oProgressUtil.load();
        Thread p = new Thread() {

            public void run() {
                abrirAsistenciaMensual();
            }
        };
        p.start();
    }

    private void abrirAsistenciaMensual() {
        btnAsistenciaMensual.setEnabled(false);
        if (DateUtil.formatoFechaYYYYMMDD(cbFecha.getDate()).trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "SELECCIONE UNA FECHA");
            btnAsistenciaMensual.setEnabled(true);
            return;
        }
        viewAsistenciaMensual();
        btnAsistenciaMensual.setEnabled(true);
    }

    private void viewAsistenciaMensual() {
        String[] fechAct = DateUtil.formatoFechaYYYYMMDD(cbFecha.getDate()).trim().split("-");
        int mes_actual = Integer.parseInt(fechAct[1]);
        String mes_selec = DateUtil.nombremes(mes_actual);
        String fechita = DateUtil.nombremes(mes_actual) + " DEL " + fechAct[0];
        String[] dias = DateUtil.reporte_DiasMes(Integer.parseInt(fechAct[0]), mes_actual - 1);
        LogsUtil.Show(oClass, "fechita : " + fechita);
        LogsUtil.Show(oClass, "mes : " + mes_selec);
        LogsUtil.Show(oClass, "d1 : " + dias[1]);
        dtoTabla par;
        List<dtoTabla> parametros = new ArrayList<dtoTabla>();
        par = new dtoTabla();
        par.setId("d1");
        par.setDescripcion(dias[1]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d2");
        par.setDescripcion(dias[2]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d3");
        par.setDescripcion(dias[3]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d4");
        par.setDescripcion(dias[4]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d5");
        par.setDescripcion(dias[5]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d6");
        par.setDescripcion(dias[6]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d7");
        par.setDescripcion(dias[7]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d8");
        par.setDescripcion(dias[8]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d9");
        par.setDescripcion(dias[9]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d10");
        par.setDescripcion(dias[10]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d11");
        par.setDescripcion(dias[11]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d12");
        par.setDescripcion(dias[12]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d13");
        par.setDescripcion(dias[13]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d14");
        par.setDescripcion(dias[14]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d15");
        par.setDescripcion(dias[15]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d16");
        par.setDescripcion(dias[16]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d17");
        par.setDescripcion(dias[17]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d18");
        par.setDescripcion(dias[18]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d19");
        par.setDescripcion(dias[19]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d20");
        par.setDescripcion(dias[20]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d21");
        par.setDescripcion(dias[21]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d22");
        par.setDescripcion(dias[22]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d23");
        par.setDescripcion(dias[23]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d24");
        par.setDescripcion(dias[24]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d25");
        par.setDescripcion(dias[25]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d26");
        par.setDescripcion(dias[26]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d27");
        par.setDescripcion(dias[27]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d28");
        par.setDescripcion(dias[28]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d29");
        par.setDescripcion(dias[29]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d30");
        par.setDescripcion(dias[30]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("d31");
        par.setDescripcion(dias[31]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("fechita");
        par.setDescripcion(fechita);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("anio");
        par.setDescripcion(fechAct[0]);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("mes");
        par.setDescripcion(mes_selec);
        parametros.add(par);
        par = new dtoTabla();
        par.setId("finicio");
        par.setDescripcion(fechAct[0]+"-"+fechAct[1]+"-01");
        parametros.add(par);
        par = new dtoTabla();
        par.setId("ffin");
        par.setDescripcion(fechAct[0]+"-"+fechAct[1]+"-31");
        parametros.add(par);
        frmPrincipal.oReporte.viewReporte("::: REPORTE DE ASISTENCIAS MENSUAL :::", AppConfigLocal.RUTA_RPTLASISTENCIAMENSUAL, parametros);
    }

    private void ReporteAsistenciaDiarias() {
        ProgressUtil oProgressUtil = new ProgressUtil();
        oProgressUtil.load();
        Thread p = new Thread() {

            public void run() {
                abrirAsistenciaDiarias();
            }
        };
        p.start();
    }

    private void abrirAsistenciaDiarias() {
        btnAsistenciaDiaria.setEnabled(false);
        if (DateUtil.formatoFechaYYYYMMDD(cbFecha.getDate()).trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "SELECCIONE UNA FECHA");
            btnAsistenciaDiaria.setEnabled(true);
            return;
        }
        viewAsistenciaDiarias();
        btnAsistenciaDiaria.setEnabled(true);
    }

    private void viewAsistenciaDiarias() {
        List<dtoTabla> parametros = new ArrayList<dtoTabla>();
        dtoTabla par = new dtoTabla();
        par.setId("fecha");
        par.setDescripcion(DateUtil.formatoFechaYYYYMMDD(cbFecha.getDate()).trim());
        parametros.add(par);
        frmPrincipal.oReporte.viewReporte("::: REPORTE DE ASISTENCIAS DIARIAS ::: ", AppConfigLocal.RUTA_RPTLASISTENCIA, parametros);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAsistenciaDiaria = new javax.swing.JButton();
        btnAsistenciaMensual = new javax.swing.JButton();
        cbFecha = new org.jdesktop.swingx.JXDatePicker();
        btnSalir = new javax.swing.JButton();

        setClosable(true);
        setTitle("::: REPORTE MENSUAL :::"); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/adox.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), " Fecha de Reporte ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 10), new java.awt.Color(0, 51, 102))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Seleccione Fecha :");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnAsistenciaDiaria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAsistenciaDiaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/reporte5.png"))); // NOI18N
        btnAsistenciaDiaria.setText("Asist. de Hoy");
        btnAsistenciaDiaria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAsistenciaDiaria.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAsistenciaDiaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciaDiariaActionPerformed(evt);
            }
        });

        btnAsistenciaMensual.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAsistenciaMensual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/reporte3.png"))); // NOI18N
        btnAsistenciaMensual.setText("Asistencia Mensual");
        btnAsistenciaMensual.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAsistenciaMensual.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAsistenciaMensual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciaMensualActionPerformed(evt);
            }
        });

        cbFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbFechaMouseClicked(evt);
            }
        });
        cbFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAsistenciaDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAsistenciaMensual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAsistenciaDiaria, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btnAsistenciaMensual, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/btn_apagar.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsistenciaMensualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsistenciaMensualActionPerformed
        ReporteAsistenciaMensual();
    }//GEN-LAST:event_btnAsistenciaMensualActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAsistenciaDiariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsistenciaDiariaActionPerformed
        ReporteAsistenciaDiarias();
    }//GEN-LAST:event_btnAsistenciaDiariaActionPerformed

    private void cbFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbFechaMouseClicked
        //      txtFecha.setText("" + DateUtil.formatDate(cbFecha.getDate()));
}//GEN-LAST:event_cbFechaMouseClicked

    private void cbFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFechaActionPerformed
//        txtFecha.setText("" + DateUtil.formatDate(cbFecha.getDate()));
}//GEN-LAST:event_cbFechaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsistenciaDiaria;
    private javax.swing.JButton btnAsistenciaMensual;
    private javax.swing.JButton btnSalir;
    private org.jdesktop.swingx.JXDatePicker cbFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
