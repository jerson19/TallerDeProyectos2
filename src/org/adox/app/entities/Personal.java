/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.adox.app.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ADOLFO
 */
@Entity
@Table(name = "personal")
public class Personal implements Serializable {
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
    @Column(name = "sexo")
    private Integer sexo;
    @Column(name = "fecnacimiento")
    @Temporal(TemporalType.DATE)
    private Date fecnacimiento;
    @Column(name = "tipodocumento")
    private Integer tipodocumento;
    @Column(name = "nrodocumento")
    private String nrodocumento;
    @Column(name = "nrodocumento_alt")
    private String nrodocumentoAlt;
    @Column(name = "direccion1")
    private String direccion1;
    @Column(name = "direccion2")
    private String direccion2;
    @Column(name = "fono1")
    private String fono1;
    @Column(name = "fono2")
    private String fono2;
    @Column(name = "correo")
    private String correo;
    @Column(name = "recomendacion")
    private String recomendacion;
    @Column(name = "codpersonal")
    private String codpersonal;
    @Column(name = "sueldobruto")
    private String sueldobruto;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "profesion")
    private String profesion;
    @Column(name = "colegiatura")
    private String colegiatura;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "horario")
    private String horario;
    @Column(name = "observaciones")
    private String observaciones;
    @Lob
    @Column(name = "huella")
    private byte[] huella;
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
    @Column(name = "comentarios")
    private String comentarios;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "descuento")
    private BigDecimal descuento;
    @Column(name = "responsable")
    private String responsable;

    public Personal() {
    }

    public Personal(Integer idpersonal) {
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

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
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

    public String getDireccion1() {
        return direccion1;
    }

    public void setDireccion1(String direccion1) {
        this.direccion1 = direccion1;
    }

    public String getDireccion2() {
        return direccion2;
    }

    public void setDireccion2(String direccion2) {
        this.direccion2 = direccion2;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public String getCodpersonal() {
        return codpersonal;
    }

    public void setCodpersonal(String codpersonal) {
        this.codpersonal = codpersonal;
    }

    public String getSueldobruto() {
        return sueldobruto;
    }

    public void setSueldobruto(String sueldobruto) {
        this.sueldobruto = sueldobruto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getColegiatura() {
        return colegiatura;
    }

    public void setColegiatura(String colegiatura) {
        this.colegiatura = colegiatura;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public byte[] getHuella() {
        return huella;
    }

    public void setHuella(byte[] huella) {
        this.huella = huella;
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

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
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
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.idpersonal == null && other.idpersonal != null) || (this.idpersonal != null && !this.idpersonal.equals(other.idpersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.adox.app.entities.Personal[ idpersonal=" + idpersonal + " ]";
    }
    
}
