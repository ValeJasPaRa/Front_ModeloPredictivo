package pe.edu.upc.tp_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.tp_backend.entities.Empresas;

@Repository
public interface IEmpresaRepository extends JpaRepository<Empresas, Integer> {
}