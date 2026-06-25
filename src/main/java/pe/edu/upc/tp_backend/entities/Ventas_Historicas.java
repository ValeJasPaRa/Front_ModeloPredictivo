package pe.edu.upc.tp_backend.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Ventas_Historicas")
public class Ventas_Historicas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ventas_historicas;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "producto", length = 50, nullable = false)
    private String producto;

    @Column(name = "categoria", length = 50, nullable = false)
    private String categoria;

    @Column(name = "cantidad_vendida", nullable = false)
    private int cantidad_vendida;

    @Column(name = "precio_unitario", nullable = false)
    private float precio_unitario;

    @Column(name = "costo_unitario", nullable = false)
    private float costo_unitario;

    @Column(name = "canal_venta", length = 50, nullable = false)
    private String canal_venta;

    @Column(name = "tipo_cliente", length = 50, nullable = false)
    private String tipo_cliente;

    @Column(name = "region_venta", length = 50, nullable = false)
    private String region_venta;

    @Column(name = "modalidad_pago", length = 50, nullable = false)
    private String modalidad_pago;

    @Column(name = "tiene_dscto", nullable = false)
    private Boolean tiene_dscto;

    @Column(name = "porcentaje_dscto", nullable = false)
    private float porcentaje_dscto;

    @Column(name = "es_campain", nullable = false)
    private Boolean es_campain;

    @Column(name = "tipo_campain", length = 50, nullable = false)
    private String tipo_campain;

    @Column(name = "stock_inicial_periodo", nullable = false)
    private int stock_inicial_periodo;

    @Column(name = "stock_final_periodo", nullable = false)
    private int stock_final_periodo;

    @Column(name = "fuente", length = 20, nullable = false)
    private String fuente;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name = "idEmpresa",nullable = false)  /*agregado*/
    private Empresas idEmpresa;

    @ManyToOne
    @JoinColumn(name = "id_archivoxls",nullable = true)  /*agregado*/
    private Archivos_Excel id_archivoxls;

    @ManyToOne
    @JoinColumn(name = "id_usuario",nullable = false)  /*agregado*/
    private Usuario id_usuario;



    @PrePersist
    public void prePersist() {
        this.created_at = LocalDateTime.now();
    }

    public Ventas_Historicas() {
    }

    public Ventas_Historicas(int id_ventas_historicas, LocalDate fecha, String producto, String categoria, int cantidad_vendida, float precio_unitario, float costo_unitario, String canal_venta, String tipo_cliente, String region_venta, String modalidad_pago, Boolean tiene_dscto, float porcentaje_dscto, Boolean es_campain, String tipo_campain, int stock_final_periodo, int stock_inicial_periodo, Empresas idEmpresa, Archivos_Excel id_archivoxls, Usuario id_usuario) {
        this.id_ventas_historicas = id_ventas_historicas;
        this.fecha = fecha;
        this.producto = producto;
        this.categoria = categoria;
        this.cantidad_vendida = cantidad_vendida;
        this.precio_unitario = precio_unitario;
        this.costo_unitario = costo_unitario;
        this.canal_venta = canal_venta;
        this.tipo_cliente = tipo_cliente;
        this.region_venta = region_venta;
        this.modalidad_pago = modalidad_pago;
        this.tiene_dscto = tiene_dscto;
        this.porcentaje_dscto = porcentaje_dscto;
        this.es_campain = es_campain;
        this.tipo_campain = tipo_campain;
        this.stock_final_periodo = stock_final_periodo;
        this.stock_inicial_periodo = stock_inicial_periodo;
        this.idEmpresa = idEmpresa;
        this.id_archivoxls = id_archivoxls;
        this.id_usuario = id_usuario;
    }

    public int getId_ventas_historicas() {
        return id_ventas_historicas;
    }

    public void setId_ventas_historicas(int id_ventas_historicas) {
        this.id_ventas_historicas = id_ventas_historicas;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
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

    public String getRegion_venta() {
        return region_venta;
    }

    public void setRegion_venta(String region_venta) {
        this.region_venta = region_venta;
    }

    public String getModalidad_pago() {
        return modalidad_pago;
    }

    public void setModalidad_pago(String modalidad_pago) {
        this.modalidad_pago = modalidad_pago;
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

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
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
