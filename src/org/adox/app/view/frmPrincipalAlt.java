package org.adox.app.view;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import org.adox.app.common.ConstantesApp;
import org.adox.app.config.AppConfigLocal;
import org.adox.app.config.ServicioSpring;
import org.adox.app.facade.business.dto.UsuarioSesion;
import org.adox.app.facade.business.dto.dtoTabla;
import org.adox.app.facade.business.facadeNegocioBusiness;
import org.adox.app.facade.dao.facadeAplicacionDao;
import org.adox.app.facade.dao.facadeNegocioDao;
import org.adox.app.facade.dao.rptReporteDao;
import org.adox.app.util.DateUtil;
import org.adox.app.util.ImagFondoCentradaUtil;
import org.adox.app.util.LogsUtil;
import org.adox.app.util.ProgressUtil;
import org.adox.app.view.aplicacion.ifAsistencias;
import org.adox.app.view.aplicacion.ifBackup;
import org.adox.app.view.aplicacion.ifCapturas;
import org.adox.app.view.aplicacion.ifEmpresa;
import org.adox.app.view.personal.ifGestionPersonal;
import org.adox.app.view.productividad.ifActividades;
import org.adox.app.view.productividad.ifGestionProductividad;
import org.adox.app.view.productividad.ifRegistroProductividad;
import org.adox.app.view.productividad.ifReporteProductividad;
import org.adox.app.view.reportes.ifReporteMensual;
import org.apache.log4j.Logger;

/**
 * Formulario Principal
 * Created on 03-nov-2010, 17:09:00
 * @version V1
 * @author Adolfo
 */
public class frmPrincipalAlt extends javax.swing.JFrame {

    public String rol;
    ProgressUtil oProgressUtil;
    UsuarioSesion objSession;
    static Logger oClass = Logger.getLogger("frmPrincipal");
    public static ServicioSpring aop;
    public static facadeNegocioBusiness oNegocioBuss;
    public static facadeNegocioDao oNegocioDao;
    public static facadeAplicacionDao oAplicacionDao;
    public static rptReporteDao oReporte;

