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
@Table(name = "asistencias")
@NamedQueries({
    @NamedQuery(name = "Asistencias.findAll", query = "SELECT a FROM Asistencias a")})
public class Asistencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idasistencias")
    private Integer idasistencias;
    @Column(name = "idpersonal")
    private Integer idpersonal;
    @Column(name = "nrodocumento")
    private String nrodocumento;
    @Column(name = "personal")
    private String personal;
    @Column(name = "hingreso")
    private String hingreso;
    @Column(name = "hsalidarefrigerio")
    private String hsalidarefrigerio;
    @Column(name = "hentradarefrigerio")
    private String hentradarefrigerio;
    @Column(name = "hsalida")
    private String hsalida;
    @Column(name = "tardanza")
    private Integer tardanza;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "falta")
    private String falta;
    @Column(name = "permisos")
    private String permisos;
    @Column(name = "justificacion")
    private String justificacion;

    public Asistencias() {
    }

    public Asistencias(Integer idasistencias) {
        this.idasistencias = idasistencias;
    }

    public Integer getIdasistencias() {
        return idasistencias;
    }

    public void setIdasistencias(Integer idasistencias) {
        this.idasistencias = idasistencias;
    }

    public Integer getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    public String getNrodocumento() {
        return nrodocumento;
    }

    public void setNrodocumento(String nrodocumento) {
        this.nrodocumento = nrodocumento;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public String getHingreso() {
        return hingreso;
    }

    public void setHingreso(String hingreso) {
        this.hingreso = hingreso;
    }

    public String getHsalidarefrigerio() {
        return hsalidarefrigerio;
    }

    public void setHsalidarefrigerio(String hsalidarefrigerio) {
        this.hsalidarefrigerio = hsalidarefrigerio;
    }

    public String getHentradarefrigerio() {
        return hentradarefrigerio;
    }

    public void setHentradarefrigerio(String hentradarefrigerio) {
        this.hentradarefrigerio = hentradarefrigerio;
    }

    public String getHsalida() {
        return hsalida;
    }

    public void setHsalida(String hsalida) {
        this.hsalida = hsalida;
    }

    public Integer getTardanza() {
        return tardanza;
    }

    public void setTardanza(Integer tardanza) {
        this.tardanza = tardanza;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFalta() {
        return falta;
    }

    public void setFalta(String falta) {
        this.falta = falta;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasistencias != null ? idasistencias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistencias)) {
            return false;
        }
        Asistencias other = (Asistencias) object;
        if ((this.idasistencias == null && other.idasistencias != null) || (this.idasistencias != null && !this.idasistencias.equals(other.idasistencias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.adox.app.entities.Asistencias[ idasistencias=" + idasistencias + " ]";
    }
    
}
