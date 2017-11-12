package org.adox.app.facade.business.dto;

import java.io.Serializable;

/**
 * @version V1
 * @author Adolfo Villanueva
 */
public class UsuarioSesion implements Serializable {

    private String codigo;
    private String idUsuario;
    private String idPersonal;
    private String idVendedor;
    private String idTipoVendedor;
    private String nombre;
    private String apellidos;
    private String empresa;
    private String rol;
    private String nombreRol;
    private String fechaActual;
    private String idOficina;
    private String Oficina;
    private String idEmpresa;
    private String nomEmpresa;

    public UsuarioSesion() {
        setIdUsuario("0");
        setNombre("");
        setApellidos("");
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(String idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getIdTipoVendedor() {
        return idTipoVendedor;
    }

    public void setIdTipoVendedor(String idTipoVendedor) {
        this.idTipoVendedor = idTipoVendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(String fechaActual) {
        this.fechaActual = fechaActual;
    }

    public String getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(String idOficina) {
        this.idOficina = idOficina;
    }

    public String getOficina() {
        return Oficina;
    }

    public void setOficina(String Oficina) {
        this.Oficina = Oficina;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }


}
