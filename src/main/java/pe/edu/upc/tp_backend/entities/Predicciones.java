package pe.edu.upc.tp_backend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="Predicciones")
public class Predicciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prediccion;

    @Column(name = "modelo_version", length = 50, nullable = false)
    private String modelo_version;

    @Column(name = "estado_predic", length = 50, nullable = false)
    private String estado_predic;

    @Column(name = "created_at_prediccion", updatable = false)
    private LocalDateTime created_at_prediccion;

    // ── FK ────────────────────────────────────────────────────────────
    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresas idEmpresa;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario id_usuario;

    // ── Input del formulario ──────────────────────────────────────────
    @Column(name = "fecha_proyectada", nullable = false)
    private LocalDate fecha_proyectada;

    @Column(name = "producto", length = 50, nullable = false)
    private String producto;

    @Column(name = "categoria", length = 50, nullable = false)
    private String categoria;

    @Column(name = "precio_unitario", nullable = false)
    private float precio_unitario;

    @Column(name = "canal_venta", length = 50, nullable = false)
    private String canal_venta;

    @Column(name = "tipo_cliente", length = 50, nullable = false)
    private String tipo_cliente;

    @Column(name = "region_venta", length = 50, nullable = false)
    private String region_venta;

    @Column(name = "tiene_dscto", nullable = false)
    private boolean tiene_dscto;

    @Column(name = "porcentaje_dscto", nullable = false)
    private float porcentaje_dscto;

    @Column(name = "es_campain", nullable = false)
    private boolean es_campain;

    @Column(name = "tipo_campain", length = 50, nullable = false)
    private String tipo_campain;

    @Column(name = "stock_inicial", nullable = false)
    private int stock_inicial;

    // ── Output del modelo ─────────────────────────────────────────────
    @Column(name = "cantidad_predicha", nullable = false)
    private float cantidad_predicha;

    @Column(name = "stock_recomendado", nullable = false)
    private float stock_recomendado;

    @Column(name = "confianza", nullable = false)
    private float confianza;

    @PrePersist
    public void prePersist() {
        this.created_at_prediccion = LocalDateTime.now();
        this.estado_predic = "generado";
    }

    // Getters y Setters
    public int getId_prediccion() { return id_prediccion; }
    public String getModelo_version() { return modelo_version; }
    public void setModelo_version(String modelo_version) { this.modelo_version = modelo_version; }
    public String getEstado_predic() { return estado_predic; }
    public void setEstado_predic(String estado_predic) { this.estado_predic = estado_predic; }
    public LocalDateTime getCreated_at_prediccion() { return created_at_prediccion; }
    public Empresas getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(Empresas idEmpresa) { this.idEmpresa = idEmpresa; }
    public Usuario getId_usuario() { return id_usuario; }
    public void setId_usuario(Usuario id_usuario) { this.id_usuario = id_usuario; }
    public LocalDate getFecha_proyectada() { return fecha_proyectada; }
    public void setFecha_proyectada(LocalDate fecha_proyectada) { this.fecha_proyectada = fecha_proyectada; }
    public String getProducto() { return producto; }
    public void setProducto(String producto) { this.producto = producto; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public float getPrecio_unitario() { return precio_unitario; }
    public void setPrecio_unitario(float precio_unitario) { this.precio_unitario = precio_unitario; }
    public String getCanal_venta() { return canal_venta; }
    public void setCanal_venta(String canal_venta) { this.canal_venta = canal_venta; }
    public String getTipo_cliente() { return tipo_cliente; }
    public void setTipo_cliente(String tipo_cliente) { this.tipo_cliente = tipo_cliente; }
    public String getRegion_venta() { return region_venta; }
    public void setRegion_venta(String region_venta) { this.region_venta = region_venta; }
    public boolean isTiene_dscto() { return tiene_dscto; }
    public void setTiene_dscto(boolean tiene_dscto) { this.tiene_dscto = tiene_dscto; }
    public float getPorcentaje_dscto() { return porcentaje_dscto; }
    public void setPorcentaje_dscto(float porcentaje_dscto) { this.porcentaje_dscto = porcentaje_dscto; }
    public boolean isEs_campain() { return es_campain; }
    public void setEs_campain(boolean es_campain) { this.es_campain = es_campain; }
    public String getTipo_campain() { return tipo_campain; }
    public void setTipo_campain(String tipo_campain) { this.tipo_campain = tipo_campain; }
    public int getStock_inicial() { return stock_inicial; }
    public void setStock_inicial(int stock_inicial) { this.stock_inicial = stock_inicial; }
    public float getCantidad_predicha() { return cantidad_predicha; }
    public void setCantidad_predicha(float cantidad_predicha) { this.cantidad_predicha = cantidad_predicha; }
    public float getStock_recomendado() { return stock_recomendado; }
    public void setStock_recomendado(float stock_recomendado) { this.stock_recomendado = stock_recomendado; }
    public float getConfianza() { return confianza; }
    public void setConfianza(float confianza) { this.confianza = confianza; }


}
