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
@Table(name = "rptasistencias")
@NamedQueries({
    @NamedQuery(name = "Rptasistencias.findAll", query = "SELECT r FROM Rptasistencias r")})
public class Rptasistencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Mes")
    private String mes;
    @Column(name = "Ano")
    private Integer ano;
    @Column(name = "idPersonal")
    private Integer idPersonal;
    @Column(name = "Paterno")
    private String paterno;
    @Column(name = "Materno")
    private String materno;
    @Column(name = "Nombres")
    private String nombres;
    @Column(name = "Cargo")
    private String cargo;
    @Column(name = "d1")
    private Integer d1;
    @Column(name = "d2")
    private Integer d2;
    @Column(name = "d3")
    private Integer d3;
    @Column(name = "d4")
    private Integer d4;
    @Column(name = "d5")
    private Integer d5;
    @Column(name = "d6")
    private Integer d6;
    @Column(name = "d7")
    private Integer d7;
    @Column(name = "d8")
    private Integer d8;
    @Column(name = "d9")
    private Integer d9;
    @Column(name = "d10")
    private Integer d10;
    @Column(name = "d11")
    private Integer d11;
    @Column(name = "d12")
    private Integer d12;
    @Column(name = "d13")
    private Integer d13;
    @Column(name = "d14")
    private Integer d14;
    @Column(name = "d15")
    private Integer d15;
    @Column(name = "d16")
    private Integer d16;
    @Column(name = "d17")
    private Integer d17;
    @Column(name = "d18")
    private Integer d18;
    @Column(name = "d19")
    private Integer d19;
    @Column(name = "d20")
    private Integer d20;
    @Column(name = "d21")
    private Integer d21;
    @Column(name = "d22")
    private Integer d22;
    @Column(name = "d23")
    private Integer d23;
    @Column(name = "d24")
    private Integer d24;
    @Column(name = "d25")
    private Integer d25;
    @Column(name = "d26")
    private Integer d26;
    @Column(name = "d27")
    private Integer d27;
    @Column(name = "d28")
    private Integer d28;
    @Column(name = "d29")
    private Integer d29;
    @Column(name = "d30")
    private Integer d30;
    @Column(name = "d31")
    private Integer d31;
    @Column(name = "Asistencias")
    private Integer asistencias;
    @Column(name = "Inasistencias")
    private Integer inasistencias;
    @Column(name = "Feriados")
    private Integer feriados;
    @Column(name = "tardanzas")
    private Integer tardanzas;

    public Rptasistencias() {
    }

    public Rptasistencias(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getD1() {
        return d1;
    }

    public void setD1(Integer d1) {
        this.d1 = d1;
    }

    public Integer getD2() {
        return d2;
    }

    public void setD2(Integer d2) {
        this.d2 = d2;
    }

    public Integer getD3() {
        return d3;
    }

    public void setD3(Integer d3) {
        this.d3 = d3;
    }

    public Integer getD4() {
        return d4;
    }

    public void setD4(Integer d4) {
        this.d4 = d4;
    }

    public Integer getD5() {
        return d5;
    }

    public void setD5(Integer d5) {
        this.d5 = d5;
    }

    public Integer getD6() {
        return d6;
    }

    public void setD6(Integer d6) {
        this.d6 = d6;
    }

    public Integer getD7() {
        return d7;
    }

    public void setD7(Integer d7) {
        this.d7 = d7;
    }

    public Integer getD8() {
        return d8;
    }

    public void setD8(Integer d8) {
        this.d8 = d8;
    }

    public Integer getD9() {
        return d9;
    }

    public void setD9(Integer d9) {
        this.d9 = d9;
    }

    public Integer getD10() {
        return d10;
    }

    public void setD10(Integer d10) {
        this.d10 = d10;
    }

    public Integer getD11() {
        return d11;
    }

    public void setD11(Integer d11) {
        this.d11 = d11;
    }

    public Integer getD12() {
        return d12;
    }

    public void setD12(Integer d12) {
        this.d12 = d12;
    }

    public Integer getD13() {
        return d13;
    }

    public void setD13(Integer d13) {
        this.d13 = d13;
    }

    public Integer getD14() {
        return d14;
    }

    public void setD14(Integer d14) {
        this.d14 = d14;
    }

    public Integer getD15() {
        return d15;
    }

    public void setD15(Integer d15) {
        this.d15 = d15;
    }

    public Integer getD16() {
        return d16;
    }

    public void setD16(Integer d16) {
        this.d16 = d16;
    }

    public Integer getD17() {
        return d17;
    }

    public void setD17(Integer d17) {
        this.d17 = d17;
    }

    public Integer getD18() {
        return d18;
    }

    public void setD18(Integer d18) {
        this.d18 = d18;
    }

    public Integer getD19() {
        return d19;
    }

    public void setD19(Integer d19) {
        this.d19 = d19;
    }

    public Integer getD20() {
        return d20;
    }

    public void setD20(Integer d20) {
        this.d20 = d20;
    }

    public Integer getD21() {
        return d21;
    }

    public void setD21(Integer d21) {
        this.d21 = d21;
    }

    public Integer getD22() {
        return d22;
    }

    public void setD22(Integer d22) {
        this.d22 = d22;
    }

    public Integer getD23() {
        return d23;
    }

    public void setD23(Integer d23) {
        this.d23 = d23;
    }

    public Integer getD24() {
        return d24;
    }

    public void setD24(Integer d24) {
        this.d24 = d24;
    }

    public Integer getD25() {
        return d25;
    }

    public void setD25(Integer d25) {
        this.d25 = d25;
    }

    public Integer getD26() {
        return d26;
    }

    public void setD26(Integer d26) {
        this.d26 = d26;
    }

    public Integer getD27() {
        return d27;
    }

    public void setD27(Integer d27) {
        this.d27 = d27;
    }

    public Integer getD28() {
        return d28;
    }

    public void setD28(Integer d28) {
        this.d28 = d28;
    }

    public Integer getD29() {
        return d29;
    }

    public void setD29(Integer d29) {
        this.d29 = d29;
    }

    public Integer getD30() {
        return d30;
    }

    public void setD30(Integer d30) {
        this.d30 = d30;
    }

    public Integer getD31() {
        return d31;
    }

    public void setD31(Integer d31) {
        this.d31 = d31;
    }

    public Integer getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(Integer asistencias) {
        this.asistencias = asistencias;
    }

    public Integer getInasistencias() {
        return inasistencias;
    }

    public void setInasistencias(Integer inasistencias) {
        this.inasistencias = inasistencias;
    }

    public Integer getFeriados() {
        return feriados;
    }

    public void setFeriados(Integer feriados) {
        this.feriados = feriados;
    }

    public Integer getTardanzas() {
        return tardanzas;
    }

    public void setTardanzas(Integer tardanzas) {
        this.tardanzas = tardanzas;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rptasistencias)) {
            return false;
        }
        Rptasistencias other = (Rptasistencias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.adox.app.entities.Rptasistencias[ id=" + id + " ]";
    }
    
}
