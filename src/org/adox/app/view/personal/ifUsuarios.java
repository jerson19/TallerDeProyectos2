package org.adox.app.view.personal;

import java.awt.EventQueue;
import java.beans.Beans;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import org.adox.app.common.ConstantesApp;
import org.adox.app.entities.Usuario;
import org.adox.app.util.LogsUtil;
import org.adox.app.util.ProgressUtil;
import org.adox.app.view.frmPrincipal;
import org.apache.log4j.Logger;

/**
 * @author ADOLFO
 ifUsuarios.java
 Created on 12/06/2011, 04:06:08 PM
 */
public class ifUsuarios extends JPanel {

    static Logger oClass = Logger.getLogger("ifUsuarios");
    private EntityManager entityManager;
    private Query query;
    private List<Usuario> list;
    private Usuario oUsuario;
    String idPersonal;
    //"SELECT u FROM Usuario u WHERE u.idpersonal=" + idPersonal

    public ifUsuarios() {
        initComponents();
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
        _init();
        ProgressUtil.stop();
    }

    public ifUsuarios(String Personal) {
        _initPU();
        initComponents();
        idPersonal = Personal;
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
        _init();
        ProgressUtil.stop();
    }

    private void _initPU() {
        entityManager = frmPrincipal.oAplicacionDao.getObtenerConexionPU();
    }

    private void _Persistencia() {
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT u FROM Usuario u WHERE u.idpersonal=" + idPersonal);
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
    }

    private void _init() {
        RefrescarTabla();
        activaGuardar(false);
        habilitaCampos(false);
    }

    private void habilitaCampos(boolean valor) {
        usuarioField.setEnabled(valor);
        claveField.setEnabled(valor);
    }

    private void limpiarCampos() {
        usuarioField.setText("");
        claveField.setText("");
    }

    private void activaGuardar(boolean valor) {
        saveButton.setEnabled(valor);
        editButton.setEnabled(!valor);
        newButton.setEnabled(!valor);
        deleteButton.setEnabled(!valor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        usuarioLabel = new javax.swing.JLabel();
        claveLabel = new javax.swing.JLabel();
        usuarioField = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        claveLabel1 = new javax.swing.JLabel();
        idPersonalField = new javax.swing.JTextField();
        btnRoles = new javax.swing.JButton();
        claveLabel2 = new javax.swing.JLabel();
        empresaField = new javax.swing.JTextField();
        estadoField = new javax.swing.JTextField();
        claveLabel3 = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        claveField = new javax.swing.JPasswordField();

        FormListener formListener = new FormListener();

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${list}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idusuario}"));
        columnBinding.setColumnName("Idusuario");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${usuario}"));
        columnBinding.setColumnName("Usuario");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idpersonal}"));
        columnBinding.setColumnName("Idpersonal");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${estado}"));
        columnBinding.setColumnName("Estado");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        masterTable.addMouseListener(formListener);
        masterScrollPane.setViewportView(masterTable);

        usuarioLabel.setText("Usuario:");

