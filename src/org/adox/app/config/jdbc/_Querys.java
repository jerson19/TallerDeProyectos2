package org.adox.app.config.jdbc;

import org.adox.app.util.LogsUtil;
import org.apache.log4j.Logger;

/**
 * @author Adolfo
 */
public class _Querys {
    //APLICACION

    public String QueryObtenerIdDescripcion(Logger oClass, String descripcion, String idTabla) {
        String query = "SELECT codigo,descripcion FROM subtabla WHERE idtabla='" + idTabla + "' AND descripcion='" + descripcion + "'";
        LogsUtil.Show(oClass, "QueryObtenerIdDescripcion :: " + query);
        return query;
    }

    public String QueryObtenerDescripcion(Logger oClass, String idPadre) {
        String query = "SELECT codigo,descripcion FROM subtabla WHERE idtabla=" + idPadre + " ORDER BY descripcion";
        LogsUtil.Show(oClass, "QueryObtenerDescripcion :: " + query);
        return query;
    }

    public String QueryObtenerOficinas(Logger oClass) {
        String query = "{?=call f_obteneroficina()}";
        LogsUtil.Show(oClass, "QueryObtenerOficinas :: " + query);
        return query;
    }

    public String QueryObtenerEmpresas(Logger oClass) {
        String query = "SELECT idempresa,razonsocial FROM empresa where estado=1";
        LogsUtil.Show(oClass, "QueryObtenerEmpresas :: " + query);
        return query;
    }

    public String QueryObtenerIdEmpresa(Logger oClass, String empresa) {
        String query = "SELECT idempresa FROM empresa WHERE razonsocial='" + empresa + "'";
        LogsUtil.Show(oClass, "QueryObtenerIdEmpresa :: " + query);
        return query;
    }

    public String QueryObtenerIdOficina(Logger oClass, String Oficina) {
        String query = "SELECT idempresa FROM empresa WHERE razonsocial='" + Oficina + "'";
        LogsUtil.Show(oClass, "QueryObtenerIdEmpresa :: " + query);
        return query;
    }
    //VALIDACION DE USUARIO

    public String QueryValidacionUsuario(Logger oClass, String usuario, String clave, String idOficina) {
        String query = "call spValidacionUsuario('" + usuario + "','" + clave + "'," + idOficina + ")";
        LogsUtil.Show(oClass, "QueryValidadcionUsuario :: " + query);
        return query;
    }

    public String QueryBuscarPersonal(Logger oClass, String Descripcion) {
        String query = "call f_buscarPersonal('" + Descripcion + "')";
        LogsUtil.Show(oClass, "QueryBuscarPersonal :: " + query);
        return query;
    }
    
    public String QueryBuscarPersonalAsistencia(Logger oClass) {
        //String query = "SELECT idpersonal,CONCAT(nombre,' ',apepat,' ',apemat) nombres,nrodocumento,huella FROM personal WHERE huella IS NOT NULL";
        String query = "SELECT p FROM Personal p WHERE huella IS NOT NULL";
        LogsUtil.Show(oClass, "QueryBuscarPersonalAsistencia :: " + query);
        return query;
    }    
    
    public String QuerygetBuscarPersonalDni(Logger oClass, String dni) {
        String query = "call f_buscarPersonalDni('" + dni + "')";
        LogsUtil.Show(oClass, "QuerygetBuscarPersonalDni :: " + query);
        return query;
    }

    public String QueryBuscarActividad(Logger oClass, String Actividad) {
        String query = "SELECT * FROM Actividades WHERE actividad LIKE  '%" + Actividad + "%' order by actividad";
        LogsUtil.Show(oClass, "QuerygetBuscarActividad :: " + query);
        return query;
    }

    public String QueryBuscarPersonalCargo(Logger oClass, String Personal) {
        String query = "SELECT idpersonal,CONCAT(nombre,' ',apepat,' ',apemat) personal FROM personal WHERE responsable='" + Personal + "'";
        LogsUtil.Show(oClass, "QuerygetBuscarPersonalCargo :: " + query);
        return query;
    }

    public String QuerygetListarActividadesPersonal(Logger oClass, String Personal) {
        String query = "SELECT idActividadPersonal, Actividad, Cantidad, Comentario, Fecha, estado "
                + "FROM actividadpersonal WHERE personal='" + Personal + "' AND estado=1";
        LogsUtil.Show(oClass, "QuerygetBuscarPersonalCargo :: " + query);
        return query;
    }
}
