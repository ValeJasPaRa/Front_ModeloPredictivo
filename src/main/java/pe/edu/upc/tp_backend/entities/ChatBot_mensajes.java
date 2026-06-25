package pe.edu.upc.tp_backend.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ChatBot_mensajes")
public class ChatBot_mensajes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_chatbotmsj;

    @Column(name = "rol_chatbotmsj",length = 30, nullable = false)
    private String rol_chatbotmsj;

    @Column(name = "contenido",length = 200, nullable = false)
    private String contenido;

    @Column(name = "created_at_chatbotmsj", updatable = false)
    private LocalDateTime created_at_chatbotmsj;

    @ManyToOne
    @JoinColumn(name = "id_chatbotsesion",nullable = false)  /*agregado*/
    private ChatBot_Sesion id_chatbotsesion;

    public ChatBot_mensajes() {
    }


    @PrePersist
    public void prePersist() {
        this.created_at_chatbotmsj = LocalDateTime.now();
    }

    public ChatBot_mensajes(int id_chatbotmsj, String rol_chatbotmsj, String contenido, ChatBot_Sesion id_chatbotsesion) {
        this.id_chatbotmsj = id_chatbotmsj;
        this.rol_chatbotmsj = rol_chatbotmsj;
        this.contenido = contenido;
        this.id_chatbotsesion = id_chatbotsesion;
    }

    public int getId_chatbotmsj() {
        return id_chatbotmsj;
    }

    public void setId_chatbotmsj(int id_chatbotmsj) {
        this.id_chatbotmsj = id_chatbotmsj;
    }

    public String getRol_chatbotmsj() {
        return rol_chatbotmsj;
    }

    public void setRol_chatbotmsj(String rol_chatbotmsj) {
        this.rol_chatbotmsj = rol_chatbotmsj;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getCreated_at_chatbotmsj() {
        return created_at_chatbotmsj;
    }

    public void setCreated_at_chatbotmsj(LocalDateTime created_at_chatbotmsj) {
        this.created_at_chatbotmsj = created_at_chatbotmsj;
    }

    public ChatBot_Sesion getId_chatbotsesion() {
        return id_chatbotsesion;
    }

    public void setId_chatbotsesion(ChatBot_Sesion id_chatbotsesion) {
        this.id_chatbotsesion = id_chatbotsesion;
    }
}
