package pe.edu.upc.tp_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.tp_backend.entities.Inventario;

import java.util.List;
import java.util.Optional;

@Repository
public interface IInventarioRepository
        extends JpaRepository<Inventario, Integer> {

    @Query("SELECT i FROM Inventario i " +
            "WHERE i.idEmpresa.idEmpresa = :idEmpresa")
    List<Inventario> findByEmpresa(
            @Param("idEmpresa") int idEmpresa);

    @Query("SELECT i FROM Inventario i " +
            "WHERE i.idEmpresa.idEmpresa = :idEmpresa " +
            "AND i.producto = :producto")

    Optional<Inventario> findByEmpresaAndProducto(
            @Param("idEmpresa") int idEmpresa,
            @Param("producto") String producto);

    @Query("SELECT i FROM Inventario i WHERE i.idEmpresa.idEmpresa = :idEmpresa AND i.activo = true ORDER BY i.producto ASC")
    List<Inventario> listarActivosPorEmpresa(@Param("idEmpresa") int idEmpresa);
}