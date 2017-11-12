package org.adox.app.facade.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.adox.app.common.ConstantesApp;
import org.adox.app.config.jdbc._Querys;
import org.adox.app.entities.Empresa;
import org.adox.app.facade.business.dto.Tabla;
import org.adox.app.facade.dao.facadeAplicacionDao;
import org.adox.app.util.DateUtil;
import org.adox.app.util.LogsUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @version V1
 * @author Adolfo Villanueva
 */
@Repository(value = "facadeAplicacionDao")
public class facadeAplicacionDaoImpl extends _Querys implements facadeAplicacionDao {
    
    static Logger oClass = Logger.getLogger("facadeAplicacionDaoImpl");

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
        EntityManager ema = entityManagerFactory.createEntityManager();
    }

    /* CONEXION */
    @Override
    public boolean getObtenerConexion() {
        LogsUtil.Show(oClass, "::: getObtenerConexion() ::: Sincronizando Hora con el Servidor");
        _init();
        //METODO PARA SINCRONIZAR LA FECHA Y HORA DEL CLIENTE SERVIDOR
        DateUtil.getFechaHora_Servidor_Cliente(getObtenerFechaHoraServidor());
        List<Empresa> list = getObtenerOficinas();
        if (list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public EntityManager getObtenerConexionPU() {
        _init();
        return em;
    }

    /* FECHAS */
    @Override
    public Date getObtenerFecha() {
        return null;
    }

    @Override
    public String getObtenerFechaHoraServidor() {
        String fechaHoraServidor = "";
        try {
            LogsUtil.Show(oClass, " ::: METODO ::: getObtenerFechaHoraServidor");
            _init();
            Query q = em.createNativeQuery("SELECT SYSDATE()");
            Date fhServidor = (Date) q.getSingleResult();
            fechaHoraServidor = "" + fhServidor;
            LogsUtil.LogsApp(oClass, " ::: OK ::: getObtenerFechaHoraServidor " + fechaHoraServidor, ConstantesApp.ERROR_INFO);
        } catch (Exception e) {
            LogsUtil.LogsApp(oClass, " :: ERROR :: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
        } finally {
            emf.close();
            em.close();
        }
        return fechaHoraServidor;
    }

    /* TABLAS CODIGO DESCRIPCION*/
    @Override
    public List<Tabla> getObtenerDescripcion(String idPadre) {
        List<Tabla> lista = new ArrayList<Tabla>();
        try {
            LogsUtil.Show(oClass, " ::: METODO ::: getObtenerDescripcion");
            _init();
            Query q = em.createNativeQuery(QueryObtenerDescripcion(oClass, idPadre));
            List list = q.getResultList();
            for (Object oObject : list) {
                Object[] fila = (Object[]) oObject;
                Tabla obj = new Tabla();
                obj.setId(fila[0].toString());
                obj.setDescripcion(fila[1].toString());
                lista.add(obj);
            }
        } catch (Exception e) {
            LogsUtil.LogsApp(oClass, " :: ERROR :: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
        } finally {
            emf.close();
            em.close();
            LogsUtil.LogsApp(oClass, " ::: OK ::: getObtenerDescripcion", ConstantesApp.ERROR_INFO);
        }
        return lista;
    }

    @Override
    public String getObtenerIdDescripcion(String descripcion, String idTabla) {
        String id = "0";
        try {
            LogsUtil.Show(oClass, " ::: METODO ::: getObtenerIdDescripcion");
            _init();
            Query q = em.createNativeQuery(QueryObtenerIdDescripcion(oClass, descripcion, idTabla));
            List list = q.getResultList();
            for (Object oObject : list) {
                Object[] fila = (Object[]) oObject;
                id = fila[0].toString();
            }
        } catch (Exception e) {
            LogsUtil.LogsApp(oClass, " :: ERROR :: " + e.getMessage(), ConstantesApp.ERROR_ERROR);
            return id;
        } finally {
            emf.close();
            em.close();
            LogsUtil.LogsApp(oClass, " ::: OK ::: getObtenerIdDescripcion", ConstantesApp.ERROR_INFO);
        }
        return id;
    }

    /* TABLA EMPRESA */
    @Override
    public List<Empresa> getObtenerEmpresas() {
        List<Empresa> lista = new ArrayList<Empresa>();
        try {
            LogsUtil.Show(oClass, " ::: METODO ::: getObtenerEmpresas ");
            _init();
            Query q = em.createNativeQuery(QueryObtenerEmpresas(oClass));
            List list = q.getResultList();
            for (Object oObject : list) {
                Object[] fila = (Object[]) oObject;
                Empresa obj = new Empresa();
                obj.setIdEmpresa(Integer.parseInt(fila[0].toString()));
                obj.setRazonSocial(fila[1].toString());
                lista.add(obj);
            }
        } catch (Exception e) {
            LogsUtil.LogsApp(oClass, " :: ERROR ::  " + e.getMessage(), ConstantesApp.ERROR_ERROR);
        } finally {
            emf.close();
            em.close();
            LogsUtil.LogsApp(oClass, " ::: OK ::: getObtenerEmpresas", ConstantesApp.ERROR_INFO);
        }
        return lista;
    }

    @Override
    public String getObtenerIdEmpresa(String Empresa) {
        String idEmpresa = "0";
        try {
            LogsUtil.Show(oClass, " ::: METODO ::: getObtenerIdEmpresa");
            Query q = em.createNativeQuery(QueryObtenerIdEmpresa(oClass, Empresa));
            List list = q.getResultList();
            for (Object oObject : list) {
                Object[] fila = (Object[]) oObject;
                idEmpresa = fila[0].toString();
            }
        } catch (Exception e) {
            LogsUtil.LogsApp(oClass, " :: ERROR ::  " + e.getMessage(), ConstantesApp.ERROR_ERROR);
        } finally {
            emf.close();
            em.close();
            LogsUtil.LogsApp(oClass, " ::: OK ::: getObtenerIdEmpresa", ConstantesApp.ERROR_INFO);
        }
        return idEmpresa;
    }

    @Override
    public String getObtenerDescripcionEmpresa(String idEmpresa) {

        String Empresa = "0";
        try {
            LogsUtil.Show(oClass, " ::: METODO ::: getObtenerDescripcionEmpresa");
            _init();
            Query q = em.createNativeQuery(QueryObtenerEmpresas(oClass));
            List list = q.getResultList();
            for (Object oObject : list) {
                Object[] fila = (Object[]) oObject;
                Empresa = fila[0].toString();
            }
        } catch (Exception e) {
            LogsUtil.LogsApp(oClass, " :: ERROR ::  " + e.getMessage(), ConstantesApp.ERROR_ERROR);
        } finally {
            emf.close();
            em.close();
            LogsUtil.LogsApp(oClass, " ::: OK ::: getObtenerDescripcionEmpresa", ConstantesApp.ERROR_INFO);
        }
        return Empresa;
    }

    @Override
    public List<Empresa> getObtenerOficinas() {
        List<Empresa> lista = new ArrayList<Empresa>();
        try {
            LogsUtil.Show(oClass, " ::: METODO ::: getObtenerOficinas");
            _init();
            Query q = em.createNativeQuery(QueryObtenerEmpresas(oClass));
            List list = q.getResultList();
            for (Object oObject : list) {
                Object[] fila = (Object[]) oObject;
                Empresa obj = new Empresa();
                obj.setIdOficina(fila[0].toString());
                obj.setDescOficina(fila[1].toString());
                System.out.println("CODIGO " + fila[0].toString() + " DESCRIPCION " + fila[1].toString());
                lista.add(obj);
            }
        } catch (Exception e) {
            LogsUtil.LogsApp(oClass, " :: ERROR ::  " + e.getMessage(), ConstantesApp.ERROR_ERROR);
        } finally {
            emf.close();
            em.close();
            LogsUtil.LogsApp(oClass, " ::: OK ::: getObtenerOficinas", ConstantesApp.ERROR_INFO);
        }
        return lista;
    }

    @Override
    public String getObtenerIdOficina(String Oficina) {
        String idOficina = "0";
        try {
            LogsUtil.Show(oClass, " ::: METODO ::: getObtenerIdOficina");
            _init();
            Query q = em.createNativeQuery(QueryObtenerIdOficina(oClass, Oficina));
            List list = q.getResultList();
            for (Object oObject : list) {
                Object[] fila = (Object[]) oObject;
                idOficina = fila[0].toString();
            }
        } catch (Exception e) {
            LogsUtil.LogsApp(oClass, " :: ERROR ::  " + e.getMessage(), ConstantesApp.ERROR_ERROR);
        } finally {
            emf.close();
            em.close();
            LogsUtil.LogsApp(oClass, " ::: OK ::: getObtenerIdOficina", ConstantesApp.ERROR_INFO);
        }
        return idOficina;
    }
}
