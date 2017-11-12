package org.adox.app.view.personal;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import jxl.Sheet;
import jxl.Workbook;
import org.adox.app.entities.Personal;
import org.adox.app.util.LogsUtil;
import org.adox.app.util.ProgressUtil;
import org.adox.app.view.frmPrincipal;
import org.apache.log4j.Logger;

/**
 * @author ADOLFO
 * frmSubirAsistenciasManuales.java
 * Created on 21/03/2012, 06:10:43 PM
 */
public class frmRegistroPersonalManual extends javax.swing.JInternalFrame {

    static Logger oClass = Logger.getLogger("frmRegistroPersonalManual");
    String idUsuario;

    public frmRegistroPersonalManual(String Usuario) {
        initComponents();
        idUsuario = Usuario;
        _init();
    }

    frmRegistroPersonalManual() {
        initComponents();
        _init();
    }

    private void _init() {
        btnProcesar.setEnabled(false);
        txtRuta.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        btnExaminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResumen = new javax.swing.JTextArea();
        btnProcesar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("::: REGISTRO DE PERSONAL MANUAL :::"); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/adox.png"))); // NOI18N

        jLabel1.setText("Ruta Archivo :");
        jLabel1.setName("jLabel1"); // NOI18N

        txtRuta.setName("txtRuta"); // NOI18N

        btnExaminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/m_buscar.PNG"))); // NOI18N
        btnExaminar.setName("btnExaminar"); // NOI18N
        btnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        txtResumen.setColumns(20);
        txtResumen.setRows(5);
        txtResumen.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 1, true), "::: Resumen :::"));
        txtResumen.setName("txtResumen"); // NOI18N
        jScrollPane1.setViewportView(txtResumen);

        btnProcesar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/btn_play.png"))); // NOI18N
        btnProcesar.setText("Procesar");
        btnProcesar.setName("btnProcesar"); // NOI18N
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExaminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProcesar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnExaminar))
                    .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarActionPerformed
        examinar();
    }//GEN-LAST:event_btnExaminarActionPerformed

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        procesar();
    }//GEN-LAST:event_btnProcesarActionPerformed
    /*Metodos*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExaminar;
    private javax.swing.JButton btnProcesar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtResumen;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables
    JFileChooser chooser;

    private void examinar() {
        ProgressUtil oProgressUtil = new ProgressUtil();
        oProgressUtil.load();
        Thread p = new Thread() {

            public void run() {
                examinarImpl();
            }
        };
        p.start();
    }

    private void examinarImpl() {
        LogsUtil.Show(oClass, "Examinar");
        txtRuta.setText("");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formato ADOX ", "xls");
        chooser = new JFileChooser();
        chooser.setFileFilter(filtro);
        chooser.setCurrentDirectory(new File("c:/"));
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            String path = file.getAbsolutePath();
            LogsUtil.Show(oClass, "path " + path);
            if ((path == null ? "" : path.trim()).length() > 0) {
                txtRuta.setText(path);
            } else {
                LogsUtil.Msg(oClass, "Seleccione Plantilla", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            }
            btnProcesar.setEnabled(true);
        } else {
            btnProcesar.setEnabled(false);
        }
        ProgressUtil.stop();
    }

    private void procesar() {
        ProgressUtil oProgressUtil = new ProgressUtil();
        oProgressUtil.load();
        Thread p = new Thread() {

            public void run() {
                procesarImpl();
            }
        };
        p.start();
    }
    List<Personal> listaMovPersonal;

    private void procesarImpl() {
        LogsUtil.Show(oClass, "procesar");
        listaMovPersonal = new ArrayList<Personal>();
        try {
            LogsUtil.Show(oClass, "::: INFORMACION DE LA PLANTILLA :::");
            Workbook archivoExcel = Workbook.getWorkbook(new File(txtRuta.getText()));
            LogsUtil.Show(oClass, "Número de Hojas \t:" + archivoExcel.getNumberOfSheets());

            for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++) {
                Sheet hoja = archivoExcel.getSheet(sheetNo);
                int numColumnas = hoja.getColumns();
                int numFilas = hoja.getRows();
                String data;
                LogsUtil.Show(oClass, "Nombre de la Hoja \t:" + archivoExcel.getSheet(sheetNo).getName());
                for (int fila = 0; fila < numFilas; fila++) { // Recorre cada fila de la hoja
                    /*for (int columna = 0; columna < numColumnas; columna++) { // Recorre cada columna de la hoja                                                    
                    data = hoja.getCell(columna, fila).getContents();
                    System.out.print(data + " ");
                    }*/
                    String dni = (hoja.getCell(0, fila).getContents() + "").trim().toUpperCase();
                    String nombre = (hoja.getCell(1, fila).getContents() + "").trim().toUpperCase();
                    String apepat = (hoja.getCell(2, fila).getContents() + "").trim().toUpperCase();
                    String apemat = (hoja.getCell(3, fila).getContents() + "").trim().toUpperCase();
                    //String fechanacimiento = (hoja.getCell(4, fila).getContents() + "").trim();
                    //String sexo = (hoja.getCell(5, fila).getContents() + "").trim().toUpperCase();
                    String direccion = (hoja.getCell(4, fila).getContents() + "").trim().toUpperCase();

                    /*if (dni.length() > 0 || nombre.length() > 0 || apepat.length() > 0
                            || apemat.length() > 0) {*/
