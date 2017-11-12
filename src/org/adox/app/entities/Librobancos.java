/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.adox.app.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "librobancos")
@NamedQueries({
    @NamedQuery(name = "Librobancos.findAll", query = "SELECT l FROM Librobancos l")})
public class Librobancos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlibrobancos")
    private Integer idlibrobancos;
    @Column(name = "presupuesto")
    private String presupuesto;
    @Column(name = "beneficiario")
    private String beneficiario;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "siaf")
    private String siaf;
    @Column(name = "cheque")
    private String cheque;
    @Column(name = "cp")
    private String cp;
    @Column(name = "tr")
    private String tr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "debe")
    private BigDecimal debe;
    @Column(name = "haber")
    private BigDecimal haber;
    @Column(name = "presupuestoactual")
    private BigDecimal presupuestoactual;

    public Librobancos() {
    }

    public Librobancos(Integer idlibrobancos) {
        this.idlibrobancos = idlibrobancos;
    }

    public Integer getIdlibrobancos() {
        return idlibrobancos;
    }

    public void setIdlibrobancos(Integer idlibrobancos) {
        this.idlibrobancos = idlibrobancos;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSiaf() {
        return siaf;
    }

    public void setSiaf(String siaf) {
        this.siaf = siaf;
    }

    public String getCheque() {
        return cheque;
    }

    public void setCheque(String cheque) {
        this.cheque = cheque;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getTr() {
        return tr;
    }

    public void setTr(String tr) {
        this.tr = tr;
    }

    public BigDecimal getDebe() {
        return debe;
    }

    public void setDebe(BigDecimal debe) {
        this.debe = debe;
    }

    public BigDecimal getHaber() {
        return haber;
    }

    public void setHaber(BigDecimal haber) {
        this.haber = haber;
    }

    public BigDecimal getPresupuestoactual() {
        return presupuestoactual;
    }

    public void setPresupuestoactual(BigDecimal presupuestoactual) {
        this.presupuestoactual = presupuestoactual;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlibrobancos != null ? idlibrobancos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Librobancos)) {
            return false;
        }
        Librobancos other = (Librobancos) object;
        if ((this.idlibrobancos == null && other.idlibrobancos != null) || (this.idlibrobancos != null && !this.idlibrobancos.equals(other.idlibrobancos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.adox.app.entities.Librobancos[ idlibrobancos=" + idlibrobancos + " ]";
    }
    
}
