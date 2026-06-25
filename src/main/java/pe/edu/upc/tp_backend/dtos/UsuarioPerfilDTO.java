package pe.edu.upc.tp_backend.dtos;

import java.time.LocalDateTime;

public class UsuarioPerfilDTO {

    private int       id_usuario;
    private String    nombre_usuario;
    private String    dni_usuario;
    private String    correo_usuario;
    private String    sexo_usuario;
    private String    telefono_usuario;
    private String    direccion_usuario;
    private LocalDateTime fechaRegistro_usuario;

    // Del Rol
    private int    id_rol;
    private String tipo_rol;
    private String descripcion_rol;

    // De la Empresa
    private int    id_empresa;
    private String nombre_empresa;
    private String ruc_empresa;
    private String sector_empresa;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getDni_usuario() {
        return dni_usuario;
    }

    public void setDni_usuario(String dni_usuario) {
        this.dni_usuario = dni_usuario;
    }

    public String getCorreo_usuario() {
        return correo_usuario;
    }

    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }

    public String getSexo_usuario() {
        return sexo_usuario;
    }

    public void setSexo_usuario(String sexo_usuario) {
        this.sexo_usuario = sexo_usuario;
    }

    public String getTelefono_usuario() {
        return telefono_usuario;
    }

    public void setTelefono_usuario(String telefono_usuario) {
        this.telefono_usuario = telefono_usuario;
    }

    public String getDireccion_usuario() {
        return direccion_usuario;
    }

    public void setDireccion_usuario(String direccion_usuario) {
        this.direccion_usuario = direccion_usuario;
    }

    public LocalDateTime getFechaRegistro_usuario() {
        return fechaRegistro_usuario;
    }

    public void setFechaRegistro_usuario(LocalDateTime fechaRegistro_usuario) {
        this.fechaRegistro_usuario = fechaRegistro_usuario;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getTipo_rol() {
        return tipo_rol;
    }

    public void setTipo_rol(String tipo_rol) {
        this.tipo_rol = tipo_rol;
    }

    public String getDescripcion_rol() {
        return descripcion_rol;
    }

    public void setDescripcion_rol(String descripcion_rol) {
        this.descripcion_rol = descripcion_rol;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getRuc_empresa() {
        return ruc_empresa;
    }

    public void setRuc_empresa(String ruc_empresa) {
        this.ruc_empresa = ruc_empresa;
    }

    public String getSector_empresa() {
        return sector_empresa;
    }

    public void setSector_empresa(String sector_empresa) {
        this.sector_empresa = sector_empresa;
    }
}
