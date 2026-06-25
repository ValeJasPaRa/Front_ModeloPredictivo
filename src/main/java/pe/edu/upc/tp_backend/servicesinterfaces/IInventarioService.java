package pe.edu.upc.tp_backend.servicesinterfaces;

import pe.edu.upc.tp_backend.entities.Inventario;

import java.util.List;

public interface IInventarioService {
   /* List<Inventario> listarPorEmpresa(int idEmpresa);*/
    List<Inventario> listarPorEmpresa(int idEmpresa, boolean incluirInactivos);
    Inventario insertar(Inventario inv);
    Inventario actualizar(int id, Inventario inv);
    void eliminar(int id);
    Inventario descontarStock(int id, int cantidad);
    Inventario aumentarStock(int id, int cantidad);
    Inventario reactivar(int id);
}