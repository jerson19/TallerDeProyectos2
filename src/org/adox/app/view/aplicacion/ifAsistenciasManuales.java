package org.adox.app.view.aplicacion;

import java.beans.Beans;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.adox.app.common.ConstantesApp;
import org.adox.app.entities.Asistencias;
import org.adox.app.util.DateUtil;
import org.adox.app.util.LogsUtil;
import org.adox.app.util.ProgressUtil;
import org.adox.app.view.frmPrincipal;
import org.apache.log4j.Logger;

/**
 * @author ADOLFO
 ifAsistenciasManuales.java
 Created on 07/06/2011, 10:08:45 PM
 */
public class ifAsistenciasManuales extends javax.swing.JInternalFrame {

    static Logger oClass = Logger.getLogger("ifAsistenciasManuales");
    private EntityManager entityManager;
    private Query query;
    private List<Asistencias> list;
    private Asistencias oAsistencias;
    Query qObtenerActualizaRptAsistencia;
    Query qObtenerRegistroRpte;
    Query qObtenerDatosPersonal;
    Query qRegistroRpte;
    String idPersonal;
    String nrodocumento;
    String nomPersonal;
//"SELECT a FROM Asistencias a where a.idpersonal="+idPersonal+" ORDER BY fecha DESC" 

    public ifAsistenciasManuales(String idPersonalR, String documento, String Personal) {
        _initPU();
        idPersonal = idPersonalR;
        nrodocumento = documento;
        nomPersonal = Personal;
        initComponents();
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
        _init();
        ProgressUtil.stop();
    }

    private void _init() {
        RefrescarTabla();
        //CAJAS DE TEXTO
        idasistenciasField.setEnabled(false);
        idpersonalField.setEnabled(false);
        idpersonalField.setText(idPersonal);
        nrodocumentoField.setEnabled(false);
        nrodocumentoField.setText(nrodocumento);
        personalField.setEnabled(false);
        personalField.setText(nomPersonal);
        fechaField.setEnabled(false);
        try {
            fechaField.setText("" + DateUtil.FechaActualString());
        } catch (Exception e) {
        }
        hingresoField.requestFocus();
        btnRegistrarDia.setEnabled(false);
        saveButton.setEnabled(false);
        editButton.setEnabled(false);
        //BOTONES
        txtPermiso.setEditable(true);
        txtJustificacion.setEditable(false);
    }

    private void _initPU() {
        entityManager = frmPrincipal.oAplicacionDao.getObtenerConexionPU();
    }

    private void _Persistencia() {
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT a FROM Asistencias a where a.idpersonal=" + idPersonal + " ORDER BY fecha DESC");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
    }