        claveLabel.setText("Clave:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.usuario}"), usuarioField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), usuarioField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_actualizar.png"))); // NOI18N
        editButton.setText("Editar");
        editButton.setName("editButton"); // NOI18N
        editButton.addActionListener(formListener);

        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_agregar.png"))); // NOI18N
        newButton.setText("Nuevo");
        newButton.setName("newButton"); // NOI18N
        newButton.addActionListener(formListener);

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_guardar.PNG"))); // NOI18N
        saveButton.setText("Guardar");
        saveButton.setName("saveButton"); // NOI18N
        saveButton.addActionListener(formListener);

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_elimina.png"))); // NOI18N
        deleteButton.setText("Eliminar");
        deleteButton.setName("deleteButton"); // NOI18N
        deleteButton.addActionListener(formListener);

        claveLabel1.setText("Personal:");
        claveLabel1.setName("claveLabel1"); // NOI18N

        idPersonalField.setEditable(false);
        idPersonalField.setName("idPersonalField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.idpersonal}"), idPersonalField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        btnRoles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/btn_Vista_Key.png"))); // NOI18N
        btnRoles.setText("Roles");
        btnRoles.setName("btnRoles"); // NOI18N
        btnRoles.addActionListener(formListener);

        claveLabel2.setText("Empresa:");
        claveLabel2.setName("claveLabel2"); // NOI18N

        empresaField.setEditable(false);
        empresaField.setName("empresaField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.idempresa}"), empresaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        estadoField.setEditable(false);
        estadoField.setName("estadoField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.estado}"), estadoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        claveLabel3.setText("Estado:");
        claveLabel3.setName("claveLabel3"); // NOI18N

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_actualizar.png"))); // NOI18N
        refreshButton.setText("Actualizar");
        refreshButton.setName("refreshButton"); // NOI18N
        refreshButton.addActionListener(formListener);

        claveField.setName("claveField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.clave}"), claveField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnRoles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(newButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(claveLabel1)
                            .addComponent(usuarioLabel)
                            .addComponent(claveLabel))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(claveField, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                                    .addComponent(usuarioField, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(refreshButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idPersonalField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(claveLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(empresaField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(claveLabel3)
                                .addGap(38, 38, 38)
                                .addComponent(estadoField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usuarioLabel)
                            .addComponent(usuarioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(claveLabel)
                            .addComponent(claveField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(claveLabel1)
                    .addComponent(idPersonalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(empresaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(claveLabel3)
                    .addComponent(estadoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(claveLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(editButton)
                    .addComponent(deleteButton)
                    .addComponent(newButton)
                    .addComponent(btnRoles))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.MouseListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == editButton) {
                ifUsuarios.this.editButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                ifUsuarios.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == saveButton) {
                ifUsuarios.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                ifUsuarios.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == btnRoles) {
                ifUsuarios.this.btnRolesActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                ifUsuarios.this.refreshButtonActionPerformed(evt);
            }
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == masterTable) {
                ifUsuarios.this.masterTableMouseClicked(evt);
            }
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
        }
    }// </editor-fold>//GEN-END:initComponents

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        Editar();
}//GEN-LAST:event_editButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        Nuevo();
}//GEN-LAST:event_newButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        Guardar();
}//GEN-LAST:event_saveButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        Eliminar();
}//GEN-LAST:event_deleteButtonActionPerformed

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked
    }//GEN-LAST:event_masterTableMouseClicked

    private void btnRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRolesActionPerformed
        Roles();
    }//GEN-LAST:event_btnRolesActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        Actualizar();
    }//GEN-LAST:event_refreshButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRoles;
    private javax.swing.JPasswordField claveField;
    private javax.swing.JLabel claveLabel;
    private javax.swing.JLabel claveLabel1;
    private javax.swing.JLabel claveLabel2;
    private javax.swing.JLabel claveLabel3;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField empresaField;
    private javax.swing.JTextField estadoField;
    private javax.swing.JTextField idPersonalField;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField usuarioField;
    private javax.swing.JLabel usuarioLabel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
/* ABRIR MARCOS INTERNOS */
    private int xSigMarco;
    private int ySigMarco;
    private int distanciaEntreMarcos;

    private void abrirMarcoInterno(JInternalFrame oJInternalFrame) {
        oJInternalFrame.setLocation(xSigMarco, ySigMarco);
        oJInternalFrame.setVisible(true);
        frmPrincipal.contenedorIf.add(oJInternalFrame);
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

        if (xSigMarco + oJInternalFrame.getWidth() > frmPrincipal.contenedorIf.getWidth()) {
            xSigMarco = 0;
        }
        if (ySigMarco + oJInternalFrame.getHeight() > frmPrincipal.contenedorIf.getHeight()) {
            ySigMarco = 0;
        }
        repaint();
    }

