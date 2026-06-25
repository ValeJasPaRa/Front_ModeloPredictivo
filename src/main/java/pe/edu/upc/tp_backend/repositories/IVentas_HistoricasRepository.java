package pe.edu.upc.tp_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.tp_backend.entities.Ventas_Historicas;

import java.util.List;

@Repository
public interface IVentas_HistoricasRepository extends JpaRepository<Ventas_Historicas, Integer> {

    // Todas las ventas de una empresa (CSV activo + MANUAL)
    @Query("SELECT v FROM Ventas_Historicas v " +
            "LEFT JOIN FETCH v.id_archivoxls a " +
            "WHERE v.idEmpresa.idEmpresa = :idEmpresa " +
            "AND (v.fuente = 'MANUAL' OR " +
            "     a.es_activo_predic_archivo = true) " +
            "ORDER BY v.fecha DESC")
    List<Ventas_Historicas> findByEmpresaActivo(
            @Param("idEmpresa") int idEmpresa);

    // Todas sin filtro (para reportes completos)
    @Query("SELECT v FROM Ventas_Historicas v " +
            "WHERE v.idEmpresa.idEmpresa = :idEmpresa " +
            "ORDER BY v.fecha DESC")
    List<Ventas_Historicas> findByEmpresa(
            @Param("idEmpresa") int idEmpresa);

    @Query("SELECT COUNT(v) > 0 FROM Ventas_Historicas v WHERE v.producto = :producto AND v.idEmpresa.idEmpresa = :idEmpresa")
    boolean existeVentaPorProducto(@Param("producto") String producto, @Param("idEmpresa") int idEmpresa);
}
