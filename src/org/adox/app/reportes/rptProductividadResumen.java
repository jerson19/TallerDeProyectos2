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
//import org.adox.app.config.jdbc._CFGConexion;
//import org.adox.app.util.LogsUtil;
//
//public class rptProductividadResumen {
//
//    Connection oConnection;
//
//    public rptProductividadResumen() {
//        try {
//            oConnection = _CFGConexion.getConexion();
//        } catch (Exception ex) {
//            LogsUtil.LogsApp(rptProductividadResumen.class, "rptAsistencia : ", ConstantesApp.ERROR_ERROR);
//        }
//    }
//
//    public void runReporte(String fechaDesde,String fechaHasta,String Personal,String estado) {
//        try {
//            String master = System.getProperty("user.dir")
//                    + AppConfigLocal.RUTA_RPTPRODUCTIVIDADRESUMEN;
//            LogsUtil.LogsApp(rptProductividadResumen.class, "Ruta : " + master, ConstantesApp.ERROR_INFO);
//            if (master == null) {
//                LogsUtil.LogsApp(rptProductividadResumen.class, "No encuentro el archivo del reporte maestro. ", ConstantesApp.ERROR_ERROR);
//                System.exit(2);
//            }
//            //JasperCompileManager.compileReportToFile(master);
//            JasperReport masterReport = null;
//            try {
//                masterReport = (JasperReport) JRLoader.loadObject(master);
//            } catch (JRException e) {
//                LogsUtil.LogsApp(rptProductividadResumen.class, "Error cargando el reporte maestro: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
//                System.exit(3);
//            }
//
//            LogsUtil.LogsApp(rptProductividadResumen.class, "PARAMETROS PASADOS : ", ConstantesApp.ERROR_INFO);
//            LogsUtil.LogsApp(rptProductividadResumen.class, "fechaDesde : " + fechaDesde, ConstantesApp.ERROR_INFO);
//            LogsUtil.LogsApp(rptProductividadResumen.class, "fechasta : " + fechaHasta, ConstantesApp.ERROR_INFO);
//            LogsUtil.LogsApp(rptProductividadResumen.class, "estado : " + estado, ConstantesApp.ERROR_INFO);
//            //este es el parámetro, se pueden agregar más parámetros
//            //basta con poner mas parametro.put
//            Map parametro = new HashMap();
//                parametro.put("fecdesde", fechaDesde);
//            parametro.put("fechasta", fechaHasta);
//            parametro.put("estado", estado);
//            parametro.put("persona", Personal);
//
//            //Reporte diseñado y compilado con iReport
//            LogsUtil.LogsApp(rptProductividadResumen.class, "Cargando parametros conexion", ConstantesApp.ERROR_INFO);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, oConnection);
//
//            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
//            jviewer.setIconImage(new ImageIcon(AppConfigLocal.APP_ICONO).getImage());
//            jviewer.setTitle("::: Reporte de Resumen de Productividad :::");
//            jviewer.setVisible(true);
//
//            cerrar(jasperPrint);
//        } catch (JRException e) {
//            LogsUtil.LogsApp(rptProductividadResumen.class, "JRException runReporte ::: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
//        }
//    }
//
//    public void cerrar(JasperPrint jasperPrint) {
//        try {
//            jasperPrint = null;
//            oConnection.close();
//        } catch (SQLException e) {
//            LogsUtil.LogsApp(rptProductividadResumen.class, "cerrar(JasperPrint jasperPrint) ::: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
//        }
//    }
//}
