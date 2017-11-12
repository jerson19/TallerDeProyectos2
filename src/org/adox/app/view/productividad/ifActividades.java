package org.adox.app.view.productividad;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import org.adox.app.entities.Actividades;
import org.adox.app.util.LogsUtil;
import org.adox.app.util.ProgressUtil;
import org.adox.app.view.frmPrincipal;
import org.apache.log4j.Logger;

/**
 * @author ADOLFO
 * ifActividades.java
 * Created on 31/08/2011, 10:19:06 AM
 */
public class ifActividades extends JPanel {

    static Logger oClass = Logger.getLogger("ifActividades");
    private EntityManager entityManager;
    private Query query;
    private List<Actividades> list;
    private Actividades oActividades;
    String Nombre = "-?-";

    public ifActividades() {
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
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT a FROM Actividades a WHERE a.actividad LIKE  '%" + Nombre + "%' order by a.actividad");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
    }

    private void _init() {
        RefrescarTabla();
        limpiarCampos();
        activaGuardar(false);
        habilitaCampos(false);
    }

    private void habilitaCampos(boolean valor) {
        actividadField.setEnabled(valor);
    }

    private void limpiarCampos() {
        actividadField.setText("");
    }

    private void activaGuardar(boolean valor) {
        saveButton.setEnabled(valor);
        editButton.setEnabled(!valor);
        newButton.setEnabled(!valor);
        deleteButton.setEnabled(!valor);
    }

