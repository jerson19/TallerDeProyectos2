package org.adox.app.facade.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.adox.app.entities.Empresa;
import org.adox.app.facade.business.dto.Tabla;

/**
 * @version V1
 * @author Adolfo Villanueva
 */
public interface facadeAplicacionDao {

    // CONEXION
    public void setPersistencia(EntityManagerFactory entityManagerFactory);

    public boolean getObtenerConexion();

    public EntityManager getObtenerConexionPU();

    //FECHAS
    public Date getObtenerFecha();

    public String getObtenerFechaHoraServidor();

    //TABLAS CODIGO DESCRIPCION
    public List<Tabla> getObtenerDescripcion(String idPadre);

    public String getObtenerIdDescripcion(String descripcion, String idTabla);

    //TABLA EMPRESA
    public List<Empresa> getObtenerEmpresas();

    public List<Empresa> getObtenerOficinas();

    public String getObtenerIdEmpresa(String Empresa);

    public String getObtenerDescripcionEmpresa(String idEmpresa);

    public String getObtenerIdOficina(String Oficina);
}
