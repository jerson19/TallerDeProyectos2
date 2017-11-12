/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.adox.app.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ADOLFO
 */
@Entity
@Table(name = "actividadpersonal")
@NamedQueries({
    @NamedQuery(name = "Actividadpersonal.findAll", query = "SELECT a FROM Actividadpersonal a")})
public class Actividadpersonal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idActividadPersonal")
    private Integer idActividadPersonal;
    @Column(name = "Actividad")
    private String actividad;
    @Column(name = "Cantidad")
    private Integer cantidad;
    @Column(name = "Comentario")
    private String comentario;
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "idPersonal")
    private Integer idPersonal;
    @Column(name = "Personal")
    private String personal;
    @Column(name = "personalCalificacion")
    private String personalCalificacion;

    public Actividadpersonal() {
    }

    public Actividadpersonal(Integer idActividadPersonal) {
        this.idActividadPersonal = idActividadPersonal;
    }

    public Integer getIdActividadPersonal() {
        return idActividadPersonal;
    }

    public void setIdActividadPersonal(Integer idActividadPersonal) {
        this.idActividadPersonal = idActividadPersonal;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public String getPersonalCalificacion() {
        return personalCalificacion;
    }

    public void setPersonalCalificacion(String personalCalificacion) {
        this.personalCalificacion = personalCalificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActividadPersonal != null ? idActividadPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividadpersonal)) {
            return false;
        }
        Actividadpersonal other = (Actividadpersonal) object;
        if ((this.idActividadPersonal == null && other.idActividadPersonal != null) || (this.idActividadPersonal != null && !this.idActividadPersonal.equals(other.idActividadPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.adox.app.entities.Actividadpersonal[ idActividadPersonal=" + idActividadPersonal + " ]";
    }
    
}