//METODO QUE DEVUELVE UN VALOR BOOLEAN PARA SABER SI UN JINTERNALFRAME ESTA ABIERTO O NO
    public boolean estacerrado(Object obj) {
        JInternalFrame[] activos = frmPrincipal.contenedorIf.getAllFrames();
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
    //

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new ifUsuarios());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    //METODOS DE LA APLICACION

    private void personalizarJtable() {
        masterTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        masterTable.getColumnModel().getColumn(0).setResizable(true);
        masterTable.getColumnModel().getColumn(0).setPreferredWidth(90);
        masterTable.getColumnModel().getColumn(1).setResizable(true);
        masterTable.getColumnModel().getColumn(1).setPreferredWidth(350);
        masterTable.getColumnModel().getColumn(2).setResizable(true);
        masterTable.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    // METODOS DEL MANTENIMIENTO
    public void Nuevo() {
        oUsuario = new Usuario();
        list.add(oUsuario);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
        habilitaCampos(true);
        limpiarCampos();
        activaGuardar(true);
        idPersonalField.setText(idPersonal);
        estadoField.setText("1");
        empresaField.setText(ConstantesApp.ID_EMPRESA);
    }

    private void Editar() {
        habilitaCampos(true);
        activaGuardar(true);
        oUsuario = new Usuario();
        int row = masterTable.getSelectedRow();
        System.out.println("fila seleccionada " + row);
        oUsuario = list.get(row);
    }

    public void Guardar() {
        if (usuarioField.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "INGRESE USUARIO");
            return;
        }
        if (claveField.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "INGRESE CLAVE");
            return;
        }
        int rpta = JOptionPane.showConfirmDialog(this, "Esta Seguro de Guardar el Registro", "Atención", JOptionPane.YES_NO_OPTION);
        if (rpta == 0) {
            try {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.persist(oUsuario);
                    entityManager.getTransaction().commit();
                    entityManager.getTransaction().begin();
                } else {
                    entityManager.getTransaction().begin();
                    entityManager.persist(oUsuario);
                    entityManager.getTransaction().commit();
                    entityManager.getTransaction().begin();
                }
            } catch (RollbackException rex) {
                rex.printStackTrace();
                entityManager.getTransaction().begin();
                List<Usuario> merged = new ArrayList<Usuario>(list.size());
                for (Usuario a : list) {
                    merged.add(entityManager.merge(a));
                }
                list.clear();
                list.addAll(merged);
            }
        } else {
            System.out.println("Cancelo la operacion");
        }
        Actualizar();
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
        limpiarCampos();
        activaGuardar(false);
        habilitaCampos(false);
    }

    private void Eliminar() {
        if (usuarioField.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "SELECCIONE USUARIO");
            return;
        }
        int rpta = JOptionPane.showConfirmDialog(this, "Esta Seguro de Eliminar el Registro", "Atención", JOptionPane.YES_NO_OPTION);
        if (rpta == 0) {
            int[] selected = masterTable.getSelectedRows();
            List<Usuario> toRemove = new ArrayList<org.adox.app.entities.Usuario>(selected.length);
            for (int idx = 0; idx < selected.length; idx++) {
                Usuario a = list.get(masterTable.convertRowIndexToModel(selected[idx]));
                toRemove.add(a);
                entityManager.remove(a);
            }
            list.removeAll(toRemove);
            //GUARDAR            
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().commit();
                entityManager.getTransaction().begin();
            } else {
                entityManager.getTransaction().begin();
                entityManager.getTransaction().commit();
                entityManager.getTransaction().begin();
            }
        } else {
            System.out.println("Cancelo la operacion");
        }
    }

    private void RefrescarTabla() {
        _Persistencia();
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idusuario}"));
        columnBinding.setColumnName("ID");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${usuario}"));
        columnBinding.setColumnName("USUARIO");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${estado}"));
        columnBinding.setColumnName("ESTADO");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterScrollPane.setViewportView(masterTable);
        bindingGroup.bind();
        personalizarJtable();
    }

    private void Roles() {
        ProgressUtil oProgressUtil = new ProgressUtil();
        oProgressUtil.load();
        Thread p = new Thread() {

            public void run() {
                abrirRoles();
            }
        };
        p.start();
    }
    JInternalFrame gRoles;

    private void abrirRoles() {
        if (idPersonal.equals("")) {
            JOptionPane.showMessageDialog(this, "Seleccione un Usuario", "Atención", JOptionPane.INFORMATION_MESSAGE);
            ProgressUtil.stop();
            return;
        }
        if (usuarioField.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "SELECCIONE USUARIO");
            ProgressUtil.stop();
            return;
        }
        if (estacerrado(gRoles)) {
            gRoles = new JInternalFrame("::: GESTIÓN DE ROLES POR USUARIO :::");
            int row = masterTable.getSelectedRow();
            System.out.println("fila seleccionada " + row);
            System.out.println("id Usuario " + list.get(row).getIdusuario());
            ifRolUsuario obj = new ifRolUsuario(list.get(row).getIdusuario().toString());
            gRoles.add(obj);
            gRoles.setIconifiable(true);
            gRoles.setClosable(true);
            gRoles.pack();
            abrirMarcoInterno(gRoles);
        } else {
            ProgressUtil.stop();
            JOptionPane.showMessageDialog(this, ConstantesApp.MENSAJE_FORMULARIO_ABIERTO);
        }
    }

    public List<Usuario> getList() {
        return list;
    }

    public void setList(List<Usuario> list) {
        this.list = list;
    }
}
