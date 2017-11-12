package org.adox.app.facade.dao;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManagerFactory;
import org.adox.app.entities.Actividades;
import org.adox.app.entities.Actividadpersonal;
import org.adox.app.entities.Asistencias;
import org.adox.app.entities.Personal;
import org.adox.app.facade.business.dto.Tabla;
import org.adox.app.facade.business.dto.UsuarioSesion;

/**
 * @version V1
 * @author Adolfo Villanueva
 */
public interface facadeNegocioDao {

    public void setPersistencia(EntityManagerFactory entityManagerFactory);

    public UsuarioSesion getValidarLogeo(String usuario, String clave, String idEmpresa);

    public List<Personal> getBuscarPersonal(String Descripcion);

    public List<Personal> getListarPersonalAsistencia();

    public List<Tabla> getListarPersonal();

    public String getRegistrarPersonal(Personal oPersonal);

    public String getActualizarPersonal(Personal obj);

    public Personal getObtenerPersonal(Integer idPersonal);

    /*Otros*/
    public Personal getBuscarPersonalDni(String dni);

    /* PRODUCTIVIDAD */
    public List<Actividades> getBuscarActividad(String Actividad);

    public String getRegistrarActividadPersonal(Actividadpersonal ap);

    public Vector getObtenerPersonalCargo(String USUARIO);

    public List<Actividadpersonal> getObtenerActividadesPersonal(String PersonalSeleccionado);

    public String getActualizarActividadesPersonal(Actividadpersonal ap);

    public String getRegistrarAsistencias(Asistencias oAsistencias);
}
