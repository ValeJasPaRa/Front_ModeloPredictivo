package pe.edu.upc.tp_backend.dtos;

public class EmpresaDTO {

    private Integer idEmpresa;
    private String name_empresa;
    private String ruc_empresa;
    private String sector_empresa;
    private Boolean estado_activo;

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getRuc_empresa() {
        return ruc_empresa;
    }

    public void setRuc_empresa(String ruc_empresa) {
        this.ruc_empresa = ruc_empresa;
    }

    public String getName_empresa() {
        return name_empresa;
    }

    public void setName_empresa(String name_empresa) {
        this.name_empresa = name_empresa;
    }

    public String getSector_empresa() {
        return sector_empresa;
    }

    public void setSector_empresa(String sector_empresa) {
        this.sector_empresa = sector_empresa;
    }

    public Boolean getEstado_activo() {
        return estado_activo;
    }

    public void setEstado_activo(Boolean estado_activo) {
        this.estado_activo = estado_activo;
    }
}