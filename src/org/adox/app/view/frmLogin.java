package org.adox.app.view;

import com.sun.awt.AWTUtilities;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.adox.app.common.ConstantesApp;
import org.adox.app.config.AppConfigLocal;
import org.adox.app.config.ServicioSpring;
import org.adox.app.entities.Empresa;
import org.adox.app.facade.business.dto.UsuarioSesion;
import org.adox.app.facade.business.facadeNegocioBusiness;
import org.adox.app.facade.dao.facadeAplicacionDao;
import org.adox.app.util.LogsUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Formulario de logeo
 * Created on 03-nov-2010, 17:09:00
 * @version V1
 * @author Adolfo
 */
public class frmLogin extends javax.swing.JFrame {

    int NroIntentos = 0;
    static Logger oClass = Logger.getLogger("frmLogin");    
    ServicioSpring aop;
    
    facadeNegocioBusiness oNegocioBuss;
    
    facadeAplicacionDao oAplicacionDao;

    public frmLogin() {
        //VOLVIENDO INVISIBLE EL JFRAME
        setUndecorated(true);
        AWTUtilities.setWindowOpaque(this, false);
        aop = new ServicioSpring();
        initComponents();
        _init();
        lblMensaje.setVisible(false);
        infPassword1.setVisible(true);
    }
    public frmLogin(ServicioSpring oSpring) {
        //VOLVIENDO INVISIBLE EL JFRAME
        setUndecorated(true);
        AWTUtilities.setWindowOpaque(this, false);
        //aop = oSpring;
        initComponents();
        _init();
        lblMensaje.setVisible(false);
        infPassword1.setVisible(true);
    }

    private void _init() {
        this.setIconImage(new ImageIcon(AppConfigLocal.APP_ICONO).getImage());
        //aop = new ServicioSpring();
        oNegocioBuss = (facadeNegocioBusiness) aop.getBean("facadeNegocioBusiness");
        oAplicacionDao = (facadeAplicacionDao) aop.getBean("facadeAplicacionDao");
        ocultarCampos('T', false);
        llenarComboOficina();
        txtUsuario.requestFocus();
        cargaLogoSistema();
    }

    private void cargaLogoSistema() {
        BufferedImage image = null;
        try {
            LogsUtil.Show(oClass, "La imagen  es : " + System.getProperty("user.dir") + AppConfigLocal.APP_LOGO);
            image = ImageIO.read(new File(System.getProperty("user.dir") + AppConfigLocal.APP_LOGO));
            ImageIcon imagenFinal = new javax.swing.ImageIcon(redimensionarImagen(image, lblImagenInstitucion.getWidth(), lblImagenInstitucion.getHeight()));
            lblImagenInstitucion.setIcon(imagenFinal);
        } catch (IOException ex) {
            LogsUtil.Show(oClass, "Fallo Cargando imagen Central " + ex.getMessage());
        }
    }

    private Image redimensionarImagen(Image imagen, int ancho, int alto) {
        return imagen.getScaledInstance(ancho, alto, Image.SCALE_AREA_AVERAGING);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pLogo = new javax.swing.JPanel();
        lblImagenInstitucion = new javax.swing.JLabel();
        pDerechos = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        panelNice1 = new org.edisoncor.gui.panel.PanelNice();
        infUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        infPassword = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        cbEmpresa = new javax.swing.JComboBox();
        lblMensaje = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        infPassword1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("::: Seguridad del Sistema :::");
        setResizable(false);

        pLogo.setBackground(new java.awt.Color(255, 255, 255));
        pLogo.setName("pLogo"); // NOI18N

        lblImagenInstitucion.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblImagenInstitucion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblImagenInstitucion.setName("lblImagenInstitucion"); // NOI18N

        javax.swing.GroupLayout pLogoLayout = new javax.swing.GroupLayout(pLogo);
        pLogo.setLayout(pLogoLayout);
        pLogoLayout.setHorizontalGroup(
            pLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagenInstitucion, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
        );
        pLogoLayout.setVerticalGroup(
            pLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagenInstitucion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
        );

        pDerechos.setBackground(new java.awt.Color(255, 255, 255));
        pDerechos.setForeground(new java.awt.Color(255, 255, 255));
        pDerechos.setName("pDerechos"); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Copyright © 2017 - FISI-UNMSM  San Marcos");
        jLabel6.setToolTipText("Copyright © 2011 - SOLUCIONES INTEGRALES ADOX v2"); // NOI18N
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setName("jLabel6"); // NOI18N

        javax.swing.GroupLayout pDerechosLayout = new javax.swing.GroupLayout(pDerechos);
        pDerechos.setLayout(pDerechosLayout);
        pDerechosLayout.setHorizontalGroup(
            pDerechosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDerechosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pDerechosLayout.setVerticalGroup(
            pDerechosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6)
        );

        panelNice1.setName("panelNice1"); // NOI18N
        panelNice1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        infUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        infUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/alerta_precausion.png"))); // NOI18N
        infUsuario.setToolTipText("Ingrese Usuario");
        infUsuario.setName("infUsuario"); // NOI18N
        panelNice1.add(infUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 50, 50, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        jLabel2.setName("jLabel2"); // NOI18N
        panelNice1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 89, 83, 29));

