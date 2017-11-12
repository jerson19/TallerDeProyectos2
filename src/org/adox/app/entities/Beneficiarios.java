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
@Table(name = "beneficiarios")
@NamedQueries({
    @NamedQuery(name = "Beneficiarios.findAll", query = "SELECT b FROM Beneficiarios b")})
public class Beneficiarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private Integer codigo;
    @Column(name = "PPTO")
    private Integer ppto;
    @Column(name = "ESPECIFICA")
    private String especifica;
    @Column(name = "CLUB_MADRE")
    private String clubMadre;
    @Column(name = "NINOS_0_6")
    private Integer ninos06;
    @Column(name = "NINOS_7_13")
    private Integer ninos713;
    @Column(name = "MADRES_G_L")
    private Integer madresGL;
    @Column(name = "OTROS_A_TBC")
    private Integer otrosATbc;
    @Column(name = "TOTAL")
    private Integer total;
    @Column(name = "RESPONSABLE")
    private String responsable;
    @Column(name = "CARGO")
    private String cargo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LK01")
    private BigDecimal lk01;
    @Column(name = "LK02")
    private BigDecimal lk02;
    @Column(name = "LP01")
    private BigDecimal lp01;
    @Column(name = "LP02")
    private BigDecimal lp02;
    @Column(name = "TT01")
    private BigDecimal tt01;
    @Column(name = "TT02")
    private BigDecimal tt02;
    @Column(name = "TP01")
    private BigDecimal tp01;
    @Column(name = "TP02")
    private BigDecimal tp02;
    @Column(name = "BIMESTRE")
    private Integer bimestre;

    public Beneficiarios() {
    }

    public Beneficiarios(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getPpto() {
        return ppto;
    }

    public void setPpto(Integer ppto) {
        this.ppto = ppto;
    }

    public String getEspecifica() {
        return especifica;
    }

    public void setEspecifica(String especifica) {
        this.especifica = especifica;
    }

    public String getClubMadre() {
        return clubMadre;
    }

    public void setClubMadre(String clubMadre) {
        this.clubMadre = clubMadre;
    }

    public Integer getNinos06() {
        return ninos06;
    }

    public void setNinos06(Integer ninos06) {
        this.ninos06 = ninos06;
    }

    public Integer getNinos713() {
        return ninos713;
    }

    public void setNinos713(Integer ninos713) {
        this.ninos713 = ninos713;
    }

    public Integer getMadresGL() {
        return madresGL;
    }

    public void setMadresGL(Integer madresGL) {
        this.madresGL = madresGL;
    }

    public Integer getOtrosATbc() {
        return otrosATbc;
    }

    public void setOtrosATbc(Integer otrosATbc) {
        this.otrosATbc = otrosATbc;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getLk01() {
        return lk01;
    }

    public void setLk01(BigDecimal lk01) {
        this.lk01 = lk01;
    }

    public BigDecimal getLk02() {
        return lk02;
    }

    public void setLk02(BigDecimal lk02) {
        this.lk02 = lk02;
    }

    public BigDecimal getLp01() {
        return lp01;
    }

    public void setLp01(BigDecimal lp01) {
        this.lp01 = lp01;
    }

    public BigDecimal getLp02() {
        return lp02;
    }

    public void setLp02(BigDecimal lp02) {
        this.lp02 = lp02;
    }

    public BigDecimal getTt01() {
        return tt01;
    }

    public void setTt01(BigDecimal tt01) {
        this.tt01 = tt01;
    }

    public BigDecimal getTt02() {
        return tt02;
    }

    public void setTt02(BigDecimal tt02) {
        this.tt02 = tt02;
    }

    public BigDecimal getTp01() {
        return tp01;
    }

    public void setTp01(BigDecimal tp01) {
        this.tp01 = tp01;
    }

    public BigDecimal getTp02() {
        return tp02;
    }

    public void setTp02(BigDecimal tp02) {
        this.tp02 = tp02;
    }

    public Integer getBimestre() {
        return bimestre;
    }

    public void setBimestre(Integer bimestre) {
        this.bimestre = bimestre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beneficiarios)) {
            return false;
        }
        Beneficiarios other = (Beneficiarios) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.adox.app.entities.Beneficiarios[ codigo=" + codigo + " ]";
    }
    
}
