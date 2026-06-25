package pe.edu.upc.tp_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.tp_backend.entities.Archivos_Excel;

@Repository
public interface IArchivos_ExcelRepository extends JpaRepository<Archivos_Excel, Integer> {

    @Query("SELECT a FROM Archivos_Excel a " +
            "WHERE a.idEmpresa.idEmpresa = :idEmpresa " +
            "AND a.es_activo_predic_archivo = true")
    Archivos_Excel findByEmpresaActivo(
            @Param("idEmpresa") int idEmpresa);

}
