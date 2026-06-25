package pe.edu.upc.tp_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.tp_backend.entities.Predicciones;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Repository
public interface IPrediccionesRepository extends JpaRepository<Predicciones, Integer> {

    @Query("SELECT p FROM Predicciones p " +
            "WHERE p.idEmpresa.idEmpresa = :idEmpresa " +
            "ORDER BY p.created_at_prediccion DESC")
    List<Predicciones> findByEmpresa(@Param("idEmpresa") int idEmpresa);

    @Query("SELECT p FROM Predicciones p " +
            "WHERE p.idEmpresa.idEmpresa = :idEmpresa " +
            "ORDER BY p.created_at_prediccion DESC")
    Page<Predicciones> findByEmpresaPaginado(
            @Param("idEmpresa") int idEmpresa,
            Pageable pageable);  // ← Pageable de Spring Data

    @Query("SELECT p FROM Predicciones p " +
            "WHERE p.idEmpresa.idEmpresa = :idEmpresa " +
            "ORDER BY p.created_at_prediccion DESC " +
            "LIMIT 5")
    List<Predicciones> findUltimas5(@Param("idEmpresa") int idEmpresa);
}