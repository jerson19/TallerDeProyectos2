package org.adox.app.view.personal;

import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;
import org.adox.app.common.ConstantesApp;

import org.adox.app.entities.Personal;
import org.adox.app.facade.business.dto.Tabla;
import org.adox.app.util.DateUtil;
import org.adox.app.util.LogsUtil;
import org.adox.app.util.ProgressUtil;
import org.adox.app.util.ValidadoresUtil;
import org.adox.app.view.frmPrincipal;
import org.apache.log4j.Logger;

/**
 * @author Adolfo
 ifPersonal.java
 Created on 07-abr-2011, 13:36:33
 */
public class ifPersonal extends javax.swing.JInternalFrame {

    static Logger oClass = Logger.getLogger("ifPersonal");
    Integer usuario;
    List<Tabla> listTipoDocumento;
    List<Tabla> listCargos;
    List<Tabla> listEstado;
    List<Tabla> listProfesion;
    List<Tabla> listNivel;
    List<Tabla> listCategoria;
    List<Personal> listResponsables;
    Personal oPersonal;
    Integer idPersonal;
    String PerfilActual;

    public ifPersonal() {
        initComponents();
    }

    public ifPersonal(String Perfil) {
        initComponents();
        _init(Perfil);
        ProgressUtil.stop();
    }

    public ifPersonal(String Perfil, String Personal) {
        initComponents();
        idPersonal = Integer.parseInt(Personal);
        _init(Perfil);
        ProgressUtil.stop();
    }

    private void _init(String Perfil) {
        usuario = Integer.parseInt(ConstantesApp.ID_USUARIO);
        PerfilActual = Perfil;
        txtNombre.requestFocus();
        try {
            cbFecha.setFormats(DateUtil.IrFormatoDDMMYYY());
        } catch (ParseException ex) {
            LogsUtil.Show(oClass, "ERROR : Al dar Formato a la fecha del componente");
        }
        if (Perfil.equals("N")) {
            perfilNuevo();
        }
        if (Perfil.equals("E")) {
            perfilModificar();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pBasica = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtApePat = new javax.swing.JTextField();
        txtApeMat = new javax.swing.JTextField();
        cbTipoDocumento = new javax.swing.JComboBox();
        txtNroDocumento = new javax.swing.JTextField();
        rbMasculino = new javax.swing.JRadioButton();
        rbFemenino = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cbFecha = new org.jdesktop.swingx.JXDatePicker();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtDireccionDni = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cbCargo = new javax.swing.JComboBox();
        cbEstado = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        txtDireccionLab = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbProfesion = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        txtNroColegiatura = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbHorario = new javax.swing.JComboBox();
        txtTelefono = new javax.swing.JTextField();
        txtCorreoElectronico = new javax.swing.JTextField();
        txthuella = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        cbResponsable = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("::: REGISTRO DEL PERSONAL :::"); // NOI18N

        pBasica.setBackground(new java.awt.Color(255, 255, 255));
        pBasica.setName("pBasica"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " ::: Datos Personales :::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 204, 0))); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(944, 127));
        jPanel1.setName("jPanel1"); // NOI18N

        txtNombre.setName("txtNombre"); // NOI18N

        txtApePat.setName("txtApePat"); // NOI18N
        txtApePat.setNextFocusableComponent(txtApeMat);

        txtApeMat.setName("txtApeMat"); // NOI18N
        txtApeMat.setNextFocusableComponent(cbTipoDocumento);

        cbTipoDocumento.setName("cbTipoDocumento"); // NOI18N
        cbTipoDocumento.setNextFocusableComponent(txtNroDocumento);
        cbTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoDocumentoActionPerformed(evt);
            }
        });

