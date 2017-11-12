package org.adox.app.facade.business.dto;

import java.io.Serializable;

/**
 * @version V1
 * @author Adolfo Villanueva
 */
public class dtoTabla implements Serializable{

    private String id;
    private String idCabeceraTabla;
    private String idCodTabla;
    private String descripcion;

    public dtoTabla() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCabeceraTabla() {
        return idCabeceraTabla;
    }

    public void setIdCabeceraTabla(String idCabeceraTabla) {
        this.idCabeceraTabla = idCabeceraTabla;
    }

    public String getIdCodTabla() {
        return idCodTabla;
    }

    public void setIdCodTabla(String idCodTabla) {
        this.idCodTabla = idCodTabla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
