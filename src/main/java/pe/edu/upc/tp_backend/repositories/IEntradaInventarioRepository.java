package pe.edu.upc.tp_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.tp_backend.entities.EntradaInventario;
import java.util.List;

public interface IEntradaInventarioRepository extends JpaRepository<EntradaInventario, Integer> {

    @Query("SELECT e FROM EntradaInventario e WHERE e.idInventario.id_inventario = :idInv ORDER BY e.fecha DESC")
    List<EntradaInventario> listarPorInventario(@Param("idInv") int idInv);

    @Query("SELECT e FROM EntradaInventario e WHERE e.idInventario.idEmpresa.idEmpresa = :idEmp ORDER BY e.fecha DESC")
    List<EntradaInventario> listarPorEmpresa(@Param("idEmp") int idEmp);

    @Query("SELECT COUNT(e) > 0 FROM EntradaInventario e WHERE e.idInventario.id_inventario = :id")
    boolean existeEntradaPorInventario(@Param("id") int id);


}