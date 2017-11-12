package org.adox.app.facade.business;

import org.adox.app.facade.business.dto.UsuarioSesion;

/**
 * @version V1
 * @author Adolfo Villanueva
 */
public interface facadeNegocioBusiness {

    public UsuarioSesion getValidarLogeo(String usuario, String clave, String Empresa);

}
