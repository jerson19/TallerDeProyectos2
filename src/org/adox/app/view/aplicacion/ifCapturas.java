package org.adox.app.view.aplicacion;


import javax.swing.JOptionPane;
import org.adox.app.entities.Personal;
import org.adox.app.util.ProgressUtil;
import org.adox.app.util.ValidadoresUtil;
import org.adox.app.util.biometrico.BiominiUtil;
import org.adox.app.view.frmPrincipal;

/**
 * @author Adolfo
 * ifCapturas.java
 * Created on 07-abr-2011, 13:33:00
 */
public class ifCapturas extends javax.swing.JInternalFrame {

    private BiominiUtil oBiominiUtil;
    String idPersonal;
    String nombrePersonal;
    String nrodocumento;

    public ifCapturas() {
        initComponents();
        _init();
        ProgressUtil.stop();
    }

    private void _init() {
        btnGuardar.setEnabled(false);
        btnIdentificar.setEnabled(true);
        txtPersonal.setEnabled(false);
        try {
            inicializar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void inicializar() {
        //Crea una instancia de Util
        this.oBiominiUtil = new BiominiUtil(this);
    }

    // Crea el panel que contendrá la imagen de la huella digital
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelContenedor = new javax.swing.JPanel();
        imgPanel = new org.adox.app.util.biometrico.ImagePanel();
        jPanel1 = new javax.swing.JPanel();
        txtPersonal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnIdentificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        btnEncender = new javax.swing.JButton();

        setIconifiable(true);
        setTitle("::: RECONOCIMIENTO DE PERSONAL :::");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/adox.png"))); // NOI18N

        PanelContenedor.setBackground(new java.awt.Color(51, 51, 51));
        PanelContenedor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Huella Digital", 2, 0, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 204, 0))); // NOI18N
        PanelContenedor.setName("PanelContenedor"); // NOI18N
        PanelContenedor.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                PanelContenedorComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                PanelContenedorComponentShown(evt);
            }
        });
        PanelContenedor.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PanelContenedorMouseMoved(evt);
            }
        });
        PanelContenedor.setLayout(new java.awt.BorderLayout());

        imgPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        imgPanel.setName("imgPanel"); // NOI18N
        imgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelContenedor.add(imgPanel, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "::: Información del Personal :::", 2, 0, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 204, 0))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        txtPersonal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPersonal.setForeground(new java.awt.Color(0, 51, 51));
        txtPersonal.setName("txtPersonal"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DNI :");
        jLabel3.setName("jLabel3"); // NOI18N

        txtDni.setName("txtDni"); // NOI18N
        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_buscar.PNG"))); // NOI18N
        jButton1.setText("Buscar");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPersonal))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(0), "Acciones", 2, 0, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 204, 0))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N

        btnIdentificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/u_sesion.png"))); // NOI18N
        btnIdentificar.setText("Identificar");
        btnIdentificar.setName("btnIdentificar"); // NOI18N
        btnIdentificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIdentificarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_guardar.PNG"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setName("btnGuardar"); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/btn_apagar.png"))); // NOI18N
        btnApagar.setText("Salir       ");
        btnApagar.setName("btnApagar"); // NOI18N
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        btnEncender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/huella.png"))); // NOI18N
        btnEncender.setText("Encender");
        btnEncender.setName("btnEncender"); // NOI18N
        btnEncender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncenderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIdentificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(btnApagar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEncender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIdentificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(btnEncender)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnApagar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PanelContenedorComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_PanelContenedorComponentHidden
        // TODO add your handling code here:
}//GEN-LAST:event_PanelContenedorComponentHidden

    private void PanelContenedorComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_PanelContenedorComponentShown
        //        this.PanelContenedor.add(crearPanelHuella());
}//GEN-LAST:event_PanelContenedorComponentShown

    private void PanelContenedorMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelContenedorMouseMoved
        //
}//GEN-LAST:event_PanelContenedorMouseMoved

    private void btnIdentificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIdentificarActionPerformed
        identificar();
}//GEN-LAST:event_btnIdentificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
}//GEN-LAST:event_btnGuardarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        Apagar();
    }//GEN-LAST:event_btnApagarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Buscar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        ValidadoresUtil.validarNumero(evt);
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        Buscar();
    }//GEN-LAST:event_txtDniActionPerformed

    private void btnEncenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncenderActionPerformed
        Encender();
    }//GEN-LAST:event_btnEncenderActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelContenedor;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnEncender;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIdentificar;
    public org.adox.app.util.biometrico.ImagePanel imgPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtDni;
    public javax.swing.JTextField txtPersonal;
    // End of variables declaration//GEN-END:variables

    /**
     * Método utilizado para mostrar la imagen de la huella
     * en el panel correspondiente.
     */
    public void ActivarBotones() {
        btnGuardar.setEnabled(true);
    }

    public void writeLog(String text) {
        System.out.println("::: LECTOR BIOMETRICO ::: " + text);
    }

    private void guardar() {
        if (txtPersonal.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Ingrese DNI del personal");
            return;
        }
        btnGuardar.setEnabled(false);
        oBiominiUtil.GuardarHuella(idPersonal);
        txtPersonal.setText("");
    }

    private void identificar() {
        try {
            txtPersonal.setText("");
            btnGuardar.setEnabled(false);
            btnIdentificar.setEnabled(false);
            oBiominiUtil.IdentificarHuella();
            
            btnIdentificar.setEnabled(true);
        } catch (Exception e) {
            System.out.println("Se presento problemas al identificar huella "+e.getMessage());
        }
//        InicializarPanel();
    }

    private void Buscar() {
        txtPersonal.setText("");
        if (txtDni.getText().trim().length() != 8) {
            JOptionPane.showMessageDialog(this, "DNI Incorrecto ");
            return;
        }
        Personal oPersona = frmPrincipal.oNegocioDao.getBuscarPersonalDni(txtDni.getText().trim());
        if (oPersona.getIdpersonal().toString().trim().equals("0")) {
            JOptionPane.showMessageDialog(this, "DNI NO REGISTRADO");
        } else {
            idPersonal = oPersona.getIdpersonal().toString();
            nrodocumento = txtDni.getText().trim();
            txtPersonal.setText("" + oPersona.getNombre());
        }

    }

    private void Encender() {
        btnGuardar.setEnabled(true);
        oBiominiUtil.Enroll_Biomini();
    }

    private void Apagar() {
        oBiominiUtil.Uninit_Suprema();
        dispose();
    }
}
