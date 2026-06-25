package pe.edu.upc.tp_backend.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Archivos_Excel")
public class Archivos_Excel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_archivoxls;

    @Column(name = "storage_url_archivoxls",length = 200, nullable = false)
    private String storage_url_archivoxls;

    @Column(name = "version_archivoxls",nullable = false)
    private int version_archivoxls;

    @Column(name = "es_activo_predic_archivo",nullable = false)
    private boolean es_activo_predic_archivo;

    @Column(name = "estado_archivoxls",length = 50, nullable = false)
    private String estado_archivoxls;

    @Column(name = "created_at_archivoxls",updatable = false)
    private LocalDateTime created_at_archivoxls;

    @ManyToOne
    @JoinColumn(name = "idEmpresa",nullable = false)  /*agregado*/
    private Empresas idEmpresa;

    @ManyToOne
    @JoinColumn(name = "id_usuario",nullable = false)
    private Usuario id_usuario;
    //nullable = true porque una empresa puede no tener archivo aún
    // /*agregado*/

    // PREPERSIST
    // =============================================
    @PrePersist
    public void prePersist() {
        this.created_at_archivoxls = LocalDateTime.now();
        // versionArchivoxls viene seteada desde el service
    }


    // =============================================
    // CONSTRUCTOR CON PARÁMETROS
    // Sin createdAt, estadoArchivoxls, esActivoPredArchivo
    // porque los maneja @PrePersist
    // Sin versionArchivoxls porque lo maneja el service
    // =============================================

    public Archivos_Excel(int id_archivoxls, String storage_url_archivoxls, Empresas idEmpresa, Usuario id_usuario) {
        this.id_archivoxls = id_archivoxls;
        this.storage_url_archivoxls = storage_url_archivoxls;
        this.idEmpresa = idEmpresa;
        this.id_usuario = id_usuario;
    }

    public Archivos_Excel() {
    }


    public int getId_archivoxls() {
        return id_archivoxls;
    }

    public void setId_archivoxls(int id_archivoxls) {
        this.id_archivoxls = id_archivoxls;
    }

    public String getStorage_url_archivoxls() {
        return storage_url_archivoxls;
    }

    public void setStorage_url_archivoxls(String storage_url_archivoxls) {
        this.storage_url_archivoxls = storage_url_archivoxls;
    }

    public int getVersion_archivoxls() {
        return version_archivoxls;
    }

    public void setVersion_archivoxls(int version_archivoxls) {
        this.version_archivoxls = version_archivoxls;
    }

    public boolean isEs_activo_predic_archivo() {
        return es_activo_predic_archivo;
    }

    public void setEs_activo_predic_archivo(boolean es_activo_predic_archivo) {
        this.es_activo_predic_archivo = es_activo_predic_archivo;
    }

    public String getEstado_archivoxls() {
        return estado_archivoxls;
    }

    public void setEstado_archivoxls(String estado_archivoxls) {
        this.estado_archivoxls = estado_archivoxls;
    }

    public LocalDateTime getCreated_at_archivoxls() {
        return created_at_archivoxls;
    }

    public void setCreated_at_archivoxls(LocalDateTime created_at_archivoxls) {
        this.created_at_archivoxls = created_at_archivoxls;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Empresas getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresas idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
