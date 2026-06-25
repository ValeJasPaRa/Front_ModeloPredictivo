package pe.edu.upc.tp_backend.servicesinterfaces;

import pe.edu.upc.tp_backend.dtos.Ventas_HistoricasDTO;
import pe.edu.upc.tp_backend.entities.Ventas_Historicas;

import java.util.List;

public interface IIVentas_HistoricasService {

    // Inserta una venta manual (fuente = "MANUAL")
    Ventas_Historicas insertar(Ventas_HistoricasDTO dto);

    // Lista ventas activas: CSV activo + MANUAL (para predicción)
    List<Ventas_Historicas> listarPorEmpresa(int idEmpresa);

    // Lista todas las ventas (para reportes)
    List<Ventas_Historicas> listarTodas(int idEmpresa);

    void eliminar(int id);
}