        txtNroDocumento.setMaximumSize(new java.awt.Dimension(8, 8));
        txtNroDocumento.setName("txtNroDocumento"); // NOI18N
        txtNroDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNroDocumentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroDocumentoKeyTyped(evt);
            }
        });

        rbMasculino.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(rbMasculino);
        rbMasculino.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbMasculino.setForeground(new java.awt.Color(255, 255, 204));
        rbMasculino.setSelected(true);
        rbMasculino.setText("Masculino");
        rbMasculino.setName("rbMasculino"); // NOI18N
        rbMasculino.setNextFocusableComponent(rbFemenino);

        rbFemenino.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(rbFemenino);
        rbFemenino.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbFemenino.setForeground(new java.awt.Color(255, 255, 204));
        rbFemenino.setText("Femenino");
        rbFemenino.setName("rbFemenino"); // NOI18N
        rbFemenino.setNextFocusableComponent(txtDireccionDni);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("*Fecha Nacimiento");
        jLabel8.setName("jLabel8"); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("*Sexo");
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("*Ape. Materno");
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("*Ape. Paterno");
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("*Nombres");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("*Nro Documento");
        jLabel7.setName("jLabel7"); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("*Tipo Documento");
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 204, 204));
        jLabel17.setText("    (*)  Dia - Mes - Año ");
        jLabel17.setName("jLabel17"); // NOI18N

        cbFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbFecha.setName("cbFecha"); // NOI18N
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre)
                                    .addComponent(cbTipoDocumento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtApePat, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbMasculino, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbFemenino, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtApeMat)
                    .addComponent(txtNroDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApePat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTipoDocumento)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApeMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(rbMasculino, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbFemenino)
                    .addComponent(cbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " ::: Informacion Personal :::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 204, 0))); // NOI18N
        jPanel4.setMaximumSize(new java.awt.Dimension(944, 122));
        jPanel4.setName("jPanel4"); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("*Domicilio DNI");
        jLabel9.setName("jLabel9"); // NOI18N

        txtDireccionDni.setName("txtDireccionDni"); // NOI18N
        txtDireccionDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccionDniKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("*Cargo");
        jLabel13.setName("jLabel13"); // NOI18N

        cbCargo.setName("cbCargo"); // NOI18N
        cbCargo.setNextFocusableComponent(cbEstado);
        cbCargo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCargoItemStateChanged(evt);
            }
        });
        cbCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCargoActionPerformed(evt);
            }
        });

        cbEstado.setName("cbEstado"); // NOI18N
        cbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEstadoItemStateChanged(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("N° Colegitura");
        jLabel24.setName("jLabel24"); // NOI18N

        txtDireccionLab.setName("txtDireccionLab"); // NOI18N
        txtDireccionLab.setNextFocusableComponent(cbProfesion);
        txtDireccionLab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccionLabKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("*Domicilio Laboral");
        jLabel10.setName("jLabel10"); // NOI18N

        cbProfesion.setName("cbProfesion"); // NOI18N
        cbProfesion.setNextFocusableComponent(txtNroColegiatura);
        cbProfesion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProfesionItemStateChanged(evt);
            }
        });
        cbProfesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProfesionActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("*Profesión");
        jLabel22.setName("jLabel22"); // NOI18N

        txtNroColegiatura.setName("txtNroColegiatura"); // NOI18N
        txtNroColegiatura.setNextFocusableComponent(cbCargo);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Estado");
        jLabel25.setName("jLabel25"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel10)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccionDni)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbProfesion, 0, 302, Short.MAX_VALUE)
                            .addComponent(cbCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNroColegiatura)))
                    .addComponent(txtDireccionLab, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionDni, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbProfesion)
                    .addComponent(txtNroColegiatura)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbEstado)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbCargo)
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " ::: Otros :::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 204, 0))); // NOI18N
        jPanel5.setMaximumSize(new java.awt.Dimension(944, 303));
        jPanel5.setName("jPanel5"); // NOI18N

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 1, true));
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Observaciones");
        jLabel23.setName("jLabel23"); // NOI18N
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 144, 65));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Telefonos");
        jLabel21.setName("jLabel21"); // NOI18N
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 144, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Horario");
        jLabel14.setName("jLabel14"); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 16, 144, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 204, 204));
        jLabel18.setText("(*) Atencion, campos obligatorios");
        jLabel18.setName("jLabel18"); // NOI18N
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 138, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Huella ");
        jLabel19.setName("jLabel19"); // NOI18N
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 144, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Correo Electronico");
        jLabel16.setName("jLabel16"); // NOI18N
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 144, -1));

        cbHorario.setName("cbHorario"); // NOI18N
        cbHorario.setNextFocusableComponent(cbCategoria);
        cbHorario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbHorarioItemStateChanged(evt);
            }
        });
        cbHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHorarioActionPerformed(evt);
            }
        });
        jPanel2.add(cbHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 13, 200, 23));

        txtTelefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTelefono.setName("txtTelefono"); // NOI18N
        txtTelefono.setNextFocusableComponent(txtCorreoElectronico);
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 440, 20));

        txtCorreoElectronico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCorreoElectronico.setName("txtCorreoElectronico"); // NOI18N
        jPanel2.add(txtCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 440, 20));

        txthuella.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txthuella.setText("NO");
        txthuella.setName("txthuella"); // NOI18N
        jPanel2.add(txthuella, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 79, 20));

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        txtObservaciones.setColumns(20);
        txtObservaciones.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        txtObservaciones.setRows(5);
        txtObservaciones.setName("txtObservaciones"); // NOI18N
        jScrollPane1.setViewportView(txtObservaciones);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 440, 64));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Grupo");
        jLabel26.setName("jLabel26"); // NOI18N
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 16, 50, 17));

        cbCategoria.setName("cbCategoria"); // NOI18N
        cbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCategoriaItemStateChanged(evt);
            }
        });
        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });
        jPanel2.add(cbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 13, 160, 23));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Responsable");
        jLabel28.setName("jLabel28"); // NOI18N
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 144, 31));

        cbResponsable.setName("cbResponsable"); // NOI18N
        cbResponsable.setNextFocusableComponent(cbCategoria);
        cbResponsable.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbResponsableItemStateChanged(evt);
            }
        });
        cbResponsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbResponsableActionPerformed(evt);
            }
        });
        jPanel2.add(cbResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 440, 31));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 51), 1, true));
        jPanel3.setName("jPanel3"); // NOI18N

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_salir.png"))); // NOI18N
        btnCerrar.setText("Salir");
        btnCerrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCerrar.setName("btnCerrar"); // NOI18N
        btnCerrar.setNextFocusableComponent(txtNombre);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnLimpiar.setName("btnLimpiar"); // NOI18N
        btnLimpiar.setNextFocusableComponent(btnCerrar);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_guardar.PNG"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGuardar.setName("btnGuardar"); // NOI18N
        btnGuardar.setNextFocusableComponent(btnLimpiar);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pBasicaLayout = new javax.swing.GroupLayout(pBasica);
        pBasica.setLayout(pBasicaLayout);
        pBasicaLayout.setHorizontalGroup(
            pBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBasicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pBasicaLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pBasicaLayout.setVerticalGroup(
            pBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBasicaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pBasicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pBasica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pBasica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        ifGestionPersonal.gPersonal.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed
    String urlFoto = "";
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cbTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoDocumentoActionPerformed

    private void cbCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCargoActionPerformed

    private void cbCargoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCargoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCargoItemStateChanged

    private void txtDireccionDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionDniKeyReleased
        // TODO add your handling code here:
        if (txtDireccionDni.getText().trim().length() > 0) {
            btnGuardar.setEnabled(true);
        } else {
            btnGuardar.setEnabled(false);
        }
    }//GEN-LAST:event_txtDireccionDniKeyReleased

    private void txtNroDocumentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroDocumentoKeyReleased
        // TODO add your handling code here:
//        validaNum(txtNroDocumento.getText().trim());
    }//GEN-LAST:event_txtNroDocumentoKeyReleased

    private void txtNroDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroDocumentoKeyTyped
        // TODO add your handling code here:
        ValidadoresUtil.validarNumero(evt);
    }//GEN-LAST:event_txtNroDocumentoKeyTyped

    private void cbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEstadoItemStateChanged
