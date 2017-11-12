package org.adox.app.facade.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.adox.app.common.ConstantesApp;
import org.adox.app.config.AppConfig;
import org.adox.app.config.AppConfigLocal;
import org.adox.app.facade.business.dto.dtoTabla;
import org.adox.app.facade.dao.rptReporteDao;
import org.adox.app.util.LogsUtil;
import org.adox.app.util.ProgressUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "rptReporteDao")
public class rptReporteDaoImpl implements rptReporteDao {

    static Logger oClass = Logger.getLogger("rptReporte");
    AppConfig config = new AppConfig(AppConfigLocal.APP_PROPERTIES_JDBC);
    
    @Autowired
    private DataSource dataSource;

//    public DataSource getDataSource() {
//        return dataSource;
//    }
//
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    
    @Override
    public Connection getConexion() {
        Connection _Connection;
        try {
            _Connection = dataSource.getConnection();
            //_Connection = getDataSource().getConnection();
            LogsUtil.Show(oClass, "CONEXION JDBC EXITOSA ");
            return _Connection;
        } catch (SQLException ex) {
            _Connection = null;
            LogsUtil.LogsApp(oClass, "Conexion nula : " + ex.getMessage(), ConstantesApp.ERROR_ERROR);
            return _Connection;
        }
    }

    @Override
    public void viewReporte(String Titulo, String reportName, List<dtoTabla> parametros) {
        LogsUtil.Show(oClass, " :: viewReporte :: ");
        String reportTemplatesPath = System.getProperty("user.dir");
        String reportPath = reportTemplatesPath + reportName;
        LogsUtil.Show(oClass, "reportTemplatePath " + reportPath);
        JasperReport masterReport = null;
        try {
            masterReport = (JasperReport) JRLoader.loadObject(reportPath);
        } catch (JRException e) {
            LogsUtil.LogsApp(oClass, "Error cargando el reporte maestro: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
            System.exit(3);
        }
        LogsUtil.LogsApp(oClass, "PARAMETROS PASADOS : ", ConstantesApp.ERROR_INFO);
        Map reportParameters = new HashMap();
        for (dtoTabla _parametro : parametros) {
            reportParameters.put(_parametro.getId(), _parametro.getDescripcion());
            LogsUtil.Show(oClass, "PARAM. : " + _parametro.getId() + " VALOR : " + _parametro.getDescripcion());
        }
        Connection _Connection;
        _Connection = getConexion();
        if (_Connection != null) {
            LogsUtil.Show(oClass, "GENERANDO REPORTE");
            JasperPrint jasperPrint = null;
            try {
                jasperPrint = JasperFillManager.fillReport(masterReport, reportParameters, _Connection);
            } catch (Exception ex) {
                LogsUtil.Show(oClass, "Exception al generar reporte " + ex.getMessage());
            }
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setIconImage(new ImageIcon(AppConfigLocal.APP_ICONO).getImage());
            jviewer.setTitle(Titulo);
            jviewer.setVisible(true);
            cerrar(_Connection);
        } else {
            LogsUtil.Show(oClass, "CONEXION JDBC NULA - FIN DE REPORTE ");
        }
        ProgressUtil.stop();
    }

    public void cerrar(Connection _Connection) {
        try {
            _Connection.close();
            LogsUtil.Show(oClass, "REPORTE EXITOSO ");
        } catch (SQLException e) {
            LogsUtil.LogsApp(oClass, "cerrar(JasperPrint jasperPrint) ::: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
        }
    }
}