        txtUsuario.setName("txtUsuario"); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        panelNice1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 50, 232, 32));

        txtPassword.setName("txtPassword"); // NOI18N
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        panelNice1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 88, 232, 32));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario");
        jLabel3.setName("jLabel3"); // NOI18N
        panelNice1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 83, 31));

        infPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        infPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/alerta_precausion.png"))); // NOI18N
        infPassword.setToolTipText("Ingrese Password");
        infPassword.setName("infPassword"); // NOI18N
        panelNice1.add(infPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 88, 50, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Institución");
        jLabel7.setName("jLabel7"); // NOI18N
        panelNice1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 126, 83, 38));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/btn_cancelar.jpg"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancelar.setName("btnCancelar"); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelNice1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 182, 114, 45));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/btn_aceptar.jpg"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAceptar.setName("btnAceptar"); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        btnAceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAceptarKeyPressed(evt);
            }
        });
        panelNice1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 182, 112, 45));

        cbEmpresa.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        cbEmpresa.setToolTipText("Empresa a la cual desea ingresar");
        cbEmpresa.setName("cbEmpresa"); // NOI18N
        cbEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEmpresaActionPerformed(evt);
            }
        });
        panelNice1.add(cbEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 126, 232, 38));

        lblMensaje.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(102, 0, 0));
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/load_circulo.gif"))); // NOI18N
        lblMensaje.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblMensaje.setName("lblMensaje"); // NOI18N
        panelNice1.add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 186, 50, 41));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Sistema de Asistencia Biométrica"); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N
        panelNice1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 370, 28));

        infPassword1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        infPassword1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infPassword1.setText(".....");
        infPassword1.setToolTipText("Ingrese Password");
        infPassword1.setName("infPassword1"); // NOI18N
        panelNice1.add(infPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 132, 50, 32));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setName("jLabel10"); // NOI18N
        panelNice1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 182, 83, 45));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelNice1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pDerechos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelNice1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pDerechos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        fValidacionUsuario();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        fCerrarAplicacion();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        txtPassword.requestFocus();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        btnAceptar.requestFocus();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void cbEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEmpresaActionPerformed
        btnAceptar.requestFocus();
    }//GEN-LAST:event_cbEmpresaActionPerformed

    private void btnAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceptarKeyPressed
        fValidacionUsuario();
    }//GEN-LAST:event_btnAceptarKeyPressed


    /*
    [INI] METODOS DEL FORMULARIO
     */
    private void fCerrarAplicacion() {
        int desicion = JOptionPane.showConfirmDialog(null, "DESEAS CANCELAR EL INICIO DE SESION ", " SALIR DE LA APLICACION ", JOptionPane.YES_NO_OPTION);
        if (desicion == 0) {
            LogsUtil.LogsApp(oClass, " :::: CERRANDO APLICACION :::", ConstantesApp.ERROR_INFO);
            System.exit(0);
        }
    }

    private void fValidacionUsuario() {
        btnAceptar.setEnabled(false);
        cbEmpresa.setEnabled(false);
        txtUsuario.requestFocus();
        if (NroIntentos < 3) {
            getValidaUsuario();
        } else {
            LogsUtil.Msg(oClass, "Nº DE INTENTOS SUPERADOS ", " ATENCION ", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
    }
    Thread p;

    private void getValidaUsuario() {
        p = new Thread() {

            @Override
            public void run() {
                getValidaUsuarioImpl();
            }
        };
        p.start();
    }

    public void getValidaUsuarioImpl() {
        ocultarCampos('M', true);
        String user, pass, empresa;
        boolean oConexion = false;
        //PROBANDO LA CONEXION
        oConexion = oAplicacionDao.getObtenerConexion();
        if (oConexion == true) {
            //CAPTURANDO LAS VARIABLES
            user = txtUsuario.getText().trim();
            pass = txtPassword.getText().trim();
            empresa = (String) cbEmpresa.getSelectedItem();
            String idOficina = ObtenerIdOficina(empresa);
            if (user.length() == 0) {
                txtUsuario.requestFocus();
                infUsuario.setVisible(true);
                ocultarCampos('M', false);
                btnAceptar.setEnabled(true);
                cbEmpresa.setEnabled(true);
                return;
            } else {
                infUsuario.setVisible(false);
            }

            if (pass.length() == 0) {
                txtPassword.requestFocus();
                infPassword.setVisible(true);
                ocultarCampos('M', false);
                btnAceptar.setEnabled(true);
                cbEmpresa.setEnabled(true);
                return;
            } else {
                infPassword.setVisible(false);
            }
            //OBTENIENDO LA VALIDACION
            UsuarioSesion obj = oNegocioBuss.getValidarLogeo(user, pass, idOficina);
            LogsUtil.Show(oClass, "El codigo es " + obj.getIdUsuario());
            if (!obj.getIdUsuario().trim().equals(ConstantesApp.CER0)) {
                frmPrincipal ofrmPrincipal = new frmPrincipal(obj, this);
            } else {
                LogsUtil.Msg(oClass, "Usuario, Contraseña y/o Institución Incorrectos ", " ATENCION ", JOptionPane.INFORMATION_MESSAGE);
                ocultarCampos('M', false);
                txtUsuario.requestFocus();
                NroIntentos++;
                btnAceptar.setEnabled(true);
                cbEmpresa.setEnabled(true);
            }
        } else {
            ocultarCampos('M', true);
            JOptionPane.showMessageDialog(null, "Problemas de conexión ", " ATENCION ", JOptionPane.INFORMATION_MESSAGE);
            ocultarCampos('M', false);
            btnAceptar.setEnabled(true);
            cbEmpresa.setEnabled(true);
        }

    }

    private String ObtenerIdOficina(String empresa) {
        String id = "0";
        for (Empresa emp : ListEmpresa) {
            if (emp.getDescOficina().equals(empresa)) {
                id = emp.getIdOficina();
            }
        }
        return id;
    }
    List<Empresa> ListEmpresa = null;

    private void llenarComboOficina() {
        ListEmpresa = oAplicacionDao.getObtenerOficinas();
        for (Empresa emp : ListEmpresa) {
            cbEmpresa.addItem(emp.getDescOficina());
        }
        cbEmpresa.repaint();
    }

    /*
    [FIN] METODOS DEL FORMULARIO
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                new frmLogin().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAceptar;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JComboBox cbEmpresa;
    public javax.swing.JLabel infPassword;
    public javax.swing.JLabel infPassword1;
    public javax.swing.JLabel infUsuario;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JLabel lblImagenInstitucion;
    public javax.swing.JLabel lblMensaje;
    public javax.swing.JPanel pDerechos;
    public javax.swing.JPanel pLogo;
    public org.edisoncor.gui.panel.PanelNice panelNice1;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
    //

    private void ocultarCampos(char ind, boolean estado) {
        switch (ind) {
            case 'T': //Todos
                infUsuario.setVisible(estado);
                infPassword.setVisible(estado);
                lblMensaje.setVisible(estado);
                break;
            case 'U': //Usuario
                infUsuario.setVisible(estado);
                break;
            case 'P'://Password
                infPassword.setVisible(estado);
                break;
            case 'M'://Mensaje
                lblMensaje.setVisible(estado);
                break;
        }
    }

//    public facadeNegocioBusiness getoNegocioBuss() {
//        return oNegocioBuss;
//    }
//
//    public void setoNegocioBuss(facadeNegocioBusiness oNegocioBuss) {
//        this.oNegocioBuss = oNegocioBuss;
//    }
//
//    public facadeAplicacionDao getoAplicacionDao() {
//        return oAplicacionDao;
//    }
//
//    public void setoAplicacionDao(facadeAplicacionDao oAplicacionDao) {
//        this.oAplicacionDao = oAplicacionDao;
//    }
}
