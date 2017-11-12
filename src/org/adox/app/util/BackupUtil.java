package org.adox.app.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.adox.app.config.ServicioSpring;
import org.adox.app.facade.dao.facadeAplicacionDao;
import org.adox.app.view.aplicacion.ifBackup;
import org.apache.log4j.Logger;

/**
 * @author Adolfo
 * http://www.desarrolloweb.com/articulos/1202.php
 * http://dev.mysql.com/doc/refman/5.0/es/mysqldump.html
 * http://linuxcommand.org/man_pages/mysqldump1.html
 */
public class BackupUtil {

    static Logger oClass = Logger.getLogger("Main");
    private int BUFFER = 10485760;    //para guardar en memmoria
    private StringBuffer temp = null;    //para guardar el archivo SQL
    private FileWriter fichero = null;
    private PrintWriter pw = null;
    JFileChooser fileSeleccionar = new JFileChooser();
    ifBackup Backup;
    String USUARIO = "root";
    String CLAVE = "root";
    String DATABASE = "dbsisgesadox";
    String HOST = "localhost";
    //AppConfig config = new AppConfig(AppConfigLocal.APP_PROPERTIES_JDBC);

    public BackupUtil(ifBackup obacc) {
        Backup = obacc;
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos Sql", "sql");
        fileSeleccionar.setFileFilter(filtro);
        fileSeleccionar.setCurrentDirectory(new File("c:/"));
    }

    public void GenerarBackupMySQL() {
        int resp;
        fileSeleccionar.setDialogTitle("Guardar Copia de Respaldo ");
        resp = fileSeleccionar.showSaveDialog(Backup);//JFileChooser de nombre fileSeleccionar
        if (resp == JFileChooser.APPROVE_OPTION) {//Si el usuario presiona aceptar; se genera el Backup
            try {
                Runtime runtime = Runtime.getRuntime();
                File backupFile = new File(String.valueOf(fileSeleccionar.getSelectedFile().toString()) + "_" + DateUtil.fecha_DD_MES_YYYY_reporte() + ".sql");
                FileWriter fw = new FileWriter(backupFile);
//                Process child = runtime.exec("C:\\Archivos de programa\\MySQL\\MySQL Server 5.1\\bin\\mysqldump --opt --password=HdMc --user=root --databases bd_ueta_mysql");
                Process child = runtime.exec("mysqldump --opt --user=" + USUARIO + " --password=" + CLAVE + " --databases " + DATABASE + " -- host " + HOST + " --hex-blob --routines");
//                Process child = runtime.exec("mysqldump --opt --password=root --user=root --databases dbhotel --compact --skip-comments --no-create-info --no-data --routines --compact --hex-blob --routines");
                InputStreamReader irs = new InputStreamReader(child.getInputStream());
                BufferedReader br = new BufferedReader(irs);

                String line;
                while ((line = br.readLine()) != null) {
                    fw.write(line + "\n");
                }
                fw.close();
                irs.close();
                br.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error no se genero el archivo por el siguiente motivo: " + e.getMessage(), " Verificar ", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, "Backup generada exitosamente ", "Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
        } else if (resp == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Ha sido cancelada la generacion del Backup");
        }
    }

    public void RestaurarBackup(ServicioSpring oSpring) throws Exception {
        ServicioSpring aop = oSpring;
        facadeAplicacionDao service = (facadeAplicacionDao) aop.getBean("facadeAplicacionDao");
        String ubicacion = "";
        String ejecutar = "";
        fileSeleccionar.setDialogTitle("Seleccione Copia de Respaldo ");
        if (service.getObtenerConexion()) {
            try {
                EntityManager em = service.getObtenerConexionPU();
                //IMPLEMENTACION DE LA CONEXION VIRTUAL PARA BORRAR LA BD QUE SE ENCONTRO//
                String comsSQLborra = "DROP DATABASE " + DATABASE;
                em.getTransaction().begin();
                em.createNativeQuery(comsSQLborra);
                em.getTransaction().commit();
                System.out.println("SE BORRO LA BASE DE DATOS");

                //IMPLEMENTACION DE LA CONEXION VIRTUAL DESPUES DE HABER BORRADO LA BD ENCONTRADA//
                String comsSQLcrea = "CREATE DATABASE " + DATABASE;
                em.getTransaction().begin();
                em.createNativeQuery(comsSQLcrea);
                em.getTransaction().commit();
                System.out.println("SE CREO LA BASE DE DATOS");
                //RESTAURACION DEL BACKUP//
                int resp;
                resp = fileSeleccionar.showOpenDialog(Backup);//Mustra el cuadro con la Opcion Abrir
                if (resp == JFileChooser.APPROVE_OPTION) {//Si el usuario presiona aceptar(Abrir); Backup
                    ubicacion = String.valueOf(fileSeleccionar.getSelectedFile().toString().trim());
                    System.out.println("ubicacion del archivo " + ubicacion);
                    ejecutar = "cmd /c mysql --password=" + CLAVE + " --user=" + USUARIO + " " + DATABASE + " < " + ubicacion + "";
                    System.out.println(ejecutar);
                    Process child = Runtime.getRuntime().exec(ejecutar);
                    System.out.println(child);
                    JOptionPane.showMessageDialog(null, "Backup restaurado exitosamente!");
                }
                //FINAL DE LA RESTAURACION//
            } catch (Exception ex) {
                System.out.println("Fallo restaurando la Base de Datos! bde" + ex.getMessage());
            }
        } else {
            try {
                //IMPLEMENTACION DE LA CONEXION VIRTUAL      
                EntityManager em = service.getObtenerConexionPU();
                String comsSQLcrea = "CREATE DATABASE " + DATABASE + "";
                em.getTransaction().begin();
                em.createNativeQuery(comsSQLcrea);
                em.getTransaction().commit();
                em.close();
                System.out.println("SE CREO LA BASE DE DATOS");
                //RESTAURACION DEL BACKUP//
                int resp;
                resp = fileSeleccionar.showOpenDialog(Backup);//Mustra el cuadro con la Opcion Abrir
                if (resp == JFileChooser.APPROVE_OPTION) {//Si el usuario presiona aceptar(Abrir); Backup
                    ubicacion = String.valueOf(fileSeleccionar.getSelectedFile().toString().trim());
                    System.out.println("ubicacion del archivo " + ubicacion);
                    ejecutar = "cmd /c mysql --password=" + CLAVE + " --user=" + USUARIO + " " + DATABASE + " < " + ubicacion + "";
                    System.out.println("ejecutar " + ejecutar);
                    Process child = Runtime.getRuntime().exec(ejecutar);
                    System.out.println(child);
                    JOptionPane.showMessageDialog(null, "Backup restaurado exitosamente!");
                }
            } catch (IOException ex) {
                System.out.println("Error de entrada y/o salida a la Base de Datos! " + ex.getMessage());
            }
            //FINAL DEL ELSE DEL conn//

        }

    }
}
