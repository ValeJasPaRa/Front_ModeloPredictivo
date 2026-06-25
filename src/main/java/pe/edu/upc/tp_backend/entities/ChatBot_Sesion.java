package pe.edu.upc.tp_backend.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name="ChatBot_Sesion")
public class ChatBot_Sesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_chatbotsesion;

    @Column(name = "created_at_chatbotsesion", updatable = false)
    private LocalDateTime created_at_chatbotsesion;

    @ManyToOne
    @JoinColumn(name = "id_prediccion",nullable = false)  /*agregado*/
    private Predicciones id_prediccion;

    @ManyToOne
    @JoinColumn(name = "idEmpresa",nullable = false)  /*agregado*/
    private Empresas idEmpresa;

    @ManyToOne
    @JoinColumn(name = "id_usuario",nullable = false)  /*agregado*/
    private Usuario id_usuario;

    public ChatBot_Sesion() {
    }

    @PrePersist
    public void prePersist() {
        this.created_at_chatbotsesion = LocalDateTime.now();
    }

    public ChatBot_Sesion(int id_chatbotsesion, Predicciones id_prediccion, Empresas idEmpresa, Usuario id_usuario) {
        this.id_chatbotsesion = id_chatbotsesion;
        this.id_prediccion = id_prediccion;
        this.idEmpresa = idEmpresa;
        this.id_usuario = id_usuario;
    }

    public int getId_chatbotsesion() {
        return id_chatbotsesion;
    }

    public void setId_chatbotsesion(int id_chatbotsesion) {
        this.id_chatbotsesion = id_chatbotsesion;
    }

    public LocalDateTime getCreated_at_chatbotsesion() {
        return created_at_chatbotsesion;
    }

    public void setCreated_at_chatbotsesion(LocalDateTime created_at_chatbotsesion) {
        this.created_at_chatbotsesion = created_at_chatbotsesion;
    }

    public Predicciones getId_prediccion() {
        return id_prediccion;
    }

    public void setId_prediccion(Predicciones id_prediccion) {
        this.id_prediccion = id_prediccion;
    }

    public Empresas getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresas idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }
}
