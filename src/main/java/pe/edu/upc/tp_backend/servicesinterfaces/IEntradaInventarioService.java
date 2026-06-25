package pe.edu.upc.tp_backend.servicesinterfaces;

import pe.edu.upc.tp_backend.entities.EntradaInventario;
import java.util.List;

public interface IEntradaInventarioService {
    EntradaInventario insertar(EntradaInventario entrada);
    List<EntradaInventario> listarPorInventario(int idInventario);
    List<EntradaInventario> listarPorEmpresa(int idEmpresa);
}