package org.adox.app.facade.business.dto;

/**
 * @version V1
 * @author Adolfo Villanueva
 */
public class Tabla {

    private String id;
    private String descripcion;

    public Tabla() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
