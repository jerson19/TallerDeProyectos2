package org.adox.app.view.aplicacion;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import org.adox.app.config.AppConfigLocal;
import org.adox.app.facade.business.dto.dtoTabla;
import org.adox.app.util.DateUtil;
import org.adox.app.util.LogsUtil;
import org.adox.app.util.ProgressUtil;
import org.adox.app.util.RelojUtil;
import org.adox.app.util.biometrico.BiominiUtil;
import org.adox.app.view.frmPrincipal;
import org.apache.log4j.Logger;

/**
 * @author ADOLFO ifAsistencias.java Created on 20/05/2011, 01:33:08 PM
 */
public class ifAsistencias extends javax.swing.JInternalFrame {

    static Logger oClass = Logger.getLogger("ifAsistencias");
    private BiominiUtil oBiominiUtil;
    public static Integer lectorPrendido;
    //Panel para mostrar la huella digital

    /**
     * Creates new form ifAsistencias
     */
    public ifAsistencias() {
        initComponents();
        _init();
        ProgressUtil.stop();
    }

    private void _init() {
        //mSalir.setEnabled(false);
        RelojUtil hilo = new RelojUtil(lblHora);
        hilo.start();
        try {
            inicializar();
            EncenderLectorBiometrico();
            ApagarLectorBiometricoAutomatico();
            //lblControlAsistencia.setText("<html><MARQUEE> <center> <font color = 'white'>" + DateUtil.fechaAplicacion2() + "</font></center></MARQUEE> </html>");
            try {
                lblControlAsistencia.setText("" + DateUtil.fechaAplicacion2() + "");
                lblControlAsistencia.establecerTamaño(300, 40);
                lblControlAsistencia.comenzar();
            } catch (Exception e) {
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void inicializar() {
        //Crea una instancia de Util
        this.oBiominiUtil = new BiominiUtil(this);
    }

    //Incializa la captura despues de cargar todo
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        reloj = new org.edisoncor.gui.varios.ClockFace();
        panelNice1 = new org.edisoncor.gui.panel.PanelNice();
        lblHora = new javax.swing.JLabel();
        lblControlAsistencia = new org.adox.app.util.Marquesina();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mSalir = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        setIconifiable(true);
        setTitle("::: CONTROL DE ASISTENCIAS :::"); // NOI18N
        setAutoscrolls(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/adox.png"))); // NOI18N
        setOpaque(true);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        jPanel1.setName("jPanel1"); // NOI18N

        reloj.setBackground(new java.awt.Color(255, 255, 255));
        reloj.setName("reloj"); // NOI18N

        javax.swing.GroupLayout relojLayout = new javax.swing.GroupLayout(reloj);
        reloj.setLayout(relojLayout);
        relojLayout.setHorizontalGroup(
            relojLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
        );
        relojLayout.setVerticalGroup(
            relojLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 183, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(reloj, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(reloj, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panelNice1.setName("panelNice1"); // NOI18N
        panelNice1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHora.setBackground(new java.awt.Color(204, 255, 255));
        lblHora.setFont(new java.awt.Font("Times New Roman", 1, 120)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHora.setText("-");
        lblHora.setName("lblHora"); // NOI18N
        panelNice1.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 480, 140));

        lblControlAsistencia.setBackground(new java.awt.Color(0, 0, 0));
        lblControlAsistencia.setForeground(new java.awt.Color(255, 255, 255));
        lblControlAsistencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblControlAsistencia.setText("marquesina1");
        lblControlAsistencia.setName("lblControlAsistencia"); // NOI18N
        panelNice1.add(lblControlAsistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 470, 40));

        jMenuBar1.setName("jMenuBar1"); // NOI18N

        jMenu1.setText("Lector Biométrico        ");
        jMenu1.setName("jMenu1"); // NOI18N

        mSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mSalir.setText("Apagar y Salir");
        mSalir.setName("mSalir"); // NOI18N
        mSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSalirActionPerformed(evt);
            }
        });
        jMenu1.add(mSalir);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("  Reporte Diario  ");
        jMenu3.setName("jMenu3"); // NOI18N

        jMenuItem6.setText("Reporte Diario");
        jMenuItem6.setName("jMenuItem6"); // NOI18N
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelNice1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelNice1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSalirActionPerformed
        Apagar();
    }//GEN-LAST:event_mSalirActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Reporte();
    }//GEN-LAST:event_jMenuItem6ActionPerformed
//
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    public static org.adox.app.util.Marquesina lblControlAsistencia;
    public static javax.swing.JLabel lblHora;
    private javax.swing.JMenuItem mSalir;
    private org.edisoncor.gui.panel.PanelNice panelNice1;
    private org.edisoncor.gui.varios.ClockFace reloj;
    // End of variables declaration//GEN-END:variables
    /**
     * Adds the specified text to the log output
     */
    Thread p;

