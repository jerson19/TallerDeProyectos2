/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * fInformacionAsistencia.java
 *
 * Created on 23/05/2011, 01:55:48 AM
 */
package org.adox.app.view.aplicacion;

import com.sun.awt.AWTUtilities;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.adox.app.config.AppConfigLocal;
import org.adox.app.util.LogsUtil;
import org.apache.log4j.Logger;

/**
 *
 * @author ADOLFO
 */
public class fInformacionAsistencia extends javax.swing.JFrame {

    static Logger oClass = Logger.getLogger("fInformacionAsistencia");
    private Timer tiempo;
    private TimerTask task;
    private String respuesta = "Se acabo el tiempo, mala suerte";
    private int duracion = 7;

    public fInformacionAsistencia() {
        setUndecorated(true);
        AWTUtilities.setWindowOpaque(this, false);
        initComponents();
        this.setIconImage(new ImageIcon(AppConfigLocal.APP_ICONO).getImage());
        this.setLocationRelativeTo(null);
        Comenzar_a_contar();
    }

    public fInformacionAsistencia(String dni, String personal, String Asistencia, String hora) {
        initComponents();
        try {
            this.setIconImage(new ImageIcon(AppConfigLocal.APP_ICONO).getImage());
            //LogsUtil.Show(oClass, "La imagen  es : " + System.getProperty("user.dir") + "\\personal\\"+dni+".jpg");
            BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir") + "\\personal\\"+dni+".jpg"));
            ImageIcon imagenFinal = new javax.swing.ImageIcon(redimensionarImagen(image, lblFotoPersonal.getWidth(), lblFotoPersonal.getHeight()));
            lblFotoPersonal.setIcon(imagenFinal);                   
        } catch (Exception e) {            
            //LogsUtil.Show(oClass, "La imagen  es : " + System.getProperty("user.dir") + "\\personal\\personal.jpg");
            try {
                BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir") + "\\personal\\personal.jpg"));
                ImageIcon imagenFinal = new javax.swing.ImageIcon(redimensionarImagen(image, lblFotoPersonal.getWidth(), lblFotoPersonal.getHeight()));
                lblFotoPersonal.setIcon(imagenFinal);            
            } catch (IOException ex) {
                LogsUtil.Show(oClass, "ERROR => FALLO CARGANDO FOTO DE PERSONAL "+ex.getMessage());
            }
            LogsUtil.Show(oClass, "ERROR => FALLO CARGANDO ICONO DE INTERFAZ "+e.getMessage());
        }
        
        this.setIconImage(new ImageIcon(AppConfigLocal.APP_ICONO).getImage());
    
        this.setLocationRelativeTo(null);
        lblPersonal.setText(personal);
        lblAsistencia.setText(Asistencia);
        lblHora.setText(hora);
        //LogsUtil.Show(oClass, "************************");
        Comenzar_a_contar();
        //LogsUtil.Show(oClass, "************************");
    }

    private Image redimensionarImagen(Image imagen, int ancho, int alto) {
        return imagen.getScaledInstance(ancho, alto, Image.SCALE_AREA_AVERAGING);
    }
    
    public void Comenzar_a_contar() {
        tiempo = new Timer();
        task = new TimerTask() {

            int contador = 0;

            public void run() {
                contador++;
                //System.out.print("tiempo : " + contador + " - ");
//                   miframe.lbtiempo.setText(String.valueOf(contador));
                if (contador == duracion) {
                    //LogsUtil.Show(oClass, "Se acabo el tiempo, mala suerte");
                    time_is_over();
                    detener();
                }

            }
        };
        tiempo.schedule(task, 0, 1000);
    }

    //detiene la animacion
    public void detener() {
        tiempo.cancel();
        task.cancel();
    }

    public void time_is_over() {
        this.respuesta = "Se acabo el tiempo, mala suerte";
//        actualizar();//actualiza controles
        this.dispose();//cierra ventana
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelNice2 = new org.edisoncor.gui.panel.PanelNice();
        lblFotoPersonal = new javax.swing.JLabel();
        panelNice1 = new org.edisoncor.gui.panel.PanelNice();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblPersonal = new javax.swing.JLabel();
        lblAsistencia = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("::: RESÚMEN DE ASISTENCIA :::"); // NOI18N
        setUndecorated(true);
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.setName("jPanel1"); // NOI18N

        panelNice2.setName("panelNice2"); // NOI18N

        lblFotoPersonal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFotoPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/adox/app/resources/imagenes/u_personal.png"))); // NOI18N
        lblFotoPersonal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblFotoPersonal.setMaximumSize(null);
        lblFotoPersonal.setMinimumSize(null);
        lblFotoPersonal.setName("lblFotoPersonal"); // NOI18N
        lblFotoPersonal.setPreferredSize(new java.awt.Dimension(50, 60));

        javax.swing.GroupLayout panelNice2Layout = new javax.swing.GroupLayout(panelNice2);
        panelNice2.setLayout(panelNice2Layout);
        panelNice2Layout.setHorizontalGroup(
            panelNice2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
            .addGroup(panelNice2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelNice2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblFotoPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelNice2Layout.setVerticalGroup(
            panelNice2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
            .addGroup(panelNice2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNice2Layout.createSequentialGroup()
                    .addContainerGap(16, Short.MAX_VALUE)
                    .addComponent(lblFotoPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        panelNice1.setName("panelNice1"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Personal:");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Asistencia:");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Hora :");
        jLabel3.setName("jLabel3"); // NOI18N

        lblPersonal.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblPersonal.setForeground(new java.awt.Color(255, 255, 255));
        lblPersonal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPersonal.setText("Carlos Alberto Parreyra de la Cruz asdas Perez");
        lblPersonal.setToolTipText("");
        lblPersonal.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblPersonal.setFocusable(false);
        lblPersonal.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblPersonal.setName("lblPersonal"); // NOI18N
        lblPersonal.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lblAsistencia.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblAsistencia.setForeground(new java.awt.Color(255, 255, 255));
        lblAsistencia.setText("xxx");
        lblAsistencia.setName("lblAsistencia"); // NOI18N

        lblHora.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setText("xxx");
        lblHora.setName("lblHora"); // NOI18N

        javax.swing.GroupLayout panelNice1Layout = new javax.swing.GroupLayout(panelNice1);
        panelNice1.setLayout(panelNice1Layout);
        panelNice1Layout.setHorizontalGroup(
            panelNice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNice1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelNice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblAsistencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelNice1Layout.setVerticalGroup(
            panelNice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNice1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelNice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelNice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblAsistencia))
                .addGap(31, 31, 31)
                .addGroup(panelNice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHora)
                    .addComponent(jLabel3))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelNice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelNice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelNice1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelNice2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new fInformacionAsistencia().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAsistencia;
    private javax.swing.JLabel lblFotoPersonal;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblPersonal;
    private org.edisoncor.gui.panel.PanelNice panelNice1;
    private org.edisoncor.gui.panel.PanelNice panelNice2;
    // End of variables declaration//GEN-END:variables
}