    public frmPrincipalAlt() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        UsuarioSesion obj = new UsuarioSesion();
        obj.setIdUsuario("1");
        obj.setApellidos("Villanueva");
        obj.setNombre("Adolfo");
        obj.setEmpresa("ADOX");
        obj.setOficina("BREÑA");
        obj.setRol("1");
        obj.setFechaActual("HOY DIA PS");
        objSession = obj;
        _init();
        _initSpring();
    }

    public frmPrincipalAlt(UsuarioSesion oUsuarioSesion) {
        objSession = oUsuarioSesion;
        initComponents();
        _init();
        _initSpring();
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    public frmPrincipalAlt(UsuarioSesion oUsuarioSesion, frmLogin formLogeo) {
        objSession = oUsuarioSesion;
        initComponents();
        _init();
        _initSpring();
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        formLogeo.dispose();
        LogsUtil.Msg(oClass, "BIENVENIDO SR(A). " + oUsuarioSesion.getNombre().toUpperCase() + " " + oUsuarioSesion.getApellidos().toUpperCase() + " AL SISTEMA DE ASISTENCIA BIOMETRICA", " BIENVENIDO A LA " + oUsuarioSesion.getEmpresa(), JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(true);
    }

    private void _initSpring() {
        aop = new ServicioSpring();
        oNegocioBuss = (facadeNegocioBusiness) aop.getBean("facadeNegocioBusiness");
        oNegocioDao = (facadeNegocioDao) aop.getBean("facadeNegocioDao");
        oAplicacionDao = (facadeAplicacionDao) aop.getBean("facadeAplicacionDao");
        oReporte = (rptReporteDao) aop.getBean("rptReporteDao");
    }

    private void _init() {
        this.setIconImage(new ImageIcon(AppConfigLocal.APP_ICONO).getImage());
        ConstantesApp.ID_USUARIO = objSession.getIdUsuario();
        ConstantesApp.ID_PERSONAL = objSession.getIdPersonal();
        ConstantesApp.USUARIO = objSession.getNombre().trim().toUpperCase() + " " + objSession.getApellidos().trim().toUpperCase();
        ConstantesApp.ID_ROL = objSession.getRol();
        ConstantesApp.ID_EMPRESA = objSession.getIdEmpresa();
        ConstantesApp.EMPRESA = objSession.getEmpresa().toUpperCase().trim();
        LogsUtil.Show(oClass, "ID_USUARIO es : " + ConstantesApp.ID_USUARIO);
        LogsUtil.Show(oClass, "ID_PERSONAL es : " + ConstantesApp.ID_PERSONAL);
        LogsUtil.Show(oClass, "ID_ROL es : " + ConstantesApp.ID_ROL);
        LogsUtil.Show(oClass, "ID_EMPRESA es : " + ConstantesApp.ID_EMPRESA);
        LogsUtil.Show(oClass, "EMPRESA es : " + ConstantesApp.EMPRESA);
        menuToolbar.setVisible(false);
        jMenuApp.setVisible(false);
        lblProgeso.setVisible(false);
        // EN ESTE PUNTO SE APLICAN LOS ROLES DE LA APLICACION
        llenarMenuPaneles();
        llenarPanelDetalle();
        imagenFondo();
        roles();
    }

    private void roles() {
//        if (ContantesApp.ID_ROL.equals("1")) {
//            menuProductividad.setVisible(false);
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPaneAplicacion = new javax.swing.JSplitPane();
        contenedorprincipal = new javax.swing.JPanel();
        contenedor = new javax.swing.JPanel();
        menuToolbar = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        contenedorIf = new javax.swing.JDesktopPane();
        jXContainerMenu = new org.jdesktop.swingx.JXTaskPaneContainer();
        menuAplicacion = new org.jdesktop.swingx.JXTaskPane();
        menuPersonal = new org.jdesktop.swingx.JXTaskPane();
        menuProductividad = new org.jdesktop.swingx.JXTaskPane();
        menuReportes = new org.jdesktop.swingx.JXTaskPane();
        pInformacion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblEmpresa = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblProgeso = new javax.swing.JLabel();
        jMenuApp = new javax.swing.JMenuBar();
        pArchivo = new javax.swing.JMenu();
        mCerrarApp = new javax.swing.JMenuItem();
        pAdministracion = new javax.swing.JMenu();
        mpMantenimientoRepuestos = new javax.swing.JMenuItem();
        mpCierreCaja = new javax.swing.JMenuItem();
        pReportes = new javax.swing.JMenu();
        mpRepRepuestos = new javax.swing.JMenuItem();
        mpRepMovimientos = new javax.swing.JMenuItem();
        pAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(" ::: SISTEMA DE ASISTENCIA BIOMETRICA  :::  -  "+ objSession.getEmpresa());
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        contenedorprincipal.setBackground(new java.awt.Color(255, 255, 255));

        contenedor.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        menuToolbar.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/reporte3.png"))); // NOI18N
        jButton1.setText("Reporte Mensual");
        jButton1.setToolTipText("Ocultar Menu");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        menuToolbar.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/reporte2.png"))); // NOI18N
        jButton2.setText("Reporte Clientes");
        jButton2.setToolTipText("Ocultar Menu");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        menuToolbar.add(jButton2);

        contenedorIf.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 807, Short.MAX_VALUE)
            .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(menuToolbar, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
                .addComponent(contenedorIf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE))
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
            .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contenedorLayout.createSequentialGroup()
                    .addComponent(menuToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(contenedorIf, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout contenedorprincipalLayout = new javax.swing.GroupLayout(contenedorprincipal);
        contenedorprincipal.setLayout(contenedorprincipalLayout);
        contenedorprincipalLayout.setHorizontalGroup(
            contenedorprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contenedorprincipalLayout.setVerticalGroup(
            contenedorprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jSplitPaneAplicacion.setRightComponent(contenedorprincipal);

        menuAplicacion.setAutoscrolls(true);
        menuAplicacion.setCollapsed(true);
        menuAplicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_logistica.png"))); // NOI18N
        menuAplicacion.setSpecial(true);
        menuAplicacion.setTitle("Archivo :");
        menuAplicacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAplicacionMouseClicked(evt);
            }
        });
        jXContainerMenu.add(menuAplicacion);

        menuPersonal.setAutoscrolls(true);
        menuPersonal.setCollapsed(true);
        menuPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_venta.jpg"))); // NOI18N
        menuPersonal.setScrollOnExpand(true);
        menuPersonal.setSpecial(true);
        menuPersonal.setTitle("Personal :");
        menuPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPersonalMouseClicked(evt);
            }
        });
        jXContainerMenu.add(menuPersonal);

        menuProductividad.setAutoscrolls(true);
        menuProductividad.setCollapsed(true);
        menuProductividad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/reporte2.png"))); // NOI18N
        menuProductividad.setScrollOnExpand(true);
        menuProductividad.setSpecial(true);
        menuProductividad.setTitle("Productividad :"); // NOI18N
        menuProductividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuProductividadMouseClicked(evt);
            }
        });
        jXContainerMenu.add(menuProductividad);

        menuReportes.setAutoscrolls(true);
        menuReportes.setCollapsed(true);
        menuReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_reporte.png"))); // NOI18N
        menuReportes.setScrollOnExpand(true);
        menuReportes.setSpecial(true);
        menuReportes.setTitle("Reportes :");
        menuReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuReportesMouseClicked(evt);
            }
        });
        jXContainerMenu.add(menuReportes);

        jSplitPaneAplicacion.setLeftComponent(jXContainerMenu);

        pInformacion.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("USUARIO :");

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(0, 51, 102));
        lblUsuario.setText("XXX");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("INSTITUCION :");

        lblEmpresa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEmpresa.setForeground(new java.awt.Color(0, 51, 102));
        lblEmpresa.setText("XXX");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("FECHA :");

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(0, 51, 102));
        lblFecha.setText("XXX");

        lblProgeso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/loading.gif"))); // NOI18N

        javax.swing.GroupLayout pInformacionLayout = new javax.swing.GroupLayout(pInformacion);
        pInformacion.setLayout(pInformacionLayout);
        pInformacionLayout.setHorizontalGroup(
            pInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblProgeso, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pInformacionLayout.setVerticalGroup(
            pInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2)
                .addComponent(lblEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblProgeso, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pArchivo.setText("   Archivo     ");

        mCerrarApp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mCerrarApp.setText("Cerrar Aplicación");
        mCerrarApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCerrarAppActionPerformed(evt);
            }
        });
        pArchivo.add(mCerrarApp);

        jMenuApp.add(pArchivo);

        mpMantenimientoRepuestos.setText("Registro Repuestos");
        mpMantenimientoRepuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpMantenimientoRepuestosActionPerformed(evt);
            }
        });
        pAdministracion.add(mpMantenimientoRepuestos);

        mpCierreCaja.setText("Cierre de Caja");
        mpCierreCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpCierreCajaActionPerformed(evt);
            }
        });
        pAdministracion.add(mpCierreCaja);

        jMenuApp.add(pAdministracion);

        pReportes.setText("    Reportes     ");

        mpRepRepuestos.setText("Repuestos");
        mpRepRepuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpRepRepuestosActionPerformed(evt);
            }
        });
        pReportes.add(mpRepRepuestos);

        mpRepMovimientos.setText("Movimientos");
        mpRepMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpRepMovimientosActionPerformed(evt);
            }
        });
        pReportes.add(mpRepMovimientos);

        jMenuApp.add(pReportes);

        pAyuda.setText("           Ayuda            ");
        jMenuApp.add(pAyuda);

        setJMenuBar(jMenuApp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSplitPaneAplicacion)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSplitPaneAplicacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mCerrarAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCerrarAppActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mCerrarAppActionPerformed

    private void mpMantenimientoRepuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpMantenimientoRepuestosActionPerformed
        //[INI]
        //[FIN]
    }//GEN-LAST:event_mpMantenimientoRepuestosActionPerformed

    private void mpRepRepuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpRepRepuestosActionPerformed
        //[INI]
        //[FIN]
    }//GEN-LAST:event_mpRepRepuestosActionPerformed

    private void mpRepMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpRepMovimientosActionPerformed
        //[INI]
        //[FIN]
    }//GEN-LAST:event_mpRepMovimientosActionPerformed

    private void mpCierreCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpCierreCajaActionPerformed
        //[INI]
        //[FIN]
    }//GEN-LAST:event_mpCierreCajaActionPerformed
