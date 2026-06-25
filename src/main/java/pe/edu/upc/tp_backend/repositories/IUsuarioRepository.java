package pe.edu.upc.tp_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.tp_backend.entities.Usuario;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.correo_usuario = :correo")
    Optional<Usuario> findByCorreo_usuario(@Param("correo") String correo);

    @Query("SELECT u FROM Usuario u WHERE u.nombre_usuario = :username")
    public Usuario findByUsername(@Param("username") String username); //requerido para UserDetails

    @Query("Select u from Usuario u where upper(u.nombre_usuario) like upper(concat('%', :n, '%'))") //lenguaje JPA
    List<Usuario> Buscaruserxname(@Param("n") String n); //soporta mayusculas y busca parcialmente

    @Query("SELECT u FROM Usuario u " +
            "LEFT JOIN FETCH u.id_rol r " +
            "LEFT JOIN FETCH u.idEmpresa e " +
            "WHERE u.nombre_usuario = :username")
    public Usuario findByUsernameConDetalle(@Param("username") String username);

    //listar usuarios x empresa a buscar
    @Query("SELECT u FROM Usuario u " +
            "LEFT JOIN FETCH u.id_rol r " +
            "LEFT JOIN FETCH u.idEmpresa e " +
            "WHERE u.idEmpresa.idEmpresa = :idEmpresa")
    List<Usuario> findByEmpresa(@Param("idEmpresa") int idEmpresa);
}
