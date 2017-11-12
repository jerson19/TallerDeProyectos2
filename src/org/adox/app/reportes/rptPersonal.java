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
//import net.sf.jasperreports.view.JasperViewer;
//import org.adox.app.common.ConstantesApp;
//import org.adox.app.config.AppConfigLocal;
//import org.adox.app.config.jdbc._CFGConexion;
//import org.adox.app.util.LogsUtil;
//
//public class rptPersonal {
//
//    Connection oConnection;
//
//    public rptPersonal() {
//        try {
//            oConnection = _CFGConexion.getConexion();
//        } catch (Exception e) {
//            LogsUtil.LogsApp(rptPersonal.class, "ReporteLacteo ::: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
//        }
//    }
//
//    public void runReporte() {
//
//        try {
//            String urlReporte = System.getProperty("user.dir")
//                    + AppConfigLocal.RUTA_RPTPERSONAL;
//            LogsUtil.LogsApp(rptPersonal.class, "La ruta es " + urlReporte, ConstantesApp.ERROR_INFO);
//            if (urlReporte == null) {
//                LogsUtil.LogsApp(rptPersonal.class, "No encuentro el archivo del reporte maestro.", ConstantesApp.ERROR_ERROR);
//                System.exit(2);
//            }
//            //JasperCompileManager.compileReportToFile(master);
//            JasperReport masterReport = null;
//            try {
//                masterReport = (JasperReport) JRLoader.loadObject(urlReporte);
//            } catch (JRException e) {
//                LogsUtil.LogsApp(rptPersonal.class, "Error cargando el reporte maestro: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
//                System.exit(3);
//            }
//
//
//            //este es el parámetro, se pueden agregar más parámetros
//            //basta con poner mas parametro.put
//            Map parametro = new HashMap();
//            parametro.put("logo", "logoreporte.jpg");
//
//            //Reporte diseñado y compilado con iReport
//            LogsUtil.LogsApp(rptPersonal.class, "Cargando parametros conexion", ConstantesApp.ERROR_INFO);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, oConnection);
//
////            JasperExportManager.exportReportToPdfFile(
////                  jasperPrint, "C:\\plantilla.pdf");
//            //Se lanza el Viewer de Jasper, no termina aplicación al salir
//
////            JasperViewer.viewReport(jasperPrint, false);
//
//            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
//            jviewer.setIconImage(new ImageIcon(AppConfigLocal.APP_ICONO).getImage());
//            jviewer.setTitle("::: Reporte de Personal :::");
//            jviewer.setVisible(true);
//
//            cerrar(jasperPrint);
//        } catch (JRException e) {
//            LogsUtil.LogsApp(rptPersonal.class, "JRException runReporte ::: "+e.getMessage(), ConstantesApp.ERROR_ERROR);
//        }
//    }
//
//    public void cerrar(JasperPrint jasperPrint) {
//        try {
//            jasperPrint = null;
//            oConnection.close();
//        } catch (SQLException e) {
//            LogsUtil.LogsApp(rptPersonal.class, "cerrar(JasperPrint jasperPrint) ::: "+e.getMessage(), ConstantesApp.ERROR_ERROR);
//        }
//    }
//}