//REPORTES
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        abrirReportesMensual();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
//        abrirGestionPersonal();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void menuPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPersonalMouseClicked
        // TODO add your handling code here:        
        MinimizarMenusPersonal();
    }//GEN-LAST:event_menuPersonalMouseClicked

    private void menuReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuReportesMouseClicked
        // TODO add your handling code here:   
        MinimizarMenusReporte();
    }//GEN-LAST:event_menuReportesMouseClicked

    private void menuAplicacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAplicacionMouseClicked
        // TODO add your handling code here:   
        MinimizarMenusAplicacion();
    }//GEN-LAST:event_menuAplicacionMouseClicked

private void menuProductividadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuProductividadMouseClicked
    // TODO add your handling code here:  
    MinimizarMenusProductividad();
}//GEN-LAST:event_menuProductividadMouseClicked

    private void MinimizarMenusPersonal() {
        menuAplicacion.setCollapsed(true);
        menuReportes.setCollapsed(true);
        menuProductividad.setCollapsed(true);
        repaint();
    }

    private void MinimizarMenusReporte() {
        menuPersonal.setCollapsed(true);
        menuAplicacion.setCollapsed(true);
        menuProductividad.setCollapsed(true);
        repaint();
    }

    private void MinimizarMenusAplicacion() {
        menuPersonal.setCollapsed(true);
        menuReportes.setCollapsed(true);
        menuProductividad.setCollapsed(true);
        repaint();
    }

    private void MinimizarMenusProductividad() {
        menuAplicacion.setCollapsed(true);
        menuPersonal.setCollapsed(true);
        menuReportes.setCollapsed(true);
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new frmPrincipalAlt().setVisible(true);
            }
        });
    }

    /*
    Métodos de apertura de marcos internos 
     */
    // ARCHIVO
    private void abrirCerrarSesion() {
        int desicion = JOptionPane.showConfirmDialog(null, " ¿ESTAS SEGURO DE CERRAR LA SESION? ", " SALIR DE SESION ", JOptionPane.YES_NO_OPTION);
        if (desicion == 0) {
            this.setVisible(false);
            frmLogin ofrmLogin = new frmLogin(aop);
            ofrmLogin.setVisible(true);
            ofrmLogin.setLocationRelativeTo(null);
            dispose();
        }
        temporizador = 0;
        ProgressUtil.stop();
    }

    private void CerrarAplicacion() {
        int desicion = JOptionPane.showConfirmDialog(null, " ¿ESTAS SEGURO DE CERRAR LA APLICACION? ", " SALIR DE LA APLICACION ", JOptionPane.YES_NO_OPTION);
        if (desicion == 0) {
            System.exit(0);
        }
        temporizador = 0;
        ProgressUtil.stop();
    }

    private void abrirBackup() {
        int desicion = JOptionPane.showConfirmDialog(null, " ¿ESTAS SEGURO DE REALIZAR COPIA DE SEGURIDAD? ", " COPIA DE SEGURIDAD ", JOptionPane.YES_NO_OPTION);
        if (desicion == 0) {
            ifBackup oifBackup = new ifBackup(aop);
            oifBackup.setVisible(true);
            oifBackup.setLocationRelativeTo(null);
        }
        temporizador = 0;
        ProgressUtil.stop();
    }
    ifCreditos gCreditos;

    private void abrirCreditos() {
        if (estacerrado(gCreditos)) {
            gCreditos = new ifCreditos();
            abrirMarcoInterno(gCreditos);
        } else {
            JOptionPane.showMessageDialog(this, ConstantesApp.MENSAJE_FORMULARIO_ABIERTO);
        }
        temporizador = 0;
        ProgressUtil.stop();
    }

    private void abrirLiberarMemoria() {
        JOptionPane.showMessageDialog(this, "SE DEBE CERRAR TODOS LOS FORMULARIOS, ESTO TARDARA UN PAR DE MINUTOS ");
        LogsUtil.Show(oClass, "********** INICIO: 'LIMPIEZA GARBAGE COLECTOR' **********");
        Runtime basurero = Runtime.getRuntime();
        LogsUtil.Show(oClass, "MEMORIA TOTAL USADA 'JVM': " + basurero.totalMemory());
        JOptionPane.showMessageDialog(this, "MEMORIA TOTAL USADA 'JVM': " + basurero.totalMemory());
        LogsUtil.Show(oClass, "MEMORIA LIBRE 'JVM' [ANTES]: " + basurero.freeMemory());
        JOptionPane.showMessageDialog(this, "MEMORIA LIBRE 'JVM' [ANTES]: " + basurero.freeMemory());
        for (int i = 0; i <= 5; i++) {
            basurero.gc(); //Solicitando ...         
        }
        basurero.runFinalization();
        LogsUtil.Show(oClass, "MEMORIA [FREE] LIBRE [DESPUES]: " + basurero.freeMemory());
        JOptionPane.showMessageDialog(this, "MEMORIA LIBRE 'JVM' [DESPUES]: " + basurero.freeMemory());
        LogsUtil.Show(oClass, "********** FIN: 'LIMPIEZA GARBAGE COLECTOR' **********");
        ProgressUtil.stop();
        JOptionPane.showMessageDialog(this, "LIBERACION DE MEMORIA FINALIZADA");
        dispose();
        frmPrincipalAlt ofrmPrincipal = new frmPrincipalAlt(objSession);
        ofrmPrincipal.setLocationRelativeTo(null);
        ofrmPrincipal.setExtendedState(MAXIMIZED_BOTH);
        ofrmPrincipal.setVisible(true);
    }
    // ADMINISTRACION
    public static JInternalFrame gGestionEmpresa;

    private void abrirGestionEmpresa() {
        if (estacerrado(gGestionEmpresa)) {
            gGestionEmpresa = new JInternalFrame("::: GESTIÓN DE EMPRESAS :::");
            ifEmpresa obj = new ifEmpresa();
            gGestionEmpresa.add(obj);
            gGestionEmpresa.setIconifiable(true);
            gGestionEmpresa.setClosable(false);
            gGestionEmpresa.pack();
            abrirMarcoInterno(gGestionEmpresa);
        } else {
            JOptionPane.showMessageDialog(this, ConstantesApp.MENSAJE_FORMULARIO_ABIERTO);
        }
        temporizador = 0;
        ProgressUtil.stop();
    }
    ifCapturas gCapturas;

    private void abrirCapturas() {
        if (estacerrado(gCapturas)) {
            gCapturas = new ifCapturas();
            abrirMarcoInterno(gCapturas);
        } else {
            JOptionPane.showMessageDialog(this, ConstantesApp.MENSAJE_FORMULARIO_ABIERTO);
        }
        temporizador = 0;
        ProgressUtil.stop();
    }
    ifGestionPersonal gGestionPersonal;

    private void abrirGestionPersonal() {
        if (estacerrado(gGestionPersonal)) {
            gGestionPersonal = new ifGestionPersonal();
            abrirMarcoInterno(gGestionPersonal);
        } else {
            JOptionPane.showMessageDialog(this, ConstantesApp.MENSAJE_FORMULARIO_ABIERTO);
        }
        temporizador = 0;
        ProgressUtil.stop();
    }
    ifAsistencias gAsistencias;

    private void abrirGestionAsistencia() {
        if (estacerrado(gAsistencias)) {
            gAsistencias = new ifAsistencias();
            abrirMarcoInterno(gAsistencias);
        } else {
            JOptionPane.showMessageDialog(this, ConstantesApp.MENSAJE_FORMULARIO_ABIERTO);
        }
        temporizador = 0;
        ProgressUtil.stop();
    }
    //PRODUCTIVIDAD
    public static JInternalFrame gActividades;

    private void abrirMantActividades() {
        if (estacerrado(gActividades)) {
            gActividades = new JInternalFrame("::: MANTENIMIENTO DE ACTIVIDADES :::");
            ifActividades obj = new ifActividades();
            gActividades.add(obj);
            gActividades.setIconifiable(true);
            gActividades.setClosable(false);
            gActividades.pack();
            abrirMarcoInterno(gActividades);
        } else {
            JOptionPane.showMessageDialog(this, ConstantesApp.MENSAJE_FORMULARIO_ABIERTO);
        }
        temporizador = 0;
        ProgressUtil.stop();
    }
    ifRegistroProductividad gRegistroActividades;

    private void abrirRegistroActividades() {
        if (estacerrado(gRegistroActividades)) {
            gRegistroActividades = new ifRegistroProductividad();
            abrirMarcoInterno(gRegistroActividades);
        } else {
            JOptionPane.showMessageDialog(this, ConstantesApp.MENSAJE_FORMULARIO_ABIERTO);
        }
        temporizador = 0;
        ProgressUtil.stop();
    }
    ifGestionProductividad gGestionActividades;

    private void abrirGestionActividades() {
        if (estacerrado(gGestionActividades)) {
            gGestionActividades = new ifGestionProductividad();
            abrirMarcoInterno(gGestionActividades);
        } else {
            JOptionPane.showMessageDialog(this, ConstantesApp.MENSAJE_FORMULARIO_ABIERTO);
        }
        temporizador = 0;
        ProgressUtil.stop();
    }
    ifReporteProductividad gReporteProductividad;

    private void abrirReporteActividades() {
        if (estacerrado(gReporteProductividad)) {
            gReporteProductividad = new ifReporteProductividad();
            abrirMarcoInterno(gReporteProductividad);
        } else {
            JOptionPane.showMessageDialog(this, ConstantesApp.MENSAJE_FORMULARIO_ABIERTO);
        }
        temporizador = 0;
        ProgressUtil.stop();
    }

    //REPORTES
    private void abrirReportesPersonal() {
        try {
            List<dtoTabla> parametros = new ArrayList<dtoTabla>();
            dtoTabla par = new dtoTabla();
            par.setId("logo");
            par.setDescripcion("logoreporte.png");
            parametros.add(par);
            oReporte.viewReporte("::: Reporte de Personal :::", AppConfigLocal.RUTA_RPTPERSONAL, parametros);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Problemas al Generar Reporte");
        }
        temporizador = 0;
        ProgressUtil.stop();
    }
    ifReporteMensual gReporteMensual;

    private void abrirReportesVentas() {
        if (estacerrado(gReporteMensual)) {
            gReporteMensual = new ifReporteMensual();
            abrirMarcoInterno(gReporteMensual);
        } else {
            JOptionPane.showMessageDialog(this, ConstantesApp.MENSAJE_FORMULARIO_ABIERTO);
        }
        temporizador = 0;
        ProgressUtil.stop();
    }
    /*
    VARIABLES DE LA APLICACION
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel contenedor;
    public static javax.swing.JDesktopPane contenedorIf;
    public static javax.swing.JPanel contenedorprincipal;
    public static javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JMenuBar jMenuApp;
    public static javax.swing.JSplitPane jSplitPaneAplicacion;
    public static org.jdesktop.swingx.JXTaskPaneContainer jXContainerMenu;
    public static javax.swing.JLabel lblEmpresa;
    public static javax.swing.JLabel lblFecha;
    public static javax.swing.JLabel lblProgeso;
    public static javax.swing.JLabel lblUsuario;
    public static javax.swing.JMenuItem mCerrarApp;
    public static org.jdesktop.swingx.JXTaskPane menuAplicacion;
    public static org.jdesktop.swingx.JXTaskPane menuPersonal;
    public static org.jdesktop.swingx.JXTaskPane menuProductividad;
    public static org.jdesktop.swingx.JXTaskPane menuReportes;
    public static javax.swing.JToolBar menuToolbar;
    public static javax.swing.JMenuItem mpCierreCaja;
    public static javax.swing.JMenuItem mpMantenimientoRepuestos;
    public static javax.swing.JMenuItem mpRepMovimientos;
    public static javax.swing.JMenuItem mpRepRepuestos;
    public static javax.swing.JMenu pAdministracion;
    public static javax.swing.JMenu pArchivo;
    public static javax.swing.JMenu pAyuda;
    public static javax.swing.JPanel pInformacion;
    public static javax.swing.JMenu pReportes;
    // End of variables declaration//GEN-END:variables

    public void llenarMenuPaneles() {
        llenarMenuArchivo();
        llenarMenuProductividad();
        if (ConstantesApp.ID_ROL.equals("1")) {
            llenarMenuPersonal();
            llenarMenuReportes();
        }
        if (ConstantesApp.ID_ROL.equals("2")) {
            llenarMenuPersonal();
            llenarMenuReportes();
        }
        if (ConstantesApp.ID_ROL.equals("3")) {
            llenarMenuPersonal();
        }
        if (ConstantesApp.ID_ROL.equals("4")) {
            menuPersonal.setVisible(false);
            menuReportes.setVisible(false);
        }
        repaint();
    }

    public void llenarPanelDetalle() {
        lblUsuario.setText(ConstantesApp.USUARIO);
        lblEmpresa.setText(ConstantesApp.EMPRESA);
        lblFecha.setText(DateUtil.fecha_DD_MES_YYYY());
    }

    public void imagenFondo() {
        BufferedImage image = null;
        try {
            LogsUtil.Show(oClass, "La imagen  es : " + System.getProperty("user.dir") + AppConfigLocal.APP_LOGO);
            image = ImageIO.read(new File(System.getProperty("user.dir") + AppConfigLocal.APP_LOGO));
            //image = ImageIO.read(this.getClass().getResource("/logo.jpg"));
        } catch (IOException ex) {
//            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        contenedorIf.setBorder(new ImagFondoCentradaUtil(image));
    }
    int temporizador = 0;
    //LLENADO DE MENUS
    //MENU ARCHIVO

    private void llenarMenuArchivo() {

        menuAplicacion.add(new AbstractAction() {

            {
                putValue(Action.NAME, "Cerrar Aplicación");
                putValue(Action.SHORT_DESCRIPTION, "Cerrar Aplicación");
                putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
            }

            public void actionPerformed(ActionEvent e) {
                if (temporizador == 0) {
                    temporizador = 1;
                    oProgressUtil = new ProgressUtil();
                    oProgressUtil.load();
                    repaint();
                    CerrarAplicacion();
                }
            }
        });

        menuAplicacion.add(new AbstractAction() {

            {
                putValue(Action.NAME, "Cerrar Sesion");
                putValue(Action.SHORT_DESCRIPTION, "Cerrar Sesion");
                putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
            }

            public void actionPerformed(ActionEvent e) {
                if (temporizador == 0) {
                    temporizador = 1;
                    oProgressUtil = new ProgressUtil();
                    oProgressUtil.load();
                    repaint();
                    abrirCerrarSesion();

                }
            }
        });

        menuAplicacion.add(new AbstractAction() {

            {
                putValue(Action.NAME, "Creditos");
                putValue(Action.SHORT_DESCRIPTION, "Creditos");
                putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
            }

            public void actionPerformed(ActionEvent e) {
                if (temporizador == 0) {
                    temporizador = 1;
                    abrirCreditos();
                }
            }
        });

        if (ConstantesApp.ID_ROL.equals("1")) {
            menuAplicacion.add(new AbstractAction() {

                {
                    putValue(Action.NAME, "Copia de Respaldo");
                    putValue(Action.SHORT_DESCRIPTION, "Copia de Respaldo");
                    putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
                }

                public void actionPerformed(ActionEvent e) {

                    if (temporizador == 0) {
                        temporizador = 1;
                        oProgressUtil = new ProgressUtil();
                        oProgressUtil.load();
                        repaint();
                        Thread p = new Thread() {

                            public void run() {
                                abrirBackup();
                            }
                        };
                        p.start();
                    }

                }
            });
        }

        menuAplicacion.add(new AbstractAction() {

            {
                putValue(Action.NAME, "Inicializar");
                putValue(Action.SHORT_DESCRIPTION, "Inicializar");
                putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
            }

            public void actionPerformed(ActionEvent e) {
                temporizador = 0;
                oProgressUtil = new ProgressUtil();
                oProgressUtil.load();
                repaint();
                Thread p = new Thread() {

                    public void run() {
                        abrirLiberarMemoria();
                    }
                };
                p.start();
            }
        });

    }

    private void llenarMenuPersonal() {

        if (ConstantesApp.ID_ROL.equals("1")) {
            menuPersonal.add(new AbstractAction() {

                {
                    putValue(Action.NAME, "Institución");
                    putValue(Action.SHORT_DESCRIPTION, "Institución");
                    putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
                }

                public void actionPerformed(ActionEvent e) {
                    if (temporizador == 0) {
                        temporizador = 1;
                        oProgressUtil = new ProgressUtil();
                        oProgressUtil.load();
                        repaint();
                        Thread p = new Thread() {

                            public void run() {
                                abrirGestionEmpresa();
                            }
                        };
                        p.start();
                    }
                }
            });
        }

        if (!ConstantesApp.ID_ROL.equals("4")) {
            menuPersonal.add(new AbstractAction() {

                {
                    putValue(Action.NAME, "Gestión Personal");
                    putValue(Action.SHORT_DESCRIPTION, "Gestión Personal");
                    putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
                }

                public void actionPerformed(ActionEvent e) {
                    if (temporizador == 0) {
                        temporizador = 1;
                        oProgressUtil = new ProgressUtil();
                        oProgressUtil.load();
                        repaint();
                        Thread p = new Thread() {

                            public void run() {
                                abrirGestionPersonal();
                            }
                        };
                        p.start();
                    }
                }
            });
        }

        if (ConstantesApp.ID_ROL.equals("3") || ConstantesApp.ID_ROL.equals("1")) {
            menuPersonal.add(new AbstractAction() {

                {
                    putValue(Action.NAME, "Gestión Biométrica");
                    putValue(Action.SHORT_DESCRIPTION, "Gestión Biométrica");
                    putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
                }

                public void actionPerformed(ActionEvent e) {
                    if (temporizador == 0) {
                        temporizador = 1;
                        oProgressUtil = new ProgressUtil();
                        oProgressUtil.load();
                        repaint();
                        Thread p = new Thread() {

                            public void run() {
                                abrirCapturas();
                            }
                        };
                        p.start();
                    }
                }
            });

            menuPersonal.add(new AbstractAction() {

                {
                    putValue(Action.NAME, "Gestión Asistencia");
                    putValue(Action.SHORT_DESCRIPTION, "Gestión Asistencia");
                    putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
                }

                public void actionPerformed(ActionEvent e) {
                    if (temporizador == 0) {
                        temporizador = 1;
                        oProgressUtil = new ProgressUtil();
                        oProgressUtil.load();
                        repaint();
                        Thread p = new Thread() {

                            public void run() {
                                abrirGestionAsistencia();
                            }
                        };
                        p.start();
                    }
                }
            });
        }
    }

    private void llenarMenuProductividad() {

        if (ConstantesApp.ID_ROL.equals("2") || ConstantesApp.ID_ROL.equals("1")) {
            menuProductividad.add(new AbstractAction() {

                {
                    putValue(Action.NAME, "Registro Actividades");
                    putValue(Action.SHORT_DESCRIPTION, "Registro Actividades");
                    putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
                }

                public void actionPerformed(ActionEvent e) {
                    if (temporizador == 0) {
                        temporizador = 1;
                        oProgressUtil = new ProgressUtil();
                        oProgressUtil.load();
                        repaint();
                        Thread p = new Thread() {

                            public void run() {
                                abrirMantActividades();
                            }
                        };
                        p.start();
                    }
                }
            });
        }

        menuProductividad.add(new AbstractAction() {

            {
                putValue(Action.NAME, "Registro Productividad");
                putValue(Action.SHORT_DESCRIPTION, "Registro Productividad");
                putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
            }

            public void actionPerformed(ActionEvent e) {
                if (temporizador == 0) {
                    temporizador = 1;
                    oProgressUtil = new ProgressUtil();
                    oProgressUtil.load();
                    repaint();
                    Thread p = new Thread() {

                        public void run() {
                            abrirRegistroActividades();
                        }
                    };
                    p.start();
                }
            }
        });

        menuProductividad.add(new AbstractAction() {

            {
                putValue(Action.NAME, "Gestión Productividad");
                putValue(Action.SHORT_DESCRIPTION, "Gestión Productividad");
                putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
            }

            public void actionPerformed(ActionEvent e) {
                if (temporizador == 0) {
                    temporizador = 1;
                    oProgressUtil = new ProgressUtil();
                    oProgressUtil.load();
                    repaint();
                    Thread p = new Thread() {

                        public void run() {
                            abrirGestionActividades();
                        }
                    };
                    p.start();
                }
            }
        });

        menuProductividad.add(new AbstractAction() {

            {
                putValue(Action.NAME, "Reporte Productividad");
                putValue(Action.SHORT_DESCRIPTION, "Reporte Productividad");
                putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
            }

            public void actionPerformed(ActionEvent e) {
                if (temporizador == 0) {
                    temporizador = 1;
                    oProgressUtil = new ProgressUtil();
                    oProgressUtil.load();
                    repaint();
                    Thread p = new Thread() {

                        public void run() {
                            abrirReporteActividades();
                        }
                    };
                    p.start();
                }
            }
        });

    }

    private void llenarMenuReportes() {

        menuReportes.add(new AbstractAction() {

            {
                putValue(Action.NAME, "Reporte de Personal");
                putValue(Action.SHORT_DESCRIPTION, "Reporte de Personal");
                putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
            }

            public void actionPerformed(ActionEvent e) {
                if (temporizador == 0) {
                    temporizador = 1;
                    oProgressUtil = new ProgressUtil();
                    oProgressUtil.load();
                    repaint();
                    Thread p = new Thread() {

                        public void run() {
                            abrirReportesPersonal();
                        }
                    };
                    p.start();
                }
            }
        });

        menuReportes.add(new AbstractAction() {

            {
                putValue(Action.NAME, "Reporte de Asistencias");
                putValue(Action.SHORT_DESCRIPTION, "Reporte de Asistencias");
                putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
            }

            public void actionPerformed(ActionEvent e) {
                if (temporizador == 0) {
                    temporizador = 1;
                    oProgressUtil = new ProgressUtil();
                    oProgressUtil.load();
                    repaint();
                    Thread p = new Thread() {

                        public void run() {
                            abrirReportesVentas();
                        }
                    };
                    p.start();
                }

            }
        });
    }

    /* ABRIR MARCOS INTERNOS */
    private int xSigMarco;
    private int ySigMarco;
    private int distanciaEntreMarcos;

    private void abrirMarcoInterno(JInternalFrame oJInternalFrame) {
        oJInternalFrame.setLocation(xSigMarco, ySigMarco);
        oJInternalFrame.setVisible(true);
        contenedorIf.add(oJInternalFrame);
        try {
            oJInternalFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
//            Logger.getLogger(frmPrincipal.class.getName()).log(Level.INFO, null, ex);
        }

        if (distanciaEntreMarcos == 0) {
            distanciaEntreMarcos = oJInternalFrame.getHeight() - oJInternalFrame.getContentPane().getHeight();
        }

        xSigMarco += distanciaEntreMarcos;
        ySigMarco += distanciaEntreMarcos;

        if (xSigMarco + oJInternalFrame.getWidth() > contenedorIf.getWidth()) {
            xSigMarco = 0;
        }
        if (ySigMarco + oJInternalFrame.getHeight() > contenedorIf.getHeight()) {
            ySigMarco = 0;
        }
    }

//METODO QUE DEVUELVE UN VALOR BOOLEAN PARA SABER SI UN JINTERNALFRAME ESTA ABIERTO O NO
    public boolean estacerrado(Object obj) {
        JInternalFrame[] activos = contenedorIf.getAllFrames();
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
}
