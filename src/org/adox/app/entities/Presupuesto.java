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
@Table(name = "presupuesto")
@NamedQueries({
    @NamedQuery(name = "Presupuesto.findAll", query = "SELECT p FROM Presupuesto p")})
public class Presupuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpresupuesto")
    private Integer idpresupuesto;
    @Column(name = "presupuesto")
    private String presupuesto;
    @Column(name = "mes")
    private String mes;
    @Column(name = "anio")
    private String anio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "haber")
    private BigDecimal haber;
    @Column(name = "debe")
    private BigDecimal debe;
    @Column(name = "Total")
    private BigDecimal total;
    @Column(name = "a")
    private BigDecimal a;
    @Column(name = "a1")
    private BigDecimal a1;
    @Column(name = "h")
    private BigDecimal h;
    @Column(name = "h1")
    private BigDecimal h1;
    @Column(name = "i")
    private BigDecimal i;
    @Column(name = "i1")
    private BigDecimal i1;
    @Column(name = "l")
    private BigDecimal l;
    @Column(name = "l1")
    private BigDecimal l1;
    @Column(name = "m")
    private BigDecimal m;
    @Column(name = "m1")
    private BigDecimal m1;
    @Column(name = "n")
    private BigDecimal n;
    @Column(name = "n1")
    private BigDecimal n1;
    @Column(name = "oo")
    private BigDecimal oo;
    @Column(name = "oo1")
    private BigDecimal oo1;
    @Column(name = "p")
    private BigDecimal p;
    @Column(name = "p1")
    private BigDecimal p1;
    @Column(name = "ro")
    private BigDecimal ro;
    @Column(name = "ro1")
    private BigDecimal ro1;
    @Column(name = "u")
    private BigDecimal u;
    @Column(name = "u1")
    private BigDecimal u1;
    @Column(name = "v")
    private BigDecimal v;
    @Column(name = "v1")
    private BigDecimal v1;
    @Column(name = "w")
    private BigDecimal w;
    @Column(name = "w1")
    private BigDecimal w1;

    public Presupuesto() {
    }

    public Presupuesto(Integer idpresupuesto) {
        this.idpresupuesto = idpresupuesto;
    }

    public Integer getIdpresupuesto() {
        return idpresupuesto;
    }

    public void setIdpresupuesto(Integer idpresupuesto) {
        this.idpresupuesto = idpresupuesto;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public BigDecimal getHaber() {
        return haber;
    }

    public void setHaber(BigDecimal haber) {
        this.haber = haber;
    }

    public BigDecimal getDebe() {
        return debe;
    }

    public void setDebe(BigDecimal debe) {
        this.debe = debe;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getA() {
        return a;
    }

    public void setA(BigDecimal a) {
        this.a = a;
    }

    public BigDecimal getA1() {
        return a1;
    }

    public void setA1(BigDecimal a1) {
        this.a1 = a1;
    }

    public BigDecimal getH() {
        return h;
    }

    public void setH(BigDecimal h) {
        this.h = h;
    }

    public BigDecimal getH1() {
        return h1;
    }

    public void setH1(BigDecimal h1) {
        this.h1 = h1;
    }

    public BigDecimal getI() {
        return i;
    }

    public void setI(BigDecimal i) {
        this.i = i;
    }

    public BigDecimal getI1() {
        return i1;
    }

    public void setI1(BigDecimal i1) {
        this.i1 = i1;
    }

    public BigDecimal getL() {
        return l;
    }

    public void setL(BigDecimal l) {
        this.l = l;
    }

    public BigDecimal getL1() {
        return l1;
    }

    public void setL1(BigDecimal l1) {
        this.l1 = l1;
    }

    public BigDecimal getM() {
        return m;
    }

    public void setM(BigDecimal m) {
        this.m = m;
    }

    public BigDecimal getM1() {
        return m1;
    }

    public void setM1(BigDecimal m1) {
        this.m1 = m1;
    }

    public BigDecimal getN() {
        return n;
    }

    public void setN(BigDecimal n) {
        this.n = n;
    }

    public BigDecimal getN1() {
        return n1;
    }

    public void setN1(BigDecimal n1) {
        this.n1 = n1;
    }

    public BigDecimal getOo() {
        return oo;
    }

    public void setOo(BigDecimal oo) {
        this.oo = oo;
    }

    public BigDecimal getOo1() {
        return oo1;
    }

    public void setOo1(BigDecimal oo1) {
        this.oo1 = oo1;
    }

    public BigDecimal getP() {
        return p;
    }

    public void setP(BigDecimal p) {
        this.p = p;
    }

    public BigDecimal getP1() {
        return p1;
    }

    public void setP1(BigDecimal p1) {
        this.p1 = p1;
    }

    public BigDecimal getRo() {
        return ro;
    }

    public void setRo(BigDecimal ro) {
        this.ro = ro;
    }

    public BigDecimal getRo1() {
        return ro1;
    }

    public void setRo1(BigDecimal ro1) {
        this.ro1 = ro1;
    }

    public BigDecimal getU() {
        return u;
    }

    public void setU(BigDecimal u) {
        this.u = u;
    }

    public BigDecimal getU1() {
        return u1;
    }

    public void setU1(BigDecimal u1) {
        this.u1 = u1;
    }

    public BigDecimal getV() {
        return v;
    }

    public void setV(BigDecimal v) {
        this.v = v;
    }

    public BigDecimal getV1() {
        return v1;
    }

    public void setV1(BigDecimal v1) {
        this.v1 = v1;
    }

    public BigDecimal getW() {
        return w;
    }

    public void setW(BigDecimal w) {
        this.w = w;
    }

    public BigDecimal getW1() {
        return w1;
    }

    public void setW1(BigDecimal w1) {
        this.w1 = w1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpresupuesto != null ? idpresupuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presupuesto)) {
            return false;
        }
        Presupuesto other = (Presupuesto) object;
        if ((this.idpresupuesto == null && other.idpresupuesto != null) || (this.idpresupuesto != null && !this.idpresupuesto.equals(other.idpresupuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.adox.app.entities.Presupuesto[ idpresupuesto=" + idpresupuesto + " ]";
    }
    
}
