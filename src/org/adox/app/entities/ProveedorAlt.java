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
import javax.persistence.Lob;
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
@Table(name = "proveedor_alt")
@NamedQueries({
    @NamedQuery(name = "ProveedorAlt.findAll", query = "SELECT p FROM ProveedorAlt p")})
public class ProveedorAlt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpersonal")
    private Integer idpersonal;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apepat")
    private String apepat;
    @Column(name = "apemat")
    private String apemat;
    @Column(name = "fecnacimiento")
    @Temporal(TemporalType.DATE)
    private Date fecnacimiento;
    @Column(name = "tipodocumento")
    private Integer tipodocumento;
    @Column(name = "nrodocumento")
    private String nrodocumento;
    @Column(name = "nrodocumento_alt")
    private String nrodocumentoAlt;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "fono1")
    private String fono1;
    @Column(name = "fono2")
    private String fono2;
    @Column(name = "idprofesion")
    private Integer idprofesion;
    @Column(name = "recomendacion")
    private String recomendacion;
    @Column(name = "comentarios")
    private String comentarios;
    @Lob
    @Column(name = "imagen")
    private byte[] imagen;
    @Lob
    @Column(name = "docadjunto")
    private byte[] docadjunto;
    @Column(name = "fecregistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecregistro;
    @Column(name = "usureg")
    private Integer usureg;
    @Column(name = "fecmodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecmodificacion;
    @Column(name = "usumod")
    private Integer usumod;
    @Column(name = "estado")
    private Integer estado;

    public ProveedorAlt() {
    }

    public ProveedorAlt(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    public Integer getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApepat() {
        return apepat;
    }

    public void setApepat(String apepat) {
        this.apepat = apepat;
    }

    public String getApemat() {
        return apemat;
    }

    public void setApemat(String apemat) {
        this.apemat = apemat;
    }

    public Date getFecnacimiento() {
        return fecnacimiento;
    }

    public void setFecnacimiento(Date fecnacimiento) {
        this.fecnacimiento = fecnacimiento;
    }

    public Integer getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(Integer tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getNrodocumento() {
        return nrodocumento;
    }

    public void setNrodocumento(String nrodocumento) {
        this.nrodocumento = nrodocumento;
    }

    public String getNrodocumentoAlt() {
        return nrodocumentoAlt;
    }

    public void setNrodocumentoAlt(String nrodocumentoAlt) {
        this.nrodocumentoAlt = nrodocumentoAlt;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFono1() {
        return fono1;
    }

    public void setFono1(String fono1) {
        this.fono1 = fono1;
    }

    public String getFono2() {
        return fono2;
    }

    public void setFono2(String fono2) {
        this.fono2 = fono2;
    }

    public Integer getIdprofesion() {
        return idprofesion;
    }

    public void setIdprofesion(Integer idprofesion) {
        this.idprofesion = idprofesion;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public byte[] getDocadjunto() {
        return docadjunto;
    }

    public void setDocadjunto(byte[] docadjunto) {
        this.docadjunto = docadjunto;
    }

    public Date getFecregistro() {
        return fecregistro;
    }

    public void setFecregistro(Date fecregistro) {
        this.fecregistro = fecregistro;
    }

    public Integer getUsureg() {
        return usureg;
    }

    public void setUsureg(Integer usureg) {
        this.usureg = usureg;
    }

    public Date getFecmodificacion() {
        return fecmodificacion;
    }

    public void setFecmodificacion(Date fecmodificacion) {
        this.fecmodificacion = fecmodificacion;
    }

    public Integer getUsumod() {
        return usumod;
    }

    public void setUsumod(Integer usumod) {
        this.usumod = usumod;
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
        hash += (idpersonal != null ? idpersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProveedorAlt)) {
            return false;
        }
        ProveedorAlt other = (ProveedorAlt) object;
        if ((this.idpersonal == null && other.idpersonal != null) || (this.idpersonal != null && !this.idpersonal.equals(other.idpersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.adox.app.entities.ProveedorAlt[ idpersonal=" + idpersonal + " ]";
    }
    
}