    private void EncenderLectorBiometrico() {
        ProgressUtil oProgressUtil = new ProgressUtil();
        oProgressUtil.load();
        p = new Thread() {

            @Override
            public void run() {
                EncenderLector();
            }
        };
        p.start();
    }

    Thread pApagar;

    private void ApagarLectorBiometricoAutomatico() {
        ProgressUtil oProgressUtil = new ProgressUtil();
        oProgressUtil.load();
        pApagar = new Thread() {

            @Override
            public void run() {
                while (true) {
                    try {
                        sleep(360000);
                        if (lectorPrendido.intValue() >= 1 && lectorPrendido.intValue() <= 4) {
                            if (BiominiUtil.Apagar_Identificar_Huella == 0) {
                                System.err.println("HORA QUE PARO " + DateUtil.fechaHoraAplicacion());
                                BiominiUtil.Apagar_Identificar_Huella = 1;
                                oBiominiUtil.Uninit_Suprema();
                                sleep(3000000);
                                System.err.println("HORA QUE PRENDERA " + DateUtil.fechaHoraAplicacion());
                            }
                        } else {
                            if (BiominiUtil.Apagar_Identificar_Huella == 1) {
                                System.out.println("APUNTO DE ENCENDER EL LECTOR");
                                BiominiUtil.Apagar_Identificar_Huella = 0;
                                inicializar();
                                EncenderLectorBiometrico();
                            }
                        }
                    } catch (InterruptedException ex) {
                        System.out.println("ERROR ApagarLectorBiometricoAutomatico : " + ex.getMessage());
                    }
                }
            }
        };
        pApagar.start();
    }

    private void EncenderLector() {
        try {
            //SINCRONIZAR LA HORA CON EL SERVIDOR
            frmPrincipal.oAplicacionDao.getObtenerConexion();
            ProgressUtil.stop();
            oBiominiUtil.IdentificarAsistencia();
        } catch (Exception e) {
            LogsUtil.Show(oClass, "Exepxion al EncenderLector() " + e.getMessage());
            Apagar();
            BiominiUtil.Apagar_Identificar_Huella = 0;
        }
    }

    private void Reporte() {
        ProgressUtil oProgressUtil = new ProgressUtil();
        oProgressUtil.load();
        Thread p = new Thread() {

            public void run() {
                abrirReporte();
            }
        };
        p.start();
    }

    private void abrirReporte() {
        try {
            List<dtoTabla> parametros = new ArrayList<dtoTabla>();
            dtoTabla par = new dtoTabla();
            par.setId("fecha");
            par.setDescripcion(DateUtil.FechaActualString());
            parametros.add(par);
            frmPrincipal.oReporte.viewReporte("::: REPORTE DE ASISTENCIAS DIARIAS ::: ", AppConfigLocal.RUTA_RPTLASISTENCIA, parametros);
        } catch (Exception e) {
            LogsUtil.Show(oClass, "fallo abrir abrirReporte " + e.getMessage());
        }
    }

    private void Apagar() {
        try {
            BiominiUtil.Apagar_Identificar_Huella = 1;
            oBiominiUtil.Uninit_Suprema();
            p.stop();
            pApagar.stop();
            dispose();
        } catch (Exception e) {
            LogsUtil.Show(oClass, "Exepxion al Apagar() " + e.getMessage());
        }
    }
}
