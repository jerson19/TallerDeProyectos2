//package org.adox.app.reportes;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import java.util.HashMap;
//import java.util.Map;
//import javax.swing.ImageIcon;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.util.JRLoader;
//import net.sf.jasperreports.view.*;
//import org.adox.app.common.ConstantesApp;
//import org.adox.app.config.AppConfigLocal;
//import org.adox.app.util.DateUtil;
//import org.adox.app.util.LogsUtil;
//import org.apache.log4j.Logger;
//
//public class rptAsistenciaMensual {
//
//    static Logger oClass = Logger.getLogger("rptAsistenciaMensual");
//    Connection oConnection;
//
//    public rptAsistenciaMensual(Connection conn) {
//        try {
//            oConnection = conn;
//        } catch (Exception ex) {
//            LogsUtil.LogsApp(oClass, "rptAsistencia : ", ConstantesApp.ERROR_ERROR);
//        }
//    }
//
//
//    public void runReporte(String anio, String mes) {
//        try {
//            String master = System.getProperty("user.dir")
//                    + AppConfigLocal.RUTA_RPTLASISTENCIAMENSUAL;
//            LogsUtil.LogsApp(oClass, "Ruta : " + master, ConstantesApp.ERROR_INFO);
//            if (master == null) {
//                LogsUtil.LogsApp(oClass, "No encuentro el archivo del reporte maestro. ", ConstantesApp.ERROR_ERROR);
//                System.exit(2);
//            }
//            //JasperCompileManager.compileReportToFile(master);
//            JasperReport masterReport = null;
//            try {
//                masterReport = (JasperReport) JRLoader.loadObject(master);
//            } catch (JRException e) {
//                LogsUtil.LogsApp(oClass, "Error cargando el reporte maestro: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
//                System.exit(3);
//            }
//
//            int mes_actual = Integer.parseInt(mes);
//            LogsUtil.LogsApp(oClass, "PARAMETROS PASADOS : ", ConstantesApp.ERROR_INFO);
//            LogsUtil.Show(oClass,"anio : " + anio);
//            String mes_selec = DateUtil.nombremes(mes_actual);
//            LogsUtil.Show(oClass,"mes : " + mes_selec);
//            String fechita = DateUtil.nombremes(mes_actual) +" DEL "+DateUtil.Anio();
//            LogsUtil.Show(oClass,"fechita : " + fechita);
//            String[] dias = DateUtil.reporte_DiasMes(Integer.parseInt(anio), mes_actual - 1);
//            LogsUtil.Show(oClass,"d1 : " + dias[1]);
//            LogsUtil.Show(oClass,"d2 : " + dias[2]);
//            LogsUtil.Show(oClass,"d3 : " + dias[3]);
//            //este es el parámetro, se pueden agregar más parámetros
//            //basta con poner mas parametro.put
//            Map parametro = new HashMap();
//            parametro.put("d1", dias[1]);
//            parametro.put("d2", dias[2]);
//            parametro.put("d3", dias[3]);
//            parametro.put("d4", dias[4]);
//            parametro.put("d5", dias[5]);
//            parametro.put("d6", dias[6]);
//            parametro.put("d7", dias[7]);
//            parametro.put("d8", dias[8]);
//            parametro.put("d9", dias[9]);
//            parametro.put("d10", dias[10]);
//            parametro.put("d11", dias[11]);
//            parametro.put("d12", dias[12]);
//            parametro.put("d13", dias[13]);
//            parametro.put("d14", dias[14]);
//            parametro.put("d15", dias[15]);
//            parametro.put("d16", dias[16]);
//            parametro.put("d17", dias[17]);
//            parametro.put("d18", dias[18]);
//            parametro.put("d19", dias[19]);
//            parametro.put("d20", dias[20]);
//            parametro.put("d21", dias[21]);
//            parametro.put("d22", dias[22]);
//            parametro.put("d23", dias[23]);
//            parametro.put("d24", dias[24]);
//            parametro.put("d25", dias[25]);
//            parametro.put("d26", dias[26]);
//            parametro.put("d27", dias[27]);
//            parametro.put("d28", dias[28]);
//            parametro.put("d29", dias[29]);
//            parametro.put("d30", dias[30]);
//            parametro.put("d31", dias[31]);
//            parametro.put("fechita", fechita);
//            parametro.put("anio", anio);
//            parametro.put("mes", mes_selec);
//
//            //Reporte diseñado y compilado con iReport
//            LogsUtil.LogsApp(oClass, "Cargando parametros conexion", ConstantesApp.ERROR_INFO);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, oConnection);
//
//
//            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
//            jviewer.setIconImage(new ImageIcon(AppConfigLocal.APP_ICONO).getImage());
//            jviewer.setTitle("::: Reporte de asistencia Mensual :::");
//            jviewer.setVisible(true);
//
//            cerrar(jasperPrint);
//        } catch (JRException e) {
//            LogsUtil.LogsApp(oClass, "JRException runReporte ::: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
//        }
//    }
//
//    public void cerrar(JasperPrint jasperPrint) {
//        try {
//            jasperPrint = null;
//            oConnection.close();
//        } catch (SQLException e) {
//            LogsUtil.LogsApp(oClass, "cerrar(JasperPrint jasperPrint) ::: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
//        }
//    }
//}
