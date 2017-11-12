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
@Table(name = "rolmenu")
@NamedQueries({
    @NamedQuery(name = "Rolmenu.findAll", query = "SELECT r FROM Rolmenu r")})
public class Rolmenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrolmenu")
    private Integer idrolmenu;
    @Column(name = "idrol")
    private Integer idrol;
    @Column(name = "idmenu")
    private Integer idmenu;
    @Column(name = "estado")
    private Integer estado;

    public Rolmenu() {
    }

    public Rolmenu(Integer idrolmenu) {
        this.idrolmenu = idrolmenu;
    }

    public Integer getIdrolmenu() {
        return idrolmenu;
    }

    public void setIdrolmenu(Integer idrolmenu) {
        this.idrolmenu = idrolmenu;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public Integer getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrolmenu != null ? idrolmenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rolmenu)) {
            return false;
        }
        Rolmenu other = (Rolmenu) object;
        if ((this.idrolmenu == null && other.idrolmenu != null) || (this.idrolmenu != null && !this.idrolmenu.equals(other.idrolmenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.adox.app.entities.Rolmenu[ idrolmenu=" + idrolmenu + " ]";
    }
    
}
