package pe.edu.upc.tp_backend.dtos;

public class Ventas_HistoricasDTO {

    private int    id_ventas_historicas;
    private String fecha;     // "YYYY-MM-DD"
    private String producto;
    private String categoria;
    private int    cantidad_vendida;
    private float  precio_unitario;
    private float  costo_unitario;
    private String canal_venta;
    private String tipo_cliente;
    private String region_venta;
    private String modalidad_pago;
    private Boolean tiene_dscto;
    private float  porcentaje_dscto;
    private Boolean es_campain;
    private String tipo_campain;
    private int    stock_inicial_periodo;
    private int    stock_final_periodo;  // calculado por Streamlit
    private String fuente;               // "CSV" o "MANUAL"
    private int    idEmpresa;      // solo el id
    private int    id_usuario;     // solo el id
    // id_archivoxls va null en manual, se asigna en upload


    public int getId_ventas_historicas() {
        return id_ventas_historicas;
    }

    public void setId_ventas_historicas(int id_ventas_historicas) {
        this.id_ventas_historicas = id_ventas_historicas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidad_vendida() {
        return cantidad_vendida;
    }

    public void setCantidad_vendida(int cantidad_vendida) {
        this.cantidad_vendida = cantidad_vendida;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public float getCosto_unitario() {
        return costo_unitario;
    }

    public void setCosto_unitario(float costo_unitario) {
        this.costo_unitario = costo_unitario;
    }

    public String getCanal_venta() {
        return canal_venta;
    }

    public void setCanal_venta(String canal_venta) {
        this.canal_venta = canal_venta;
    }

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public String getModalidad_pago() {
        return modalidad_pago;
    }

    public void setModalidad_pago(String modalidad_pago) {
        this.modalidad_pago = modalidad_pago;
    }

    public String getRegion_venta() {
        return region_venta;
    }

    public void setRegion_venta(String region_venta) {
        this.region_venta = region_venta;
    }

    public Boolean getTiene_dscto() {
        return tiene_dscto;
    }

    public void setTiene_dscto(Boolean tiene_dscto) {
        this.tiene_dscto = tiene_dscto;
    }

    public float getPorcentaje_dscto() {
        return porcentaje_dscto;
    }

    public void setPorcentaje_dscto(float porcentaje_dscto) {
        this.porcentaje_dscto = porcentaje_dscto;
    }

    public Boolean getEs_campain() {
        return es_campain;
    }

    public void setEs_campain(Boolean es_campain) {
        this.es_campain = es_campain;
    }

    public String getTipo_campain() {
        return tipo_campain;
    }

    public void setTipo_campain(String tipo_campain) {
        this.tipo_campain = tipo_campain;
    }

    public int getStock_inicial_periodo() {
        return stock_inicial_periodo;
    }

    public void setStock_inicial_periodo(int stock_inicial_periodo) {
        this.stock_inicial_periodo = stock_inicial_periodo;
    }

    public int getStock_final_periodo() {
        return stock_final_periodo;
    }

    public void setStock_final_periodo(int stock_final_periodo) {
        this.stock_final_periodo = stock_final_periodo;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}

