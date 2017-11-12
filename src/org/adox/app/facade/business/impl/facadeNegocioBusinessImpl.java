package org.adox.app.facade.business.impl;

import org.adox.app.facade.business.dto.UsuarioSesion;
import org.adox.app.facade.business.facadeNegocioBusiness;
import org.adox.app.facade.dao.facadeNegocioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version V1
 * @author Adolfo Villanueva
 */
@Service(value = "facadeNegocioBusiness")
public class facadeNegocioBusinessImpl implements facadeNegocioBusiness {

    @Autowired
    private facadeNegocioDao ofacadeNegocioDao;

    public facadeNegocioDao getOfacadeNegocioDao() {
        return ofacadeNegocioDao;
    }

    public void setOfacadeNegocioDao(facadeNegocioDao ofacadeNegocioDao) {
        this.ofacadeNegocioDao = ofacadeNegocioDao;
    }

    @Override
    public UsuarioSesion getValidarLogeo(String usuario, String clave, String idOficina) {
//        String idOficina = oAplicacionDao.getObtenerIdOficina(Oficina);
        return ofacadeNegocioDao.getValidarLogeo(usuario, clave, idOficina);
    }

    /*@Autowired
     private facadeAplicacionDao ofacadeAplicacionDao;
    
     //// GET Y SET A MIS FACADE DAO  
     public facadeAplicacionDao getOfacadeAplicacionDao() {
     return ofacadeAplicacionDao;
     }

     public void setOfacadeAplicacionDao(facadeAplicacionDao ofacadeAplicacionDao) {
     this.ofacadeAplicacionDao = ofacadeAplicacionDao;
     }*/
}
