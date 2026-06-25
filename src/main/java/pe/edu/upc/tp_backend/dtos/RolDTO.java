package pe.edu.upc.tp_backend.dtos;

public class RolDTO {

    private int id_rol;
    private String Tipo_rol;
    private String Descripcion_rol;

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getTipo_rol() {
        return Tipo_rol;
    }

    public void setTipo_rol(String tipo_rol) {
        Tipo_rol = tipo_rol;
    }

    public String getDescripcion_rol() {
        return Descripcion_rol;
    }

    public void setDescripcion_rol(String descripcion_rol) {
        Descripcion_rol = descripcion_rol;
    }
}


