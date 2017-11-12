/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.adox.app.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ADOLFO
 */
@Entity
@Table(name = "tabla")
@NamedQueries({
    @NamedQuery(name = "Tabla.findAll", query = "SELECT t FROM Tabla t")})
public class Tabla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtabla")
    private Integer idtabla;
    @Basic(optional = false)
    @Column(name = "tabla")
    private String tabla;
    @Column(name = "desctabla")
    private String desctabla;
    @Basic(optional = false)
    @Column(name = "estado")
    private int estado;

    public Tabla() {
    }

    public Tabla(Integer idtabla) {
        this.idtabla = idtabla;
    }

    public Tabla(Integer idtabla, String tabla, int estado) {
        this.idtabla = idtabla;
        this.tabla = tabla;
        this.estado = estado;
    }

    public Integer getIdtabla() {
        return idtabla;
    }

    public void setIdtabla(Integer idtabla) {
        this.idtabla = idtabla;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getDesctabla() {
        return desctabla;
    }

    public void setDesctabla(String desctabla) {
        this.desctabla = desctabla;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtabla != null ? idtabla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabla)) {
            return false;
        }
        Tabla other = (Tabla) object;
        if ((this.idtabla == null && other.idtabla != null) || (this.idtabla != null && !this.idtabla.equals(other.idtabla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.adox.app.entities.Tabla[ idtabla=" + idtabla + " ]";
    }
    
}
