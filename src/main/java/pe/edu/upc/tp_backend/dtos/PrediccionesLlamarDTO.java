package pe.edu.upc.tp_backend.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.tp_backend.entities.Archivos_Excel;
import pe.edu.upc.tp_backend.entities.Empresas;
import pe.edu.upc.tp_backend.entities.Usuario;

import java.time.LocalDateTime;

public class PrediccionesLlamarDTO {

    private int id_prediccion;

    private int meses_horizonte;

    private String modelo_version;

    private String estado_predic;

    private LocalDateTime created_at_prediccion;

    private Empresas idEmpresa;

    private Archivos_Excel id_archivoxls;

    private Usuario id_usuario;

    public int getId_prediccion() {
        return id_prediccion;
    }

    public void setId_prediccion(int id_prediccion) {
        this.id_prediccion = id_prediccion;
    }

    public int getMeses_horizonte() {
        return meses_horizonte;
    }

    public void setMeses_horizonte(int meses_horizonte) {
        this.meses_horizonte = meses_horizonte;
    }

    public String getModelo_version() {
        return modelo_version;
    }

    public void setModelo_version(String modelo_version) {
        this.modelo_version = modelo_version;
    }

    public String getEstado_predic() {
        return estado_predic;
    }

    public void setEstado_predic(String estado_predic) {
        this.estado_predic = estado_predic;
    }

    public LocalDateTime getCreated_at_prediccion() {
        return created_at_prediccion;
    }

    public void setCreated_at_prediccion(LocalDateTime created_at_prediccion) {
        this.created_at_prediccion = created_at_prediccion;
    }

    public Empresas getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresas idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Archivos_Excel getId_archivoxls() {
        return id_archivoxls;
    }

    public void setId_archivoxls(Archivos_Excel id_archivoxls) {
        this.id_archivoxls = id_archivoxls;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }
}
