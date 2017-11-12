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
@Table(name = "subtabla")
@NamedQueries({
    @NamedQuery(name = "Subtabla.findAll", query = "SELECT s FROM Subtabla s")})
public class Subtabla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsubtabla")
    private Integer idsubtabla;
    @Basic(optional = false)
    @Column(name = "idtabla")
    private int idtabla;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "codpadre")
    private String codpadre;
    @Basic(optional = false)
    @Column(name = "estado")
    private int estado;

    public Subtabla() {
    }

    public Subtabla(Integer idsubtabla) {
        this.idsubtabla = idsubtabla;
    }

    public Subtabla(Integer idsubtabla, int idtabla, String codigo, int estado) {
        this.idsubtabla = idsubtabla;
        this.idtabla = idtabla;
        this.codigo = codigo;
        this.estado = estado;
    }

    public Integer getIdsubtabla() {
        return idsubtabla;
    }

    public void setIdsubtabla(Integer idsubtabla) {
        this.idsubtabla = idsubtabla;
    }

    public int getIdtabla() {
        return idtabla;
    }

    public void setIdtabla(int idtabla) {
        this.idtabla = idtabla;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodpadre() {
        return codpadre;
    }

    public void setCodpadre(String codpadre) {
        this.codpadre = codpadre;
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
        hash += (idsubtabla != null ? idsubtabla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subtabla)) {
            return false;
        }
        Subtabla other = (Subtabla) object;
        if ((this.idsubtabla == null && other.idsubtabla != null) || (this.idsubtabla != null && !this.idsubtabla.equals(other.idsubtabla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.adox.app.entities.Subtabla[ idsubtabla=" + idsubtabla + " ]";
    }
    
}
