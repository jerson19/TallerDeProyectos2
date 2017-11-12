package org.adox.app.facade.dao;

import java.sql.Connection;
import java.util.List;
import org.adox.app.facade.business.dto.dtoTabla;

/**
 * @author ADOLFO
 */
public interface rptReporteDao {

    public void viewReporte(String Titulo, String reportName, List<dtoTabla> parametros);

    public Connection getConexion();

}
