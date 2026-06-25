package pe.edu.upc.tp_backend.servicesinterfaces;

import org.springframework.data.domain.Page;


import pe.edu.upc.tp_backend.dtos.PrediccionInsertarDTO;
import pe.edu.upc.tp_backend.entities.Predicciones;

import java.util.List;


public interface IPrediccionesService {

    Predicciones insertar(PrediccionInsertarDTO dto);
    List<Predicciones> getByEmpresa(int idEmpresa);
    List<Predicciones> getUltimas5(int idEmpresa);
    Page<Predicciones> getByEmpresaPaginado(int idEmpresa, int page, int size);
    void eliminar(int id);
}