//                        LogsUtil.Show(oClass, "\n :::: RESUMEN ::::\n"
//                                + " dni : " + dni + " nombre : " + nombre + " apepat : " + apepat + " "
//                                + " apemat : " + apemat + " fechanacimiento  " + fechanacimiento + "   sexo : " + sexo + " direccion : " + direccion + "\n "
//                                + "::::::::: FIN RESUMEN ::::::::::::");
                        LogsUtil.Show(oClass, "\n :::: RESUMEN ::::\n"
                                + " dni : " + dni + " nombre : " + nombre + " apepat : " + apepat + " "
                                + " apemat : " + apemat + " direccion : " + direccion + "\n "
                                + "::::::::: FIN RESUMEN ::::::::::::");
                        actualizaMovimientoPersonal(fila, dni, nombre, apepat, apemat, direccion);
                    //}
                }
            }
            registraPersonal();
        } catch (Exception ioe) {
            System.out.println("KE PASO "+ioe.getMessage());
            ioe.printStackTrace();
        }
        LogsUtil.Msg(oClass, "Proceso terminado, verificar resumen", "Atencion", JOptionPane.INFORMATION_MESSAGE);
        ProgressUtil.stop();
    }

    private void actualizaMovimientoPersonal(int fila, String dni, String nombre, String apepat, String apemat, String direccion) {
        LogsUtil.Show(oClass, ":: OBTENIENDO DATOS");
        try {
            Personal oPersonal = new Personal();

            oPersonal.setNrodocumento(dni);
            oPersonal.setTipodocumento(1);
            oPersonal.setNombre(nombre);
            oPersonal.setApepat(apepat);
            oPersonal.setApemat(apemat);
            /*int sex = 1;
            switch (sexo.charAt(0)) {
                case 'M':
                    sex = 1;
                case 'F':
                    sex = 2;
            }*/
            oPersonal.setSexo(1);
            oPersonal.setDireccion1(direccion);
            //oPersonal.setDireccion2(direccion);
            //oPersonal.setFecnacimiento(DateUtil.FechaActualDate());
            //oPersonal.setFecnacimiento(DateUtil.parsearFecha(fechanacimiento, "yyyy-MM-dd"));
            //oPersonal.setFecregistro(DateUtil.FechaActualDate());
            /*oPersonal.setUsureg(1);
            oPersonal.setEstado(1);
            oPersonal.setCargo("");
            oPersonal.setCategoria("");
            oPersonal.setHorario("");
            oPersonal.setColegiatura("");
            oPersonal.setSueldobruto("0");
            oPersonal.setProfesion("");
            oPersonal.setFono1("");
            oPersonal.setFono2("");
            oPersonal.setRecomendacion("");
            oPersonal.setObservaciones("");
            oPersonal.setDescuento(new BigDecimal("0"));
            oPersonal.setCorreo("");
            oPersonal.setResponsable("");*/
            listaMovPersonal.add(oPersonal);
            txtResumen.append(fila + " " + dni + " " + nombre + "  OK \n");
        } catch (Exception e) {
            LogsUtil.Show(oClass,"KE PASO "+e.getMessage());
            txtResumen.append(fila + "  ===> OBERVADO : " + dni + " " + nombre + " FALLO VERIFICAR DATOS \n");
        }
    }

    private void registraPersonal() {
        LogsUtil.Show(oClass, ":::: REGISTRANDO PERSONAL " + listaMovPersonal.size());
        txtResumen.append(":::: REGISTRANDO PERSONAL :::::\n");
        for (Personal Item : listaMovPersonal) {
            try {
                String oMovServidor = frmPrincipal.oNegocioDao.getRegistrarPersonal(Item);
                if (oMovServidor.equals("0")) {
                    String Mensaje = "";
                    Mensaje = "REGISTRO EXITOSO EN EL SERVIDOR " + Item.getNombre() + " " + Item.getApepat();
                    LogsUtil.Show(oClass, Mensaje);
                }
                if (oMovServidor.equals("")) {
                    String Mensaje = "";
                    Mensaje = "REGISTRO FALLIDO EN EL SERVIDOR  " + Item.getNombre() + " " + Item.getApepat();
                    LogsUtil.Show(oClass, Mensaje);
                }
            } catch (Exception e) {
                txtResumen.append("OBSERVADO " + Item.getNrodocumento() + " " + Item.getNombre() + " " + Item.getApepat() + "\n");
            }
        }
    }
}