    /** This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        actividadLabel = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        actividadField = new javax.swing.JTextField();
        refreshButton1 = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        setBackground(new java.awt.Color(51, 51, 51));

        actividadLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        actividadLabel.setForeground(new java.awt.Color(255, 255, 0));
        actividadLabel.setText("Actividad:");

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/btn_remover.png"))); // NOI18N
        deleteButton.setText("Eliminar");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, new javax.swing.JTable(), org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_agregar.png"))); // NOI18N
        newButton.setText("Nuevo");
        newButton.setName("newButton"); // NOI18N
        newButton.addActionListener(formListener);

        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_editar.PNG"))); // NOI18N
        editButton.setText("Editar");
        editButton.setName("editButton"); // NOI18N
        editButton.addActionListener(formListener);

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_guardar.PNG"))); // NOI18N
        saveButton.setText("Guardar");
        saveButton.setName("saveButton"); // NOI18N
        saveButton.addActionListener(formListener);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setName("btnSalir"); // NOI18N
        btnSalir.addActionListener(formListener);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/ma_buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setName("btnBuscar"); // NOI18N
        btnBuscar.addActionListener(formListener);

        txtNombre.setName("txtNombre"); // NOI18N
        txtNombre.addActionListener(formListener);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("Actividad:");
        jLabel1.setName("jLabel1"); // NOI18N

        masterScrollPane.setName("masterScrollPane"); // NOI18N

        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        masterTable.setName("masterTable"); // NOI18N

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${list}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idActividad}"));
        columnBinding.setColumnName("Id Actividad");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${actividad}"));
        columnBinding.setColumnName("Actividad");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterScrollPane.setViewportView(masterTable);

        actividadField.setName("actividadField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.actividad}"), actividadField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        refreshButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_actualizar.png"))); // NOI18N
        refreshButton1.setText("Actualizar");
        refreshButton1.setName("refreshButton1"); // NOI18N
        refreshButton1.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar))
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalir)
                            .addComponent(actividadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(refreshButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(actividadField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actividadField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actividadLabel))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(newButton)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(editButton)
                    .addComponent(refreshButton1)
                    .addComponent(saveButton))
                .addContainerGap())
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == deleteButton) {
                ifActividades.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                ifActividades.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == editButton) {
                ifActividades.this.editButtonActionPerformed(evt);
            }
            else if (evt.getSource() == saveButton) {
                ifActividades.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == btnSalir) {
                ifActividades.this.btnSalirActionPerformed(evt);
            }
            else if (evt.getSource() == btnBuscar) {
                ifActividades.this.btnBuscarActionPerformed(evt);
            }
            else if (evt.getSource() == txtNombre) {
                ifActividades.this.txtNombreActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton1) {
                ifActividades.this.refreshButton1ActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        Eliminar();
    }//GEN-LAST:event_deleteButtonActionPerformed

private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
    Nuevo();
}//GEN-LAST:event_newButtonActionPerformed

private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
    Editar();
}//GEN-LAST:event_editButtonActionPerformed

private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
    Guardar();
}//GEN-LAST:event_saveButtonActionPerformed

private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    Salir();
}//GEN-LAST:event_btnSalirActionPerformed

private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    Buscar();
}//GEN-LAST:event_btnBuscarActionPerformed

private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
    Buscar();
}//GEN-LAST:event_txtNombreActionPerformed

    private void refreshButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButton1ActionPerformed
        Actualizar();
    }//GEN-LAST:event_refreshButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actividadField;
    private javax.swing.JLabel actividadLabel;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JButton refreshButton1;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField txtNombre;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    //METODOS DE LA APLICACION
    private void personalizarJtable() {
        masterTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        masterTable.getColumnModel().getColumn(0).setResizable(true);
        masterTable.getColumnModel().getColumn(0).setPreferredWidth(90);
        masterTable.getColumnModel().getColumn(1).setResizable(true);
        masterTable.getColumnModel().getColumn(1).setPreferredWidth(550);
    }

    // METODOS DEL MANTENIMIENTO
    public void Nuevo() {
        actividadField.requestFocus();
        oActividades = new Actividades();
        list.add(oActividades);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
        habilitaCampos(true);
        limpiarCampos();
        activaGuardar(true);
    }

    private void Editar() {
        if (actividadField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Seleccione una Actividad", "Atención", JOptionPane.INFORMATION_MESSAGE);
            ProgressUtil.stop();
            return;
        }
        habilitaCampos(true);
        activaGuardar(true);
        oActividades = new Actividades();
        int row = masterTable.getSelectedRow();
        System.out.println("fila seleccionada " + row);
        oActividades = list.get(row);
    }

    public void Guardar() {
        if (actividadField.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "INGRESE DESCRIPCIÓN DE LA ACTIVIDAD");
            return;
        }
        actividadField.setText(actividadField.getText().trim().toUpperCase());
        int rpta = JOptionPane.showConfirmDialog(this, "Esta Seguro de Guardar el Registro", "Atención", JOptionPane.YES_NO_OPTION);
        if (rpta == 0) {
            try {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.persist(oActividades);
                    entityManager.getTransaction().commit();
                    entityManager.getTransaction().begin();
                } else {
                    entityManager.getTransaction().begin();
                    entityManager.persist(oActividades);
                    entityManager.getTransaction().commit();
                    entityManager.getTransaction().begin();
                }
            } catch (RollbackException rex) {
                rex.printStackTrace();
                entityManager.getTransaction().begin();
                List<org.adox.app.entities.Actividades> merged = new ArrayList<org.adox.app.entities.Actividades>(list.size());
                for (org.adox.app.entities.Actividades a : list) {
                    merged.add(entityManager.merge(a));
                }
                list.clear();
                list.addAll(merged);
            }
        } else {
            LogsUtil.Show(oClass, "Cancelo la operacion");
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
        if (actividadField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Seleccione una Actividad", "Atención", JOptionPane.INFORMATION_MESSAGE);
            ProgressUtil.stop();
            return;
        }
        int rpta = JOptionPane.showConfirmDialog(this, "Esta Seguro de Eliminar el Registro", "Atención", JOptionPane.YES_NO_OPTION);
        if (rpta == 0) {
            int[] selected = masterTable.getSelectedRows();
            List<org.adox.app.entities.Actividades> toRemove = new ArrayList<org.adox.app.entities.Actividades>(selected.length);
            for (int idx = 0; idx < selected.length; idx++) {
                org.adox.app.entities.Actividades a = list.get(masterTable.convertRowIndexToModel(selected[idx]));
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
            actividadField.setText("");
            JOptionPane.showMessageDialog(this, "REGISTRO ELIMINADO EXITOSAMENTE");
        } else {
            System.out.println("Cancelo la operacion");
        }
    }

    private void Buscar() {
        ProgressUtil oProgressUtil = new ProgressUtil();
        oProgressUtil.load();
        repaint();
        Thread p = new Thread() {

            @Override
            public void run() {
                BuscarImpl();
            }
        };
        p.start();
    }

    private void BuscarImpl() {
        Nombre = txtNombre.getText() == null ? "" : txtNombre.getText().trim();
        RefrescarTabla();
        habilitaCampos(false);
        ProgressUtil.stop();
    }

    private void RefrescarTabla() {
        _Persistencia();
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idActividad}"));
        columnBinding.setColumnName("Código");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${actividad}"));
        columnBinding.setColumnName("Actividad");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterScrollPane.setViewportView(masterTable);
        bindingGroup.bind();
        personalizarJtable();
    }

    private void Salir() {
        list = null;
        entityManager.close();
        this.removeAll();
        frmPrincipal.gActividades.dispose();
    }

    public List<Actividades> getList() {
        return list;
    }

    public void setList(List<Actividades> list) {
        this.list = list;
    }
}
