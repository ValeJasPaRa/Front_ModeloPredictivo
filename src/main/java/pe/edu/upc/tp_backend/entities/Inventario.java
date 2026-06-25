package pe.edu.upc.tp_backend.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_inventario;

    @Column(name = "producto", length = 50)
    private String producto;

    @Column(name = "categoria", length = 50)
    private String categoria;

    @Column(name = "stock_actual")
    private int stock_actual;

    @Column(name = "stock_minimo")
    private int stock_minimo;

    @Column(name = "precio_unitario")
    private float precio_unitario;

    @Column(name = "unidad_medida", length = 20)
    private String unidad_medida;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Column(name = "costo_unitario")
    private float costo_unitario;

    @Column(name = "stock_inicial")
    private int stock_inicial;

    @Column(name = "activo")
    private boolean activo = true;

    @ManyToOne
    @JoinColumn(name = "EMPRESAS_id_empresa")
    private Empresas idEmpresa;

    @PrePersist
    @PreUpdate
    public void setUpdatedAt() {
        this.updated_at = LocalDateTime.now();
    }

    ///getter y setters
    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
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

    public int getStock_actual() {
        return stock_actual;
    }

    public void setStock_actual(int stock_actual) {
        this.stock_actual = stock_actual;
    }

    public int getStock_minimo() {
        return stock_minimo;
    }

    public void setStock_minimo(int stock_minimo) {
        this.stock_minimo = stock_minimo;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public float getCosto_unitario() {
        return costo_unitario;
    }

    public void setCosto_unitario(float costo_unitario) {
        this.costo_unitario = costo_unitario;
    }

    public int getStock_inicial() {
        return stock_inicial;
    }

    public void setStock_inicial(int stock_inicial) {
        this.stock_inicial = stock_inicial;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Empresas getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresas idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}