    private void RefrescarTabla() {
        _Persistencia();
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fecha}"));
        columnBinding.setColumnName("Fecha");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${personal}"));
        columnBinding.setColumnName("Personal");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hingreso}"));
        columnBinding.setColumnName("Hingreso");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hsalida}"));
        columnBinding.setColumnName("Hsalida");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterScrollPane.setViewportView(masterTable);
        bindingGroup.bind();
        personalizarJtable();
    }
    //METODOS DE LA APLICACION

    private void personalizarJtable() {
        masterTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        masterTable.getColumnModel().getColumn(0).setResizable(true);
        masterTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        masterTable.getColumnModel().getColumn(1).setResizable(true);
        masterTable.getColumnModel().getColumn(1).setPreferredWidth(400);
        masterTable.getColumnModel().getColumn(2).setResizable(true);
        masterTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        masterTable.getColumnModel().getColumn(3).setResizable(true);
        masterTable.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        idasistenciasLabel1 = new javax.swing.JLabel();
        idpersonalLabel1 = new javax.swing.JLabel();
        nrodocumentoLabel1 = new javax.swing.JLabel();
        hingresoLabel1 = new javax.swing.JLabel();
        hsalidarefrigerioLabel1 = new javax.swing.JLabel();
        hentradarefrigerioLabel1 = new javax.swing.JLabel();
        hsalidaLabel1 = new javax.swing.JLabel();
        fechaLabel1 = new javax.swing.JLabel();
        idasistenciasField = new javax.swing.JTextField();
        idpersonalField = new javax.swing.JTextField();
        nrodocumentoField = new javax.swing.JTextField();
        personalField = new javax.swing.JTextField();
        hingresoField = new javax.swing.JTextField();
        hsalidarefrigerioField = new javax.swing.JTextField();
        hentradarefrigerioField = new javax.swing.JTextField();
        hsalidaField = new javax.swing.JTextField();
        fechaField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        btnRegistrarDia = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPermiso = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtJustificacion = new javax.swing.JTextArea();
        rbPermiso = new javax.swing.JRadioButton();
        rbJustificacion = new javax.swing.JRadioButton();
        fechaLabel2 = new javax.swing.JLabel();
        txtTardanza = new javax.swing.JTextField();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        editButton = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("::: REGISTRO DE ASISTENCIA MANUAL :::");

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setName("jPanel2"); // NOI18N

        idasistenciasLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        idasistenciasLabel1.setForeground(new java.awt.Color(255, 255, 0));
        idasistenciasLabel1.setText("ID");
        idasistenciasLabel1.setName("idasistenciasLabel1"); // NOI18N

        idpersonalLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        idpersonalLabel1.setForeground(new java.awt.Color(255, 255, 0));
        idpersonalLabel1.setText("Id Personal:");
        idpersonalLabel1.setName("idpersonalLabel1"); // NOI18N

        nrodocumentoLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        nrodocumentoLabel1.setForeground(new java.awt.Color(255, 255, 0));
        nrodocumentoLabel1.setText("Personal:");
        nrodocumentoLabel1.setName("nrodocumentoLabel1"); // NOI18N

        hingresoLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        hingresoLabel1.setForeground(new java.awt.Color(255, 255, 0));
        hingresoLabel1.setText("Hra. Ingreso:");
        hingresoLabel1.setName("hingresoLabel1"); // NOI18N

        hsalidarefrigerioLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        hsalidarefrigerioLabel1.setForeground(new java.awt.Color(255, 255, 0));
        hsalidarefrigerioLabel1.setText("Hra. Salida Almuerzo");
        hsalidarefrigerioLabel1.setName("hsalidarefrigerioLabel1"); // NOI18N

        hentradarefrigerioLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        hentradarefrigerioLabel1.setForeground(new java.awt.Color(255, 255, 0));
        hentradarefrigerioLabel1.setText("Hra. Entrada Almuerzo:");
        hentradarefrigerioLabel1.setName("hentradarefrigerioLabel1"); // NOI18N

        hsalidaLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        hsalidaLabel1.setForeground(new java.awt.Color(255, 255, 0));
        hsalidaLabel1.setText("Hra. salida:");
        hsalidaLabel1.setName("hsalidaLabel1"); // NOI18N

        fechaLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        fechaLabel1.setForeground(new java.awt.Color(255, 255, 0));
        fechaLabel1.setText("Fecha:");
        fechaLabel1.setName("fechaLabel1"); // NOI18N

        idasistenciasField.setFont(new java.awt.Font("Tahoma", 1, 12));
        idasistenciasField.setName("idasistenciasField"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.idasistencias}"), idasistenciasField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        idpersonalField.setFont(new java.awt.Font("Tahoma", 1, 12));
        idpersonalField.setName("idpersonalField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.idpersonal}"), idpersonalField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        nrodocumentoField.setFont(new java.awt.Font("Tahoma", 1, 12));
        nrodocumentoField.setName("nrodocumentoField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nrodocumento}"), nrodocumentoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        personalField.setFont(new java.awt.Font("Tahoma", 1, 12));
        personalField.setName("personalField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.personal}"), personalField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        hingresoField.setFont(new java.awt.Font("Tahoma", 1, 12));
        hingresoField.setName("hingresoField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.hingreso}"), hingresoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        hsalidarefrigerioField.setFont(new java.awt.Font("Tahoma", 1, 12));
        hsalidarefrigerioField.setName("hsalidarefrigerioField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.hsalidarefrigerio}"), hsalidarefrigerioField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        hentradarefrigerioField.setFont(new java.awt.Font("Tahoma", 1, 12));
        hentradarefrigerioField.setName("hentradarefrigerioField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.hentradarefrigerio}"), hentradarefrigerioField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        hsalidaField.setFont(new java.awt.Font("Tahoma", 1, 12));
        hsalidaField.setName("hsalidaField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.hsalida}"), hsalidaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        fechaField.setFont(new java.awt.Font("Tahoma", 1, 12));
        fechaField.setName("fechaField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.fecha}"), fechaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_guardar.PNG"))); // NOI18N
        saveButton.setText("Guardar");
        saveButton.setName("saveButton"); // NOI18N
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        btnRegistrarDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_actualizar.png"))); // NOI18N
        btnRegistrarDia.setText("Registrar Asistencia del Día");
        btnRegistrarDia.setName("btnRegistrarDia"); // NOI18N
        btnRegistrarDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarDiaActionPerformed(evt);
            }
        });

        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_agregar.png"))); // NOI18N
        newButton.setText("Registro Asistencia");
        newButton.setName("newButton"); // NOI18N
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        txtPermiso.setColumns(20);
        txtPermiso.setRows(5);
        txtPermiso.setWrapStyleWord(true);
        txtPermiso.setName("txtPermiso"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.permisos}"), txtPermiso, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(txtPermiso);

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        txtJustificacion.setColumns(20);
        txtJustificacion.setRows(5);
        txtJustificacion.setName("txtJustificacion"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.justificacion}"), txtJustificacion, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane2.setViewportView(txtJustificacion);

        buttonGroup1.add(rbPermiso);
        rbPermiso.setFont(new java.awt.Font("Tahoma", 1, 11));
        rbPermiso.setForeground(new java.awt.Color(0, 0, 51));
        rbPermiso.setSelected(true);
        rbPermiso.setText("Permiso");
        rbPermiso.setName("rbPermiso"); // NOI18N
        rbPermiso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbPermisoMouseClicked(evt);
            }
        });
        rbPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPermisoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbJustificacion);
        rbJustificacion.setFont(new java.awt.Font("Tahoma", 1, 11));
        rbJustificacion.setForeground(new java.awt.Color(0, 0, 51));
        rbJustificacion.setText("Justificación");
        rbJustificacion.setName("rbJustificacion"); // NOI18N
        rbJustificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbJustificacionMouseClicked(evt);
            }
        });
        rbJustificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbJustificacionActionPerformed(evt);
            }
        });

        fechaLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        fechaLabel2.setForeground(new java.awt.Color(255, 255, 0));
        fechaLabel2.setText("Tardanza :");
        fechaLabel2.setName("fechaLabel2"); // NOI18N

        txtTardanza.setFont(new java.awt.Font("Tahoma", 1, 12));
        txtTardanza.setName("txtTardanza"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.tardanza}"), txtTardanza, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        masterScrollPane.setName("masterScrollPane"); // NOI18N

        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        masterTable.setName("masterTable"); // NOI18N

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${list}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fecha}"));
        columnBinding.setColumnName("Fecha");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${personal}"));
        columnBinding.setColumnName("Personal");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hingreso}"));
        columnBinding.setColumnName("Hingreso");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hsalida}"));
        columnBinding.setColumnName("Hsalida");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masterTableMouseClicked(evt);
            }
        });
        masterScrollPane.setViewportView(masterTable);

        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_editar.PNG"))); // NOI18N
        editButton.setText("Editar");
        editButton.setName("editButton"); // NOI18N
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRegistrarDia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idasistenciasLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nrodocumentoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(idasistenciasField)
                                    .addComponent(nrodocumentoField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(idpersonalLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(idpersonalField, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(personalField, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(hentradarefrigerioLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fechaLabel1)
                                    .addComponent(hingresoLabel1))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fechaField)
                                    .addComponent(hentradarefrigerioField)
                                    .addComponent(hingresoField, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hsalidarefrigerioLabel1)
                                    .addComponent(hsalidaLabel1)
                                    .addComponent(fechaLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hsalidaField, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                    .addComponent(hsalidarefrigerioField, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                    .addComponent(txtTardanza, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(rbPermiso, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                                .addGap(10, 10, 10)
                                .addComponent(rbJustificacion, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(idasistenciasField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(idpersonalLabel1))
                            .addComponent(idpersonalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(personalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nrodocumentoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(idasistenciasLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nrodocumentoLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hingresoLabel1)
                    .addComponent(hingresoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hsalidarefrigerioLabel1)
                    .addComponent(hsalidarefrigerioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hentradarefrigerioLabel1)
                    .addComponent(hentradarefrigerioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hsalidaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hsalidaLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaLabel1)
                    .addComponent(fechaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaLabel2)
                    .addComponent(txtTardanza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbPermiso)
                    .addComponent(rbJustificacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarDia)
                    .addComponent(newButton)
                    .addComponent(saveButton)
                    .addComponent(editButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        Guardar();
}//GEN-LAST:event_saveButtonActionPerformed

    private void btnRegistrarDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarDiaActionPerformed
        RegistroAsistencia();
}//GEN-LAST:event_btnRegistrarDiaActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        Nuevo();
}//GEN-LAST:event_newButtonActionPerformed

private void rbPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPermisoActionPerformed
    ActivarPermiso();
}//GEN-LAST:event_rbPermisoActionPerformed

private void rbJustificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbJustificacionActionPerformed
    ActivarJustificacion();
}//GEN-LAST:event_rbJustificacionActionPerformed

private void rbPermisoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbPermisoMouseClicked
    ActivarPermiso();
}//GEN-LAST:event_rbPermisoMouseClicked

private void rbJustificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbJustificacionMouseClicked
    ActivarJustificacion();
}//GEN-LAST:event_rbJustificacionMouseClicked

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked
        seleccionAsistencia();
    }//GEN-LAST:event_masterTableMouseClicked

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        Editar();
    }//GEN-LAST:event_editButtonActionPerformed
//
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarDia;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField fechaField;
    private javax.swing.JLabel fechaLabel1;
    private javax.swing.JLabel fechaLabel2;
    private javax.swing.JTextField hentradarefrigerioField;
    private javax.swing.JLabel hentradarefrigerioLabel1;
    private javax.swing.JTextField hingresoField;
    private javax.swing.JLabel hingresoLabel1;
    private javax.swing.JTextField hsalidaField;
    private javax.swing.JLabel hsalidaLabel1;
    private javax.swing.JTextField hsalidarefrigerioField;
    private javax.swing.JLabel hsalidarefrigerioLabel1;
    private javax.swing.JTextField idasistenciasField;
    private javax.swing.JLabel idasistenciasLabel1;
    private javax.swing.JTextField idpersonalField;
    private javax.swing.JLabel idpersonalLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField nrodocumentoField;
    private javax.swing.JLabel nrodocumentoLabel1;
    private javax.swing.JTextField personalField;
    private javax.swing.JRadioButton rbJustificacion;
    private javax.swing.JRadioButton rbPermiso;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextArea txtJustificacion;
    private javax.swing.JTextArea txtPermiso;
    private javax.swing.JTextField txtTardanza;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public void Nuevo() {
        btnRegistrarDia.setEnabled(false);
        oAsistencias = new Asistencias();
        list.add(oAsistencias);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));

        idasistenciasField.setEnabled(false);
        idpersonalField.setEnabled(false);
        idpersonalField.setText(idPersonal);
        nrodocumentoField.setEnabled(false);
        nrodocumentoField.setText(nrodocumento);
        personalField.setEnabled(false);
        personalField.setText(nomPersonal);
        fechaField.setEnabled(true);
        try {
            fechaField.setText("" + DateUtil.FechaActualString());
        } catch (ParseException ex) {
            //Logger.getLogger(ifAsistenciasManuales.class.getName()).log(Level.SEVERE, null, ex);
        }
        hingresoField.requestFocus();
        hingresoField.setText(ConstantesApp.HORA_ENTRADA);
        hsalidarefrigerioField.setText(ConstantesApp.HORA_SALIDA_REFRIGERIO);
        hentradarefrigerioField.setText(ConstantesApp.HORA_ENTRADA_REFRIGERIO);
        hsalidaField.setText(ConstantesApp.HORA_SALIDA);
        saveButton.setEnabled(true);
        txtTardanza.setText("0");
        txtTardanza.setEnabled(false);
    }

    private void Editar() {
        oAsistencias = new Asistencias();
        int row = masterTable.getSelectedRow();
        System.out.println("fila seleccionada " + row);
        oAsistencias = list.get(row);
        oAsistencias.setTardanza(0);
        txtTardanza.setText("0");
        txtTardanza.setEnabled(false);
        editButton.setEnabled(false);
        saveButton.setEnabled(true);
    }

    public void Guardar() {
        btnRegistrarDia.setEnabled(false);
        if (rbPermiso.isSelected() == true) {
            if (txtPermiso.getText() == null) {
                LogsUtil.Msg(oClass, "Debe Ingresar una descripcion del permiso que tiene la persona", "Atención", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else {
                if (txtPermiso.getText().trim().length() == 0) {
                    LogsUtil.Msg(oClass, "Debe Ingresar una descripcion del permiso que tiene la persona", "Atención", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
        }

        if (rbJustificacion.isSelected() == true) {
            if (txtJustificacion.getText() == null) {
                LogsUtil.Msg(oClass, "Debe Ingresar una descripcion de la justificación que tiene la persona", "Atención", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else {
                if (txtJustificacion.getText().trim().length() == 0) {
                    LogsUtil.Msg(oClass, "Debe Ingresar una descripcion de la justificación que tiene la persona", "Atención", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
        }

        int rpta = JOptionPane.showConfirmDialog(this, "Esta Seguro de Guardar la Asistencia", "Atención", JOptionPane.YES_NO_OPTION);
        if (rpta == 0) {
            try {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.persist(oAsistencias);
                    entityManager.getTransaction().commit();
                    entityManager.getTransaction().begin();
                } else {
                    entityManager.getTransaction().begin();
                    entityManager.persist(oAsistencias);
                    entityManager.getTransaction().commit();
                    entityManager.getTransaction().begin();
                }
            } catch (RollbackException rex) {
                rex.printStackTrace();
                entityManager.getTransaction().begin();
                List<org.adox.app.entities.Asistencias> merged = new ArrayList<org.adox.app.entities.Asistencias>(list.size());
                for (org.adox.app.entities.Asistencias a : list) {
                    merged.add(entityManager.merge(a));
                }
                list.clear();
                list.addAll(merged);
            }
        } else {
            LogsUtil.Show(oClass, "Cancelo la operacion");
        }
        Actualizar();
        fechaField.setEnabled(false);
        btnRegistrarDia.setEnabled(false);
        try {
            fechaField.setText("" + DateUtil.FechaActualString());
        } catch (Exception e) {
        }
    }

    private void Actualizar() {
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
        btnRegistrarDia.setEnabled(false);
        saveButton.setEnabled(false);
        txtPermiso.setText("");
        txtJustificacion.setText("");
    }

    private void RegistroAsistencia() {
        LogsUtil.Show(oClass, " ::: REGISTRO DE ASISTENCIA MANUAL :::  ");
        btnRegistrarDia.setEnabled(false);
        if (rbPermiso.isSelected() == true) {
            if (txtPermiso.getText() == null) {
                LogsUtil.Msg(oClass, "Debe Ingresar una descripcion del permiso que tiene la persona", "Atención", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else {
                if (txtPermiso.getText().trim().length() == 0) {
                    LogsUtil.Msg(oClass, "Debe Ingresar una descripcion del permiso que tiene la persona", "Atención", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
        }

        if (rbJustificacion.isSelected() == true) {
            if (txtJustificacion.getText() == null) {
                LogsUtil.Msg(oClass, "Debe Ingresar una descripcion de la justificación que tiene la persona", "Atención", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else {
                if (txtJustificacion.getText().trim().length() == 0) {
                    LogsUtil.Msg(oClass, "Debe Ingresar una descripcion de la justificación que tiene la persona", "Atención", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
        }
        int rpta = JOptionPane.showConfirmDialog(this, "Esta Seguro de Registrar la Asistencia de esta fecha : " + fechaField.getText(), "Atención", JOptionPane.YES_NO_OPTION);
        if (rpta == 0) {
            ActualizarReporteAsistencia();
        }
    }

    private void ActualizarReporteAsistencia() {
        String fechita = fechaField.getText().trim();
        String[] fechaSelecc = fechita.split("-");
        LogsUtil.Show(oClass, "año :  " + fechaSelecc[0]);
        LogsUtil.Show(oClass, "mes :  " + DateUtil.nombremes(Integer.parseInt(fechaSelecc[1])));
        LogsUtil.Show(oClass, "dia :  " + Integer.parseInt(fechaSelecc[2]));
        String querycito = "SELECT COUNT(*) FROM rptasistencias WHERE idPersonal = '" + idPersonal + "' AND Mes = '" + DateUtil.nombremes(Integer.parseInt(fechaSelecc[1])) + "' AND Ano = '" + fechaSelecc[0] + "'";
        LogsUtil.Show(oClass, "querycito :  " + querycito);
        qObtenerRegistroRpte = entityManager.createNativeQuery(querycito);
        Object contador = qObtenerRegistroRpte.getSingleResult();
        LogsUtil.Show(oClass, "contador :  " + contador.toString());
        entityManager.clear();
        if (Integer.parseInt(contador.toString().trim()) > 0) {
            actAsistencia();
        } else {
            regAsistencia();
            actAsistencia();
        }
    }

    private void regAsistencia() {
        String fechita = fechaField.getText().trim();
        String[] fechaSelecc = fechita.split("-");
        LogsUtil.Show(oClass, "año :  " + fechaSelecc[0]);
        LogsUtil.Show(oClass, "mes :  " + DateUtil.nombremes(Integer.parseInt(fechaSelecc[1])));
        LogsUtil.Show(oClass, "dia :  " + Integer.parseInt(fechaSelecc[2]));
        String Query = "call spObtenerDatosPersonal(" + idPersonal + ")";
        LogsUtil.Show(oClass, "Query spObtenerDatosPersonal :  " + Query);
        qObtenerDatosPersonal = entityManager.createNativeQuery("call spObtenerDatosPersonal(" + idPersonal + ")");
        Object Datos = qObtenerDatosPersonal.getSingleResult();
        LogsUtil.Show(oClass, "Datos :  " + Datos.toString());
        Object[] fila = Datos.toString().trim().split("-");
        Query = "INSERT INTO rptasistencias (Mes,Ano,idPersonal,Paterno,Materno,Nombres,Cargo,Asistencias,Inasistencias,Feriados) "
                + "VALUES ('" + DateUtil.nombremes(Integer.parseInt(fechaSelecc[1])) + "','" + fechaSelecc[0] + "'," + idPersonal + ",'" + fila[0].toString() + "', '" + fila[1].toString() + "','" + fila[2].toString() + "','" + fila[3].toString() + "','0','0','0')";
        LogsUtil.Show(oClass, "Query qRegistroRpte:  " + Query);
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        qRegistroRpte = entityManager.createNativeQuery(Query);
        int rpta = qRegistroRpte.executeUpdate();
        LogsUtil.Show(oClass, "rpta regAsistencia: " + rpta);
        if (rpta == 1) {
            JOptionPane.showMessageDialog(this, "Registro de Asistencia Exitosa");
        } else {
            JOptionPane.showMessageDialog(this, "Registro de Asistencia Fallo");
        }
        entityManager.getTransaction().commit();
    }

    private void actAsistencia() {
        String fechita = fechaField.getText().trim();
        String[] fechaSelecc = fechita.split("-");
        LogsUtil.Show(oClass, "año :  " + fechaSelecc[0]);
        LogsUtil.Show(oClass, "mes :  " + DateUtil.nombremes(Integer.parseInt(fechaSelecc[1])));
        LogsUtil.Show(oClass, "dia :  " + Integer.parseInt(fechaSelecc[2]));
        String Query = "UPDATE rptasistencias SET d" + Integer.parseInt(fechaSelecc[2]) + "='1' "
                + "WHERE idPersonal = '" + idPersonal + "' AND Mes = '" + DateUtil.nombremes(Integer.parseInt(fechaSelecc[1])) + "' AND Ano = '" + fechaSelecc[0] + "'";
        LogsUtil.Show(oClass, "Query :  " + Query);
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        qObtenerActualizaRptAsistencia = entityManager.createNativeQuery(Query);
        int rpta = qObtenerActualizaRptAsistencia.executeUpdate();
        entityManager.getTransaction().commit();
        LogsUtil.Show(oClass, "rpta actAsistencia : " + rpta);
        if (rpta == 1) {
            JOptionPane.showMessageDialog(this, "Actualización de Asistencia Exitosa");
        } else {
            JOptionPane.showMessageDialog(this, "Actualización de Asistencia Fallo");
        }
    }

    private void ActivarPermiso() {
        if (txtJustificacion.getText() != null) {
            txtPermiso.setEditable(true);
            txtJustificacion.setEditable(false);
        } else {
            txtPermiso.setEditable(true);
            txtJustificacion.setEditable(false);
            txtJustificacion.setText(null);
        }
    }

    private void ActivarJustificacion() {
        if (txtPermiso.getText() != null) {
            txtJustificacion.setEditable(true);
            txtPermiso.setEditable(false);
        } else {
            txtJustificacion.setEditable(true);
            txtPermiso.setEditable(false);
            txtPermiso.setText(null);
        }
    }

    private void seleccionAsistencia() {
        txtTardanza.setEnabled(false);
        btnRegistrarDia.setEnabled(true);
        editButton.setEnabled(true);
        if (txtPermiso.getText().equals("")) {
            rbJustificacion.setSelected(true);
        } else {
            rbPermiso.setSelected(true);
        }
    }

    public List<Asistencias> getList() {
        return list;
    }

    public void setList(List<Asistencias> list) {
        this.list = list;
    }
}
