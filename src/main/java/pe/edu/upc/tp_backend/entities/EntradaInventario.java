package pe.edu.upc.tp_backend.entities;

import jakarta.persistence.*;
        import java.time.LocalDateTime;

@Entity
@Table(name = "entrada_inventario")
public class EntradaInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_entrada;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "motivo", length = 200)
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "INVENTARIO_id_inventario")
    private Inventario idInventario;

    @ManyToOne
    @JoinColumn(name = "USUARIOS_id_usuario")
    private Usuario idUsuario;

    @PrePersist
    public void setFecha() {
        this.fecha = LocalDateTime.now();
    }

    // Getters y setters
    public int getId_entrada() { return id_entrada; }
    public void setId_entrada(int id_entrada) { this.id_entrada = id_entrada; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public Inventario getIdInventario() { return idInventario; }
    public void setIdInventario(Inventario idInventario) { this.idInventario = idInventario; }

    public Usuario getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Usuario idUsuario) { this.idUsuario = idUsuario; }
}