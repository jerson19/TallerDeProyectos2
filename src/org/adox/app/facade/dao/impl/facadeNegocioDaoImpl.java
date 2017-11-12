package org.adox.app.facade.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.adox.app.common.ConstantesApp;
import org.adox.app.config.jdbc._Querys;
import org.adox.app.entities.Actividades;
import org.adox.app.entities.Actividadpersonal;
import org.adox.app.entities.Asistencias;
import org.adox.app.entities.Personal;
import org.adox.app.facade.business.dto.Tabla;
import org.adox.app.facade.business.dto.UsuarioSesion;
import org.adox.app.facade.dao.facadeNegocioDao;
import org.adox.app.util.LogsUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @version V1
 * @author Adolfo Villanueva
 */
@Repository(value = "facadeNegocioDao")
public class facadeNegocioDaoImpl extends _Querys implements facadeNegocioDao {
    
    static Logger oClass = Logger.getLogger("facadeNegocioDaoImpl");

    private EntityManager em = null;    
    @Autowired
    private EntityManagerFactory emf;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void _init() {        
        em = emf.createEntityManager();
    }

    @Override
    public void setPersistencia(EntityManagerFactory entityManagerFactory) {
        em = entityManagerFactory.createEntityManager();
    }

    @Override
    public UsuarioSesion getValidarLogeo(String usuario, String clave, String idOficina) {
        try {
            _init();
            Query q = em.createNativeQuery(QueryValidacionUsuario(oClass, usuario, clave, idOficina));
            List list = q.getResultList();
            UsuarioSesion obj = new UsuarioSesion();
            for (Object oObject : list) {
                Object[] fila = (Object[]) oObject;
                obj.setIdUsuario(fila[0].toString());
                obj.setIdPersonal(fila[1].toString());
                obj.setNombre(fila[2].toString());
                obj.setApellidos(fila[3].toString());
                obj.setEmpresa(fila[4].toString());
                obj.setRol(fila[5].toString());
                obj.setIdEmpresa(fila[6].toString());
            }
            LogsUtil.LogsApp(oClass, " ::: OK ::: getValidarLogeo", ConstantesApp.ERROR_INFO);
            return obj;
        } catch (Exception e) {
            UsuarioSesion obj = new UsuarioSesion();
            LogsUtil.LogsApp(oClass, " :: ERROR :: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
            return obj;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Personal> getBuscarPersonal(String Descripcion) {
        List<Personal> listPersonal = new ArrayList<Personal>();
        try {
            _init();
            Query q = em.createNativeQuery(QueryBuscarPersonal(oClass, Descripcion));
            List list = q.getResultList();
            Personal obj;
            for (Object oObject : list) {
                Object[] fila = (Object[]) oObject;
                obj = new Personal();
                obj.setNrodocumento(fila[0].toString());
                obj.setNombre(fila[1].toString());
                obj.setApepat(fila[2].toString());
                obj.setApemat(fila[3].toString());
                obj.setIdpersonal(Integer.parseInt(fila[4].toString()));
//                obj.setIdPersonal(fila[5].toString());
                listPersonal.add(obj);
            }
            LogsUtil.LogsApp(oClass, " ::: OK ::: getBuscarPersonal", ConstantesApp.ERROR_INFO);
            return listPersonal;
        } catch (Exception e) {
            Personal obj = new Personal();
            listPersonal.add(obj);
            LogsUtil.LogsApp(oClass, " :: ERROR :: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
            return listPersonal;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Personal> getListarPersonalAsistencia() {
        List<Personal> listPersonal = new ArrayList<Personal>();
        try {
            _init();
            Query q = em.createQuery(QueryBuscarPersonalAsistencia(oClass));
            listPersonal = q.getResultList();
            /*Personal obj;
            for (Personal oPersonal : list) {
                obj = new Personal();
                obj.setIdpersonal(oPersonal.getIdpersonal());
                obj.setNombre(oPersonal.getNombre() + " " + oPersonal.getApepat() + " " + oPersonal.getApemat());
                obj.setNrodocumento(oPersonal.getNrodocumento());
                obj.setHuella(oPersonal.getHuella());
                listPersonal.add(obj);
            }*/
            LogsUtil.LogsApp(oClass, " ::: OK ::: getListarPersonalAsistencia " + listPersonal.size(), ConstantesApp.ERROR_INFO);
            return listPersonal;
        } catch (Exception e) {
            Personal obj = new Personal();
            listPersonal.add(obj);
            LogsUtil.LogsApp(oClass, " :: ERROR :: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
            return listPersonal;
        } finally {
            em.close();
        }
    }

    public List<Tabla> getListarPersonal() {
        List<Tabla> listPersonal = new ArrayList<Tabla>();
        try {
            _init();
            Query q = em.createNativeQuery(QueryBuscarPersonal(oClass, ConstantesApp.EMPTY));
            List list = q.getResultList();
            Tabla obj;
            for (Object oObject : list) {
                Object[] fila = (Object[]) oObject;
                obj = new Tabla();
                obj.setDescripcion(fila[1].toString() + " " + fila[2].toString() + " " + fila[3].toString());
                obj.setId(fila[4].toString());
                listPersonal.add(obj);
            }
            LogsUtil.LogsApp(oClass, " ::: OK ::: getBuscarPersonal", ConstantesApp.ERROR_INFO);
            return listPersonal;
        } catch (Exception e) {
            Tabla obj = new Tabla();
            listPersonal.add(obj);
            LogsUtil.LogsApp(oClass, " :: ERROR :: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
            return listPersonal;
        } finally {
            em.close();
        }
    }

    @Override
    public Personal getBuscarPersonalDni(String dni) {
        Personal oPersonal = new Personal();
        try {
            _init();
            Query q = em.createNativeQuery(QuerygetBuscarPersonalDni(oClass, dni));
            List list = q.getResultList();
            oPersonal.setIdpersonal(0);
            for (Object oObject : list) {
                Object[] fila = (Object[]) oObject;
                oPersonal.setIdpersonal(Integer.parseInt(fila[0].toString()));
                oPersonal.setNombre(fila[1].toString());
            }
            LogsUtil.LogsApp(oClass, " ::: OK ::: getBuscarPersonalDni", ConstantesApp.ERROR_INFO);
            return oPersonal;
        } catch (Exception e) {
            LogsUtil.LogsApp(oClass, " :: ERROR :: getBuscarPersonalDni " + e.getMessage(), ConstantesApp.ERROR_ERROR);
            return oPersonal;
        } finally {
            em.close();
        }
    }

    @Override
    public String getRegistrarPersonal(Personal obj) {
        try {
            _init();
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            String oResultSet = "0";
            LogsUtil.LogsApp(oClass, " ::: OK ::: getRegistrarPersonal", ConstantesApp.ERROR_INFO);
            return oResultSet;
        } catch (Exception e) {
            LogsUtil.LogsApp(oClass, " :: ERROR :: getRegistrarPersonal " + e.getMessage(), ConstantesApp.ERROR_ERROR);
            return "";
        } finally {
            em.close();
        }
    }

    @Override
    public String getActualizarPersonal(Personal obj) {
        try {
            _init();
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
            LogsUtil.LogsApp(oClass, " ::: OK ::: getActualizarPersonal", ConstantesApp.ERROR_INFO);
            return "0";
        } catch (Exception e) {
            LogsUtil.LogsApp(oClass, " :: ERROR :: getActualizarPersonal " + e.getMessage(), ConstantesApp.ERROR_ERROR);
            return "";
        } finally {
            em.close();
        }
    }

    @Override
    public Personal getObtenerPersonal(Integer idPersonal) {
        Personal oPersonal = null;
        try {
            _init();
            LogsUtil.Show(oClass, "ID PERSONAL : " + idPersonal);
            oPersonal = em.find(Personal.class, idPersonal);
            LogsUtil.LogsApp(oClass, " ::: OK ::: getObtenerPersonal", ConstantesApp.ERROR_INFO);
            return oPersonal;
        } catch (Exception e) {
            LogsUtil.LogsApp(oClass, " :: ERROR :: getObtenerPersonal " + e.getMessage(), ConstantesApp.ERROR_ERROR);
            return oPersonal;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Actividades> getBuscarActividad(String Actividad) {
        List<Actividades> listActividad = new ArrayList<Actividades>();
        try {
            _init();
            Query q = em.createNativeQuery(QueryBuscarActividad(oClass, Actividad));
            List list = q.getResultList();
            Actividades obj;
            for (Object oObject : list) {
                Object[] fila = (Object[]) oObject;
                obj = new Actividades();
                obj.setIdActividad(Integer.parseInt(fila[0].toString()));
                obj.setActividad(fila[1].toString());
                listActividad.add(obj);
            }
            LogsUtil.LogsApp(oClass, " ::: OK ::: getBuscarActividad", ConstantesApp.ERROR_INFO);
            return listActividad;
        } catch (Exception e) {
            Actividades obj = new Actividades();
            listActividad.add(obj);
            LogsUtil.LogsApp(oClass, " :: ERROR :: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
            return listActividad;
        } finally {
            em.close();
        }
    }

    @Override
    public String getRegistrarActividadPersonal(Actividadpersonal obj) {
        try {
            _init();
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            String oResultSet = "0";
            LogsUtil.LogsApp(oClass, " ::: OK ::: getRegistrarActividadPersonal", ConstantesApp.ERROR_INFO);
            return oResultSet;
        } catch (Exception e) {
            LogsUtil.LogsApp(oClass, " :: ERROR :: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
            return "";
        } finally {
            em.close();
        }
    }

    @Override
    public Vector getObtenerPersonalCargo(String USUARIO) {
        Vector listPersonal = new Vector();
        try {
            _init();
            Query q = em.createNativeQuery(QueryBuscarPersonalCargo(oClass, USUARIO));
            List list = q.getResultList();
            for (Object oObject : list) {
                Object[] fila = (Object[]) oObject;
                listPersonal.add(fila[0].toString() + "-" + fila[1].toString());
            }
            LogsUtil.LogsApp(oClass, " ::: OK ::: getObtenerPersonalCargo", ConstantesApp.ERROR_INFO);
            return listPersonal;
        } catch (Exception e) {
            listPersonal.add("");
            LogsUtil.LogsApp(oClass, " :: ERROR :: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
            return listPersonal;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Actividadpersonal> getObtenerActividadesPersonal(String PersonalSeleccionado) {
        List<Actividadpersonal> listActividades = new ArrayList<Actividadpersonal>();
        try {
            _init();
            Query q = em.createNativeQuery(QuerygetListarActividadesPersonal(oClass, PersonalSeleccionado));
            List list = q.getResultList();
            Actividadpersonal obj;
            for (Object oObject : list) {
                Object[] fila = (Object[]) oObject;
                obj = new Actividadpersonal();
                obj.setIdActividadPersonal(Integer.parseInt(fila[0].toString()));
                obj.setActividad(fila[1].toString());
                obj.setCantidad(Integer.parseInt(fila[2].toString()));
                obj.setComentario(fila[3].toString());
                obj.setFecha((Date) fila[4]);
                listActividades.add(obj);
            }
            LogsUtil.LogsApp(oClass, " ::: OK ::: getObtenerActividadesPersonal", ConstantesApp.ERROR_INFO);
            return listActividades;
        } catch (Exception e) {
            Actividadpersonal obj = new Actividadpersonal();
            listActividades.add(obj);
            LogsUtil.LogsApp(oClass, " :: ERROR :: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
            return listActividades;
        } finally {
            em.close();
        }
    }

    @Override
    public String getActualizarActividadesPersonal(Actividadpersonal obj) {
        Actividadpersonal ap = new Actividadpersonal();
        try {
            _init();
            ap = em.find(Actividadpersonal.class, obj.getIdActividadPersonal());
            ap.setEstado(obj.getEstado());
            ap.setPersonalCalificacion(obj.getPersonalCalificacion());
            em.getTransaction().begin();
            em.merge(ap);
            em.getTransaction().commit();
            LogsUtil.LogsApp(oClass, " ::: OK ::: getActualizarActividadesPersonal", ConstantesApp.ERROR_INFO);
            return "0";
        } catch (Exception e) {
            LogsUtil.LogsApp(oClass, " :: ERROR :: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
            return "";
        } finally {
            em.close();
        }
    }

    public String getRegistrarAsistencias(Asistencias obj) {
        try {
            _init();
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            String oResultSet = "0";
            //LogsUtil.LogsApp(oClass, " ::: OK ::: getRegistrarAsistencias", ConstantesApp.ERROR_INFO);
            return oResultSet;
        } catch (Exception e) {
            LogsUtil.LogsApp(oClass, " :: ERROR :: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
            return "";
        } finally {
            em.close();
        }
    }

}