//
    }//GEN-LAST:event_cbEstadoItemStateChanged

    private void txtDireccionLabKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionLabKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionLabKeyReleased

    private void cbProfesionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProfesionItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbProfesionItemStateChanged

    private void cbProfesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProfesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbProfesionActionPerformed

    private void cbHorarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbHorarioItemStateChanged
        // TODO add your handling code here:obtenerIdProfesion
    }//GEN-LAST:event_cbHorarioItemStateChanged

    private void cbHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbHorarioActionPerformed

    private void cbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCategoriaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoriaItemStateChanged

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoriaActionPerformed

    private void cbFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbFechaMouseClicked
//        txtFechaNacimiento.setText("" + DateUtil.formatDate(cbFecha.getDate()));
}//GEN-LAST:event_cbFechaMouseClicked

    private void cbFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFechaActionPerformed
        //    txtFechaNacimiento.setText("" + DateUtil.formatDate(cbFecha.getDate()));
}//GEN-LAST:event_cbFechaActionPerformed

private void cbResponsableItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbResponsableItemStateChanged
// TODO add your handling code here:
}//GEN-LAST:event_cbResponsableItemStateChanged

private void cbResponsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbResponsableActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_cbResponsableActionPerformed
//
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbCargo;
    private javax.swing.JComboBox cbCategoria;
    private javax.swing.JComboBox cbEstado;
    private org.jdesktop.swingx.JXDatePicker cbFecha;
    private javax.swing.JComboBox cbHorario;
    private javax.swing.JComboBox cbProfesion;
    private javax.swing.JComboBox cbResponsable;
    private javax.swing.JComboBox cbTipoDocumento;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pBasica;
    private javax.swing.JRadioButton rbFemenino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JTextField txtApeMat;
    private javax.swing.JTextField txtApePat;
    private javax.swing.JTextField txtCorreoElectronico;
    private javax.swing.JTextField txtDireccionDni;
    private javax.swing.JTextField txtDireccionLab;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNroColegiatura;
    private javax.swing.JTextField txtNroDocumento;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txthuella;
    // End of variables declaration//GEN-END:variables

    private void perfilNuevo() {
        btnGuardar.setEnabled(false);
        CargarCombos();
    }

    private void perfilModificar() {
        btnLimpiar.setEnabled(false);
        //txtNroDocumento.setEnabled(false);
        CargarCombos();
        ObtenerDatosPersonal();
    }

    private void CargarCombos() {
        cargarTipoDocumento();
        cargarCargos();
        cargarEstado();
        cargarProfesion();
        cargarNivel();
        cargarCategoria();
        cargarResponsables();
    }

    private void guardar() {
        if (!(txtNombre.getText().trim().length() > 0 && txtApePat.getText().trim().length() > 0 && txtApeMat.getText().trim().length() > 0 && DateUtil.formatoFechaYYYYMMDD(cbFecha.getDate()).trim().length() > 0
                && txtNroDocumento.getText().trim().length() > 0 && DateUtil.formatoFechaYYYYMMDD(cbFecha.getDate()).trim().length() > 0 && cbTipoDocumento.getSelectedIndex() > 0)) {
            JOptionPane.showMessageDialog(this, "Ingrese Datos Personales Obligatorios", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (!(txtNroDocumento.getText().trim().length() >= 8 && txtNroDocumento.getText().trim().length() <= 11)) {
            JOptionPane.showMessageDialog(this, "Número de Digitos del documento es incorrecto", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (!(cbCargo.getSelectedIndex() > 0 && cbProfesion.getSelectedIndex() > 0 && cbEstado.getSelectedIndex() > 0 && txtDireccionDni.getText().trim().length() > 0 && txtDireccionLab.getText().trim().length() > 0)) {
            JOptionPane.showMessageDialog(this, "Ingrese Información Personal Obligatorios", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            if (PerfilActual.equals("N")) {
                if (VerificarDni()) {
                    Nuevo();
                }
            }
            if (PerfilActual.equals("E")) {
                Modificar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Problemas encontrados intente nuevamente, revisar fecha del sistema " + e.getMessage(), "Atencion", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }

    private void limpiar() {
        oPersonal = new Personal();
        urlFoto = "";
        txtNombre.setText("");
        txtApePat.setText("");
        txtApeMat.setText("");
        cbFecha.setDate(null);
        txtNroDocumento.setText("");
        txtDireccionDni.setText("");
        //txtSueldo.setText("");
        txtCorreoElectronico.setText("");
    }

    private void Nuevo() throws ParseException {
        oPersonal = new Personal();
        obtenerData();
        oPersonal.setUsureg(Integer.parseInt(ConstantesApp.ID_USUARIO));
        oPersonal.setUsumod(Integer.parseInt(ConstantesApp.ID_USUARIO));
        oPersonal.setFecregistro(DateUtil.FechaHoraActualDate());
        oPersonal.setFecmodificacion(DateUtil.FechaHoraActualDate());
        String nroReg = frmPrincipal.oNegocioDao.getRegistrarPersonal(oPersonal);
        if (!(nroReg.trim().equals(""))) {
            JOptionPane.showMessageDialog(this, "REGISTRO EXITOSO DATOS PERSONALES", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
            ifGestionPersonal.gPersonal.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "FALLO REGISTRO DATOS PERSONALES", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void Modificar() throws ParseException {
        oPersonal.setIdpersonal(idPersonal);
        obtenerData();
        oPersonal.setUsumod(Integer.parseInt(ConstantesApp.ID_USUARIO));
        oPersonal.setFecmodificacion(DateUtil.FechaHoraActualDateAlternativo());
        String nroReg = frmPrincipal.oNegocioDao.getActualizarPersonal(oPersonal);
        if (!(nroReg.trim().equals(""))) {
            JOptionPane.showMessageDialog(this, "ACTUALIZACION EXITOSA  DATOS PERSONALES", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
            ifGestionPersonal.gPersonal.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "FALLO ACTUALIZACION  DATOS PERSONALES", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void obtenerData() {
        obtenerIdCategoria();
        obtenerIdHorario();
        obtenerIdProfesion();
        obtenerIdEstado();
        obtenerIdTipoCargos();
        obtenerIdTipoDocumento();
        try {
            oPersonal.setFecnacimiento(cbFecha.getDate());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Fecha Ingresada Erronea", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        oPersonal.setNombre("" + txtNombre.getText().trim().toUpperCase());
        oPersonal.setApepat("" + txtApePat.getText().trim().toUpperCase());
        oPersonal.setApemat("" + txtApeMat.getText().trim().toUpperCase());
        oPersonal.setTipodocumento(idTipoDocumento);
        oPersonal.setNrodocumento("" + txtNroDocumento.getText().trim().toUpperCase());
        oPersonal.setCargo("" + idTipoCargo.trim().toUpperCase());
        oPersonal.setProfesion("" + idProfesion.trim().toUpperCase());
        oPersonal.setHorario("" + idHorario.trim().toUpperCase());
        oPersonal.setCategoria("" + idCategoria.trim().toUpperCase());
        oPersonal.setColegiatura("" + txtNroColegiatura.getText().trim().toUpperCase());
        oPersonal.setDireccion1("" + txtDireccionDni.getText().trim().toUpperCase());
        oPersonal.setDireccion2("" + txtDireccionLab.getText().trim().toUpperCase());
        oPersonal.setFono1("" + txtTelefono.getText().trim().toUpperCase());
        oPersonal.setCorreo("" + txtCorreoElectronico.getText().trim());
        //oPersonal.setRecomendacion("" + txtReferencia.getText().trim().toUpperCase());

        if (rbMasculino.isSelected() == true) {
            oPersonal.setSexo(ConstantesApp.SEXO_MASCULINO);
        }
        if (rbFemenino.isSelected() == true) {
            oPersonal.setSexo(ConstantesApp.SEXO_FEMENINO);
        }

        oPersonal.setUsureg(usuario);
        oPersonal.setEstado(idEstado);

        /*if (txtSueldo.getText().trim().length() > 0) {
            oPersonal.setSueldobruto("" + txtSueldo.getText().trim().toUpperCase());
        } else {
            oPersonal.setSueldobruto("0");
        }
        if (txtDescuento.getText().trim().length() > 0) {
            oPersonal.setDescuento(new BigDecimal(txtDescuento.getText().trim().toUpperCase()));
        } else {
            oPersonal.setDescuento(new BigDecimal("0"));
        }*/
        oPersonal.setObservaciones("" + txtObservaciones.getText().trim().toUpperCase());
        oPersonal.setResponsable("" + cbResponsable.getSelectedItem().toString().trim());
    }

    private void ObtenerDatosPersonal() {
        oPersonal = new Personal();
        oPersonal = frmPrincipal.oNegocioDao.getObtenerPersonal(idPersonal);
        txtNombre.setText("" + oPersonal.getNombre());
        txtApePat.setText("" + oPersonal.getApepat());
        txtApeMat.setText("" + oPersonal.getApemat());
        txtNroDocumento.setText("" + oPersonal.getNrodocumento());
        txtDireccionDni.setText("" + oPersonal.getDireccion1());
        txtDireccionLab.setText("" + oPersonal.getDireccion2());
        txtCorreoElectronico.setText("" + oPersonal.getCorreo());
        //txtSueldo.setText("" + oPersonal.getSueldobruto());
        //txtDescuento.setText("" + oPersonal.getDescuento());
        cbFecha.setDate(oPersonal.getFecnacimiento());
        txtTelefono.setText("" + oPersonal.getFono1());
        //txtReferencia.setText("" + oPersonal.getRecomendacion());

        txtNroColegiatura.setText("" + oPersonal.getColegiatura());
        txtObservaciones.setText("" + oPersonal.getObservaciones());


        if (oPersonal.getSexo().toString().trim().equals("1")) {
            rbMasculino.setSelected(true);
        }
        if (oPersonal.getSexo().toString().trim().equals("2")) {
            rbFemenino.setSelected(true);
        }
        if (oPersonal.getHuella() != null) {
            txthuella.setText("SI");
        }
        int i = 0;
        for (Tabla item : listTipoDocumento) {
            i++;
            if (oPersonal.getTipodocumento().toString().trim().equals(item.getId().trim())) {
                cbTipoDocumento.setSelectedIndex(i);
            }
        }
        int j = 0;
        LogsUtil.Show(oClass, "Id del cargo es : " + oPersonal.getCargo());
        for (Tabla item : listCargos) {
            j++;
            if (oPersonal.getCargo().toString().trim().equals(item.getId().trim())) {
                cbCargo.setSelectedIndex(j);
            }
        }
        int k = 0;
        LogsUtil.Show(oClass, "Id del estado es : " + oPersonal.getEstado());
        for (Tabla item : listEstado) {
            k++;
            if (oPersonal.getEstado().toString().trim().equals(item.getId().trim())) {
                cbEstado.setSelectedIndex(k);
            }
        }

        int y = 0;
        LogsUtil.Show(oClass, "Id del Profesion es : " + oPersonal.getProfesion());
        for (Tabla item : listProfesion) {
            y++;
            if (oPersonal.getProfesion().toString().trim().equals(item.getId().trim())) {
                cbProfesion.setSelectedIndex(y);
            }
        }

        int z = 0;
        LogsUtil.Show(oClass, "Id del Horario es : " + oPersonal.getHorario());
        for (Tabla item : listNivel) {
            z++;
            if (oPersonal.getHorario().toString().trim().equals(item.getId().trim())) {
                cbHorario.setSelectedIndex(z);
            }
        }

        int x = 0;
        LogsUtil.Show(oClass, "Id Categoria es : " + oPersonal.getCategoria());
        for (Tabla item : listCategoria) {
            x++;
            if (oPersonal.getCategoria().toString().trim().equals(item.getId().trim())) {
                cbCategoria.setSelectedIndex(x);
            }
        }

        int w = 0;
        LogsUtil.Show(oClass, "Responsable es : " + oPersonal.getResponsable());
        for (Personal item : listResponsables) {
            w++;
            if (oPersonal.getResponsable().toString().trim().equals(item.getNombre().trim() + " " + item.getApepat().trim() + " " + item.getApemat().trim())) {
                cbResponsable.setSelectedIndex(w);
            }
        }

    }
    //VARIABLES
    Integer idEstado = 1;
    Integer idTipoDocumento;
    String idTipoCargo = "";
    String idProfesion = "";
    String idHorario = "";
    String idCategoria = "";

    private void obtenerIdTipoDocumento() {
        LogsUtil.Show(oClass, "Seleccionado  : " + cbTipoDocumento.getSelectedItem().toString().trim());

        for (Tabla item : listTipoDocumento) {
            if (cbTipoDocumento.getSelectedItem().toString().trim().equals(item.getDescripcion().trim())) {
                idTipoDocumento = Integer.parseInt(item.getId().trim());
                LogsUtil.Show(oClass, "Codigo idTipoDocumento : " + idTipoDocumento);
            }
        }
    }

    private void obtenerIdEstado() {
        LogsUtil.Show(oClass, "Seleccionado  : " + cbEstado.getSelectedItem().toString().trim());
        for (Tabla item : listEstado) {
            if (cbEstado.getSelectedItem().toString().trim().equals(item.getDescripcion().trim())) {
                idEstado = Integer.parseInt(item.getId().trim());
                LogsUtil.Show(oClass, "Codigo : " + idEstado + " Estado : " + item.getDescripcion());
            }
        }
    }

    private void obtenerIdTipoCargos() {
        LogsUtil.Show(oClass, "Seleccionado  : " + cbCargo.getSelectedItem().toString().trim());
        for (Tabla item : listCargos) {
            if (cbCargo.getSelectedItem().toString().trim().equals(item.getDescripcion().trim())) {
                idTipoCargo = item.getId().trim();
                LogsUtil.Show(oClass, "Codigo idTipoZona : " + idTipoCargo);
            }
        }
    }

    private void obtenerIdProfesion() {
        try {
            LogsUtil.Show(oClass, "Seleccionado  : " + cbProfesion.getSelectedItem().toString().trim());
            for (Tabla item : listProfesion) {
                if (cbProfesion.getSelectedItem().toString().trim().equals(item.getDescripcion().trim())) {
                    idProfesion = item.getId().trim();
                    LogsUtil.Show(oClass, "Codigo idProfesion : " + idProfesion);
                }
            }
        } catch (Exception e) {
            idProfesion = "0";
            LogsUtil.Show(oClass, "Error en  obtenerIdProfesion");
        }
    }

    private void obtenerIdHorario() {
        LogsUtil.Show(oClass, "Seleccionado  : " + cbHorario.getSelectedItem().toString().trim());
        for (Tabla item : listNivel) {
            if (cbHorario.getSelectedItem().toString().trim().equals(item.getDescripcion().trim())) {
                idHorario = item.getId().trim();
                LogsUtil.Show(oClass, "Codigo idHorario : " + idHorario);
            }
        }
    }

    private void obtenerIdCategoria() {
        LogsUtil.Show(oClass, "Seleccionado  : " + cbCategoria.getSelectedItem().toString().trim());
        for (Tabla item : listCategoria) {
            if (cbCategoria.getSelectedItem().toString().trim().equals(item.getDescripcion().trim())) {
                idCategoria = item.getId().trim();
                LogsUtil.Show(oClass, "Codigo idCategoria : " + idCategoria);
            }
        }
    }
    //CARGANDO COMBOS

    private void cargarEstado() {
        listEstado = frmPrincipal.oAplicacionDao.getObtenerDescripcion(ConstantesApp.TABLA_ESTADO_PERSONAL);
        cbEstado.addItem("-- Seleccione --");
        for (Tabla emp : listEstado) {
            cbEstado.addItem(emp.getDescripcion());
        }
    }

    private void cargarTipoDocumento() {
        listTipoDocumento = frmPrincipal.oAplicacionDao.getObtenerDescripcion(ConstantesApp.TABLA_TIPO_DOCUMENTO);
        cbTipoDocumento.addItem("-- Seleccione --");

        for (Tabla emp : listTipoDocumento) {
            cbTipoDocumento.addItem(emp.getDescripcion());
        }
    }

    private void cargarCargos() {
        listCargos = frmPrincipal.oAplicacionDao.getObtenerDescripcion(ConstantesApp.TABLA_TIPO_CARGOS);
        cbCargo.addItem("-- Seleccione --");
        for (Tabla emp : listCargos) {
            cbCargo.addItem(emp.getDescripcion());
        }
    }

    private void cargarProfesion() {
        listProfesion = frmPrincipal.oAplicacionDao.getObtenerDescripcion(ConstantesApp.TABLA_TIPO_PROFESION);
        cbProfesion.addItem("-- Seleccione --");
        for (Tabla emp : listProfesion) {
            cbProfesion.addItem(emp.getDescripcion());
        }
    }

    private void cargarNivel() {
        listNivel = frmPrincipal.oAplicacionDao.getObtenerDescripcion(ConstantesApp.TABLA_TIPO_HORARIO);
        cbHorario.addItem("-- Seleccione --");
        for (Tabla emp : listNivel) {
            cbHorario.addItem(emp.getDescripcion());
        }
    }

    private void cargarCategoria() {
        listCategoria = frmPrincipal.oAplicacionDao.getObtenerDescripcion(ConstantesApp.TABLA_CATEGORIA);
        cbCategoria.addItem("-- Seleccione --");
        for (Tabla emp : listCategoria) {
            cbCategoria.addItem(emp.getDescripcion());
        }
    }

    private void cargarResponsables() {
        listResponsables = frmPrincipal.oNegocioDao.getBuscarPersonal("");
        cbResponsable.addItem("-- Seleccione --");
        for (Personal emp : listResponsables) {
            cbResponsable.addItem(emp.getNombre().trim() + " " + emp.getApepat().trim() + " " + emp.getApemat().trim());
        }
    }

    private boolean VerificarDni() {
        if (txtNroDocumento.getText().trim().length() != 8) {
            JOptionPane.showMessageDialog(this, "DNI INCORRECTO ");
            return false;
        }
        Personal obj = frmPrincipal.oNegocioDao.getBuscarPersonalDni(txtNroDocumento.getText());
        if (!obj.getIdpersonal().toString().trim().equals("0")) {
            JOptionPane.showMessageDialog(this, "EL DNI ESTA REGISTRADO CON OTRO PERSONAL");
            return false;
        }
        return true;
    }

    /*private void calculoDescuento() {
        BigDecimal resultado = new BigDecimal("0.00");
        try {
            resultado = new BigDecimal(SIGEADMUtil.CalucularDescuento10Min(txtSueldo.getText().trim()));
        } catch (Exception e) {
            LogsUtil.Show(oClass, "ERROR : Al Calcular el descuento al personal ");
        }
        txtDescuento.setText(resultado + "");
    }*/
}
