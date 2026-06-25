package pe.edu.upc.tp_backend.entities;


import jakarta.persistence.*;

@Entity
@Table(name="Empresas")
public class Empresas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpresa;  /*cambiar nombre en el diagram*/

    @Column(name = "name_empresa",length = 40, nullable = false)
    private String name_empresa;

    @Column(name = "ruc_empresa",length = 11, nullable = false)
    private String ruc_empresa;

    @Column(name = "sector_empresa",length = 50, nullable = false)
    private String  sector_empresa;

    @Column(name = "estado_activo", nullable = false)
    private boolean  estado_activo;

    public Empresas() {
    }

    public Empresas(int idEmpresa, String name_empresa, String ruc_empresa, String sector_empresa, boolean estado_activo) {
        this.idEmpresa = idEmpresa;
        this.name_empresa = name_empresa;
        this.ruc_empresa = ruc_empresa;
        this.sector_empresa = sector_empresa;
        this.estado_activo = estado_activo;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getName_empresa() {
        return name_empresa;
    }

    public void setName_empresa(String name_empresa) {
        this.name_empresa = name_empresa;
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

    public boolean isEstado_activo() {
        return estado_activo;
    }

    public void setEstado_activo(boolean estado_activo) {
        this.estado_activo = estado_activo;
    }
}
