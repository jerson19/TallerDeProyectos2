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
import javax.swing.SwingUtilities;
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
 * Formulario Principal Created on 03-nov-2010, 17:09:00
 *
 * @version V1
 * @author Adolfo
 */
public class frmPrincipal extends javax.swing.JFrame {

    public String rol;
    ProgressUtil oProgressUtil;
    UsuarioSesion objSession;
    static Logger oClass = Logger.getLogger("frmPrincipal");
    public static ServicioSpring aop;
    public static facadeNegocioBusiness oNegocioBuss;
    public static facadeNegocioDao oNegocioDao;
    public static facadeAplicacionDao oAplicacionDao;
    public static rptReporteDao oReporte;

    public frmPrincipal() {
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

    public frmPrincipal(UsuarioSesion oUsuarioSesion, Object formLogeoTemp) {
        objSession = oUsuarioSesion;
        initComponents();
        _initSpring();
        _init();
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setIconImage(new ImageIcon(AppConfigLocal.APP_ICONO).getImage());

        //_maximizaFormulario();
        if (formLogeoTemp instanceof frmLogin) {
            frmLogin formLogeo = (frmLogin) formLogeoTemp;
            formLogeo.dispose();
            LogsUtil.Msg(oClass, "BIENVENIDO SR(A). " + oUsuarioSesion.getNombre().toUpperCase() + " " + oUsuarioSesion.getApellidos().toUpperCase() + " AL SISTEMA DE ASISTENCIA BIOMÉTRICA", " BIENVENIDO A " + oUsuarioSesion.getEmpresa(), JOptionPane.INFORMATION_MESSAGE);
        }
        this.setVisible(true);
        abrirGestionAsistencia();
    }

    public frmPrincipal(UsuarioSesion oUsuarioSesion) {
        objSession = oUsuarioSesion;
        initComponents();
        _initSpring();
        _init();
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        LogsUtil.Msg(oClass, "BIENVENIDO SR(A). " + oUsuarioSesion.getNombre().toUpperCase() + " " + oUsuarioSesion.getApellidos().toUpperCase() + " AL SISTEMA DE ASISTENCIA BIOMÉTRICA", " BIENVENIDO A " + oUsuarioSesion.getEmpresa(), JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(true);
    }

    public frmPrincipal(UsuarioSesion oUsuarioSesion, frmLogin formLogeo) {
        objSession = oUsuarioSesion;
        initComponents();
        _initSpring();
        _init();
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        formLogeo.dispose();
        LogsUtil.Msg(oClass, "BIENVENIDO SR(A). " + oUsuarioSesion.getNombre().toUpperCase() + " " + oUsuarioSesion.getApellidos().toUpperCase() + " AL SISTEMA DE ASISTENCIA BIOMÉTRICA", " BIENVENIDO A " + oUsuarioSesion.getEmpresa(), JOptionPane.INFORMATION_MESSAGE);
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
        lblProgeso.setVisible(false);
        // EN ESTE PUNTO SE APLICAN LOS ROLES DE LA APLICACION
        llenarMenuPaneles();
        llenarPanelDetalle();
        imagenFondo();
    }
    /**/
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPaneAplicacion = new javax.swing.JSplitPane();
        contenedorprincipal = new javax.swing.JPanel();
        contenedor = new javax.swing.JPanel();
        spContenedor = new javax.swing.JScrollPane();
        contenedorIf = new javax.swing.JDesktopPane();
        jXContainerMenu = new org.jdesktop.swingx.JXTaskPaneContainer();
        menuAplicacion = new org.jdesktop.swingx.JXTaskPane();
        menuAsistencia = new org.jdesktop.swingx.JXTaskPane();
        menuPersonal = new org.jdesktop.swingx.JXTaskPane();
        menuProductividad = new org.jdesktop.swingx.JXTaskPane();
        menuReportes = new org.jdesktop.swingx.JXTaskPane();
        pInformacion = new javax.swing.JPanel();
        lblProgeso = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(" ::: SISTEMA DE ASISTENCIA BIOMÉTRICA  ::: "+ objSession.getEmpresa());
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        contenedorprincipal.setBackground(new java.awt.Color(255, 255, 255));

        contenedor.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        spContenedor.setAutoscrolls(true);

        contenedorIf.setBackground(new java.awt.Color(255, 255, 255));
        contenedorIf.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contenedorIf.setPreferredSize(new java.awt.Dimension(600, 300));

        javax.swing.GroupLayout contenedorIfLayout = new javax.swing.GroupLayout(contenedorIf);
        contenedorIf.setLayout(contenedorIfLayout);
        contenedorIfLayout.setHorizontalGroup(
            contenedorIfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contenedorIfLayout.setVerticalGroup(
            contenedorIfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        spContenedor.setViewportView(contenedorIf);

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 788, Short.MAX_VALUE)
            .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(spContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE))
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
            .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contenedorLayout.createSequentialGroup()
                    .addComponent(spContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        javax.swing.GroupLayout contenedorprincipalLayout = new javax.swing.GroupLayout(contenedorprincipal);
        contenedorprincipal.setLayout(contenedorprincipalLayout);
        contenedorprincipalLayout.setHorizontalGroup(
            contenedorprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorprincipalLayout.createSequentialGroup()
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        contenedorprincipalLayout.setVerticalGroup(
            contenedorprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jSplitPaneAplicacion.setRightComponent(contenedorprincipal);

        org.jdesktop.swingx.VerticalLayout verticalLayout1 = new org.jdesktop.swingx.VerticalLayout();
        verticalLayout1.setGap(14);
        jXContainerMenu.setLayout(verticalLayout1);

        menuAplicacion.setAutoscrolls(true);
        menuAplicacion.setCollapsed(true);
        menuAplicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_logistica.png"))); // NOI18N
        menuAplicacion.setTitle("Archivo :");
        menuAplicacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAplicacionMouseClicked(evt);
            }
        });
        jXContainerMenu.add(menuAplicacion);

        menuAsistencia.setAutoscrolls(true);
        menuAsistencia.setCollapsed(true);
        menuAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_biomini.PNG"))); // NOI18N
        menuAsistencia.setScrollOnExpand(true);
        menuAsistencia.setTitle("Asistencia :");
        menuAsistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAsistenciaMouseClicked(evt);
            }
        });
        jXContainerMenu.add(menuAsistencia);

        menuPersonal.setAutoscrolls(true);
        menuPersonal.setCollapsed(true);
        menuPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_venta.jpg"))); // NOI18N
        menuPersonal.setScrollOnExpand(true);
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
        menuReportes.setTitle("Reportes :");
        menuReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuReportesMouseClicked(evt);
            }
        });
        jXContainerMenu.add(menuReportes);

        jSplitPaneAplicacion.setLeftComponent(jXContainerMenu);

        pInformacion.setBackground(new java.awt.Color(10, 84, 104));
        pInformacion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));

        lblProgeso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/loading.gif"))); // NOI18N

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("XXX");

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("XXX");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("FECHA :");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("USUARIO :");

        javax.swing.GroupLayout pInformacionLayout = new javax.swing.GroupLayout(pInformacion);
        pInformacion.setLayout(pInformacionLayout);
        pInformacionLayout.setHorizontalGroup(
            pInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pInformacionLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblProgeso, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pInformacionLayout.setVerticalGroup(
            pInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInformacionLayout.createSequentialGroup()
                .addGroup(pInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProgeso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pInformacionLayout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pInformacionLayout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pInformacionLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPaneAplicacion)
            .addComponent(pInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSplitPaneAplicacion, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //REPORTES
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

    private void menuAsistenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAsistenciaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuAsistenciaMouseClicked

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

    /*
     Métodos de apertura de marcos internos 
     */
    // ARCHIVO
    private void abrirCerrarSesion() {
        int desicion = JOptionPane.showConfirmDialog(null, " ¿ESTAS SEGURO DE CERRAR LA SESIÓN? ", " SALIR DE SESIÓN ", JOptionPane.YES_NO_OPTION);
        if (desicion == 0) {
            this.setVisible(false);
//            frmLogin ofrmLogin = new frmLogin();
//            ofrmLogin.setVisible(true);
//            ofrmLogin.setLocationRelativeTo(null);
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    frmLogin ofrmLogin = new frmLogin(aop);
                    ofrmLogin.setVisible(true);
                    ofrmLogin.setLocationRelativeTo(null);
                }
            });
            dispose();
        }
        temporizador = 0;
        ProgressUtil.stop();
    }

    private void CerrarAplicacion() {
        int desicion = JOptionPane.showConfirmDialog(null, " ¿ESTAS SEGURO DE CERRAR LA APLICACIÓN? ", " SALIR DE LA APLICACIÓN ", JOptionPane.YES_NO_OPTION);
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
        //JOptionPane.showMessageDialog(this, "MEMORIA TOTAL USADA 'JVM': " + basurero.totalMemory());
        LogsUtil.Show(oClass, "MEMORIA LIBRE 'JVM' [ANTES]: " + basurero.freeMemory());
        //JOptionPane.showMessageDialog(this, "MEMORIA LIBRE 'JVM' [ANTES]: " + basurero.freeMemory());
        for (int i = 0; i <= 5; i++) {
            basurero.gc(); //Solicitando ...         
        }
        basurero.runFinalization();
        LogsUtil.Show(oClass, "MEMORIA [FREE] LIBRE [DESPUES]: " + basurero.freeMemory());
        //JOptionPane.showMessageDialog(this, "MEMORIA LIBRE 'JVM' [DESPUES]: " + basurero.freeMemory());
        LogsUtil.Show(oClass, "********** FIN: 'LIMPIEZA GARBAGE COLECTOR' **********");
        ProgressUtil.stop();
        //JOptionPane.showMessageDialog(this, "LIBERACION DE MEMORIA FINALIZADA");
        dispose();
        frmPrincipal ofrmPrincipal = new frmPrincipal(objSession);
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
            oReporte.viewReporte("::: REPORTE DEL PERSONAL :::", AppConfigLocal.RUTA_RPTPERSONAL, parametros);
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
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JSplitPane jSplitPaneAplicacion;
    public static org.jdesktop.swingx.JXTaskPaneContainer jXContainerMenu;
    public static javax.swing.JLabel lblFecha;
    public static javax.swing.JLabel lblProgeso;
    public static javax.swing.JLabel lblUsuario;
    public static org.jdesktop.swingx.JXTaskPane menuAplicacion;
    public static org.jdesktop.swingx.JXTaskPane menuAsistencia;
    public static org.jdesktop.swingx.JXTaskPane menuPersonal;
    public static org.jdesktop.swingx.JXTaskPane menuProductividad;
    public static org.jdesktop.swingx.JXTaskPane menuReportes;
    public static javax.swing.JPanel pInformacion;
    public static javax.swing.JScrollPane spContenedor;
    // End of variables declaration//GEN-END:variables

    public void llenarMenuPaneles() {
        llenarMenuArchivo();

        if (ConstantesApp.STATE_PRODUCTIVIDAD.equals("1")) {
            llenarMenuProductividad();
            menuProductividad.setVisible(true);
        } else {
            menuProductividad.setVisible(false);
        }

        if (ConstantesApp.TIPO_APP.equals("1")) {
            llenarMenuAsistencia();
            llenarMenuReportes();
            menuPersonal.setVisible(false);
        } else {
            /*LOS ROLES ESTAN DEFINIDOS ASI:        
             1	Administrador	
             2	Recursos Humanos
             3	Asistencias	
             4	Reportes	        
             */
            if (ConstantesApp.ID_ROL.equals("1")) {
                llenarMenuPersonal();
                llenarMenuAsistencia();
                llenarMenuReportes();
            }
            if (ConstantesApp.ID_ROL.equals("2")) {
                llenarMenuPersonal();
                llenarMenuAsistencia();
                llenarMenuReportes();
            }
            if (ConstantesApp.ID_ROL.equals("3")) {
                llenarMenuAsistencia();
                llenarMenuReportes();
                menuPersonal.setVisible(false);
            }
            if (ConstantesApp.ID_ROL.equals("4")) {
                llenarMenuReportes();
                menuPersonal.setVisible(false);
                menuAsistencia.setVisible(false);
            }
        }

        //NO USAN EL MODULO DE PRODUCTIVIDAD
        repaint();
    }

    public void llenarPanelDetalle() {
        lblUsuario.setText(ConstantesApp.USUARIO);
        //lblEmpresa.setText(ConstantesApp.EMPRESA);
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

            @Override
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
                putValue(Action.NAME, "Cerrar Sesión");
                putValue(Action.SHORT_DESCRIPTION, "Cerrar Sesión");
                putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
            }

            @Override
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
                putValue(Action.NAME, "Créditos");
                putValue(Action.SHORT_DESCRIPTION, "Créditos");
                putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (temporizador == 0) {
                    temporizador = 1;
                    abrirCreditos();
                }
            }
        });

        if (ConstantesApp.ID_ROL.equals("1")) {
//            menuAplicacion.add(new AbstractAction() {
//
//                {
//                    putValue(Action.NAME, "Copia de Respaldo");
//                    putValue(Action.SHORT_DESCRIPTION, "Copia de Respaldo");
//                    putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
//                }
//
//                @Override
//                public void actionPerformed(ActionEvent e) {
//
//                    if (temporizador == 0) {
//                        temporizador = 1;
//                        oProgressUtil = new ProgressUtil();
//                        oProgressUtil.load();
//                        repaint();
//                        Thread p = new Thread() {
//
//                            @Override
//                            public void run() {
//                                abrirBackup();
//                            }
//                        };
//                        p.start();
//                    }
//
//                }
//            });
        }

  /*      menuAplicacion.add(new AbstractAction() {

            {
                putValue(Action.NAME, "Restaurar");
                putValue(Action.SHORT_DESCRIPTION, "Restaurar");
                putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                temporizador = 0;
                oProgressUtil = new ProgressUtil();
                oProgressUtil.load();
                repaint();
                Thread p = new Thread() {

                    @Override
                    public void run() {
                        abrirLiberarMemoria();
                    }
                };
                p.start();
            }
        });*/

    }

    private void llenarMenuAsistencia() {

        if (ConstantesApp.ID_ROL.equals("3") || ConstantesApp.ID_ROL.equals("1")) {
            menuAsistencia.add(new AbstractAction() {

                {
                    putValue(Action.NAME, "Gestión Asistencia");
                    putValue(Action.SHORT_DESCRIPTION, "Gestión Asistencia");
                    putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
                }

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (temporizador == 0) {
                        temporizador = 1;
                        oProgressUtil = new ProgressUtil();
                        oProgressUtil.load();
                        repaint();
                        Thread p = new Thread() {

                            @Override
                            public void run() {
                                abrirGestionAsistencia();
                            }
                        };
                        p.start();
                    }
                }
            });

            menuAsistencia.add(new AbstractAction() {

                {
                    putValue(Action.NAME, "Gestión Biométrica");
                    putValue(Action.SHORT_DESCRIPTION, "Gestión Biométrica");
                    putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
                }

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (temporizador == 0) {
                        temporizador = 1;
                        oProgressUtil = new ProgressUtil();
                        oProgressUtil.load();
                        repaint();
                        Thread p = new Thread() {

                            @Override
                            public void run() {
                                abrirCapturas();
                            }
                        };
                        p.start();
                    }
                }
            });
        }

    }

    private void llenarMenuPersonal() {

        if (!ConstantesApp.ID_ROL.equals("4")) {
            menuPersonal.add(new AbstractAction() {

                {
                    putValue(Action.NAME, "Gestión Personal");
                    putValue(Action.SHORT_DESCRIPTION, "Gestión Personal");
                    putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
                }

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (temporizador == 0) {
                        temporizador = 1;
                        oProgressUtil = new ProgressUtil();
                        oProgressUtil.load();
                        repaint();
                        Thread p = new Thread() {

                            @Override
                            public void run() {
                                abrirGestionPersonal();
                            }
                        };
                        p.start();
                    }
                }
            });
        }

        if (ConstantesApp.ID_ROL.equals("1")) {
            menuPersonal.add(new AbstractAction() {

                {
                    putValue(Action.NAME, "Institución");
                    putValue(Action.SHORT_DESCRIPTION, "Institución");
                    putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
                }

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (temporizador == 0) {
                        temporizador = 1;
                        oProgressUtil = new ProgressUtil();
                        oProgressUtil.load();
                        repaint();
                        Thread p = new Thread() {

                            @Override
                            public void run() {
                                abrirGestionEmpresa();
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

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (temporizador == 0) {
                        temporizador = 1;
                        oProgressUtil = new ProgressUtil();
                        oProgressUtil.load();
                        repaint();
                        Thread p = new Thread() {

                            @Override
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

            @Override
            public void actionPerformed(ActionEvent e) {
                if (temporizador == 0) {
                    temporizador = 1;
                    oProgressUtil = new ProgressUtil();
                    oProgressUtil.load();
                    repaint();
                    Thread p = new Thread() {

                        @Override
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

            @Override
            public void actionPerformed(ActionEvent e) {
                if (temporizador == 0) {
                    temporizador = 1;
                    oProgressUtil = new ProgressUtil();
                    oProgressUtil.load();
                    repaint();
                    Thread p = new Thread() {

                        @Override
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

            @Override
            public void actionPerformed(ActionEvent e) {
                if (temporizador == 0) {
                    temporizador = 1;
                    oProgressUtil = new ProgressUtil();
                    oProgressUtil.load();
                    repaint();
                    Thread p = new Thread() {

                        @Override
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
                putValue(Action.NAME, "Reporte de Asistencias");
                putValue(Action.SHORT_DESCRIPTION, "Reporte de Asistencias");
                putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (temporizador == 0) {
                    temporizador = 1;
                    oProgressUtil = new ProgressUtil();
                    oProgressUtil.load();
                    repaint();
                    Thread p = new Thread() {

                        @Override
                        public void run() {
                            abrirReportesVentas();
                        }
                    };
                    p.start();
                }

            }
        });

        menuReportes.add(new AbstractAction() {

            {
                putValue(Action.NAME, "Reporte de Personal");
                putValue(Action.SHORT_DESCRIPTION, "Reporte de Personal");
                putValue(Action.SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/menu_opcion.png")));
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (temporizador == 0) {
                    temporizador = 1;
                    oProgressUtil = new ProgressUtil();
                    oProgressUtil.load();
                    repaint();
                    Thread p = new Thread() {

                        @Override
                        public void run() {
                            abrirReportesPersonal();
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

        if (xSigMarco + oJInternalFrame.getWidth() > contenedorIf.getWidth()) {
            xSigMarco = 0;
        }
        if (ySigMarco + oJInternalFrame.getHeight() > contenedorIf.getHeight()) {
            ySigMarco = 0;
        }
        repaint();
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
