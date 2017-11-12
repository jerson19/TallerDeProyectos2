package org.adox.app.view.personal;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import org.adox.app.entities.Rol;
import org.adox.app.util.ProgressUtil;
import org.adox.app.view.frmPrincipal;

/**
 * @author ADOLFO
 * ifRoles.java
 * Created on 14/06/2011, 11:16:42 AM
 */
public class ifRoles extends JPanel {

    private EntityManager entityManager;
    private Query query;
    private List<Rol> list;
    private Rol oRol;

    public ifRoles() {
        _initPU();
        initComponents();
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
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT u FROM Rol");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
    }

    private void _init() {
        RefrescarTabla();
        activaGuardar(false);
        habilitaCampos(false);
    }

    private void habilitaCampos(boolean valor) {
        rolField.setEnabled(valor);
        descripcionField.setEnabled(valor);
    }

    private void limpiarCampos() {
        rolField.setText("");
        descripcionField.setText("");
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
        idrolLabel = new javax.swing.JLabel();
        rolLabel = new javax.swing.JLabel();
        descripcionLabel = new javax.swing.JLabel();
        estadoLabel = new javax.swing.JLabel();
        idrolField = new javax.swing.JTextField();
        rolField = new javax.swing.JTextField();
        descripcionField = new javax.swing.JTextField();
        estadoField = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${list}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idrol}"));
        columnBinding.setColumnName("Idrol");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${rol}"));
        columnBinding.setColumnName("Rol");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descripcion}"));
        columnBinding.setColumnName("Descripcion");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${estado}"));
        columnBinding.setColumnName("Estado");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        masterScrollPane.setViewportView(masterTable);

        idrolLabel.setText("Idrol:");

        rolLabel.setText("Rol:");

        descripcionLabel.setText("Descripcion:");

        estadoLabel.setText("Estado:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.idrol}"), idrolField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), idrolField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.rol}"), rolField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), rolField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.descripcion}"), descripcionField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), descripcionField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.estado}"), estadoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), estadoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_editar.PNG"))); // NOI18N
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

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_actualizar.png"))); // NOI18N
        refreshButton.setText("Actualizar");
        refreshButton.setName("refreshButton"); // NOI18N
        refreshButton.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idrolLabel)
                            .addComponent(rolLabel)
                            .addComponent(descripcionLabel)
                            .addComponent(estadoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idrolField, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                            .addComponent(rolField, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                            .addComponent(descripcionField, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                            .addComponent(estadoField, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)))
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(newButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idrolLabel)
                    .addComponent(idrolField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rolLabel)
                    .addComponent(rolField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcionLabel)
                    .addComponent(descripcionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estadoLabel)
                    .addComponent(estadoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(editButton)
                    .addComponent(deleteButton)
                    .addComponent(newButton)
                    .addComponent(refreshButton))
                .addContainerGap())
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == editButton) {
                ifRoles.this.editButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                ifRoles.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == saveButton) {
                ifRoles.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                ifRoles.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                ifRoles.this.refreshButtonActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed

        Editar();     }//GEN-LAST:event_editButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed

        Nuevo();     }//GEN-LAST:event_newButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        Guardar();     }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed

        Eliminar();     }//GEN-LAST:event_deleteButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField descripcionField;
    private javax.swing.JLabel descripcionLabel;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField estadoField;
    private javax.swing.JLabel estadoLabel;
    private javax.swing.JTextField idrolField;
    private javax.swing.JLabel idrolLabel;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTextField rolField;
    private javax.swing.JLabel rolLabel;
    private javax.swing.JButton saveButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    //METODOS DE LA APLICACION
    private void personalizarJtable() {
        masterTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        masterTable.getColumnModel().getColumn(0).setResizable(true);
        masterTable.getColumnModel().getColumn(0).setPreferredWidth(90);
        masterTable.getColumnModel().getColumn(1).setResizable(true);
        masterTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        masterTable.getColumnModel().getColumn(2).setResizable(true);
        masterTable.getColumnModel().getColumn(2).setPreferredWidth(300);
    }

    // METODOS DEL MANTENIMIENTO
    public void Nuevo() {
        oRol = new Rol();
        list.add(oRol);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
        habilitaCampos(true);
        limpiarCampos();
        activaGuardar(true);
    }

    private void Editar() {
        habilitaCampos(true);
        activaGuardar(true);
        oRol = new Rol();
        int row = masterTable.getSelectedRow();
        System.out.println("fila seleccionada " + row);
        oRol = list.get(row);
    }

    public void Guardar() {
        int rpta = JOptionPane.showConfirmDialog(this, "Esta Seguro de Guardar el Registro", "Atención", JOptionPane.YES_NO_OPTION);
        if (rpta == 0) {
            try {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.persist(oRol);
                    entityManager.getTransaction().commit();
                    entityManager.getTransaction().begin();
                } else {
                    entityManager.getTransaction().begin();
                    entityManager.persist(oRol);
                    entityManager.getTransaction().commit();
                    entityManager.getTransaction().begin();
                }
            } catch (RollbackException rex) {
                rex.printStackTrace();
                entityManager.getTransaction().begin();
                List<org.adox.app.entities.Rol> merged = new ArrayList<org.adox.app.entities.Rol>(list.size());
                for (org.adox.app.entities.Rol a : list) {
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
        int rpta = JOptionPane.showConfirmDialog(this, "Esta Seguro de Eliminar el Registro", "Atención", JOptionPane.YES_NO_OPTION);
        if (rpta == 0) {
            int[] selected = masterTable.getSelectedRows();
            List<org.adox.app.entities.Rol> toRemove = new ArrayList<org.adox.app.entities.Rol>(selected.length);
            for (int idx = 0; idx < selected.length; idx++) {
                Rol a = list.get(masterTable.convertRowIndexToModel(selected[idx]));
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
        columnBinding.setColumnName("Codigo");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${usuario}"));
        columnBinding.setColumnName("Usuario");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${clave}"));
        columnBinding.setColumnName("Clave");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterScrollPane.setViewportView(masterTable);
        bindingGroup.bind();
        personalizarJtable();
    }

    public List<Rol> getList() {
        return list;
    }

    public void setList(List<Rol> list) {
        this.list = list;
    }
}
