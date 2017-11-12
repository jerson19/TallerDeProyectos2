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
@Table(name = "cuentas")
@NamedQueries({
    @NamedQuery(name = "Cuentas.findAll", query = "SELECT c FROM Cuentas c")})
public class Cuentas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcuentas")
    private Integer idcuentas;
    @Column(name = "idpersonal")
    private Integer idpersonal;
    @Column(name = "idtipobanco")
    private Integer idtipobanco;
    @Column(name = "idbanco")
    private Integer idbanco;
    @Column(name = "cuenta")
    private String cuenta;
    @Column(name = "estado")
    private Integer estado;

    public Cuentas() {
    }

    public Cuentas(Integer idcuentas) {
        this.idcuentas = idcuentas;
    }

    public Integer getIdcuentas() {
        return idcuentas;
    }

    public void setIdcuentas(Integer idcuentas) {
        this.idcuentas = idcuentas;
    }

    public Integer getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    public Integer getIdtipobanco() {
        return idtipobanco;
    }

    public void setIdtipobanco(Integer idtipobanco) {
        this.idtipobanco = idtipobanco;
    }

    public Integer getIdbanco() {
        return idbanco;
    }

    public void setIdbanco(Integer idbanco) {
        this.idbanco = idbanco;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
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
        hash += (idcuentas != null ? idcuentas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuentas)) {
            return false;
        }
        Cuentas other = (Cuentas) object;
        if ((this.idcuentas == null && other.idcuentas != null) || (this.idcuentas != null && !this.idcuentas.equals(other.idcuentas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.adox.app.entities.Cuentas[ idcuentas=" + idcuentas + " ]";
    }
    
}
