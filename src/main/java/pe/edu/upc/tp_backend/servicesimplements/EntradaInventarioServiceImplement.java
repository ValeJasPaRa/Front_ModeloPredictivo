package pe.edu.upc.tp_backend.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tp_backend.entities.EntradaInventario;
import pe.edu.upc.tp_backend.repositories.IEntradaInventarioRepository;
import pe.edu.upc.tp_backend.servicesinterfaces.IEntradaInventarioService;
import pe.edu.upc.tp_backend.servicesinterfaces.IInventarioService;

import java.util.List;

@Service
public class EntradaInventarioServiceImplement implements IEntradaInventarioService {

    @Autowired
    private IEntradaInventarioRepository entradaRepository;

    @Autowired
    private IInventarioService inventarioService;

    @Override
    public EntradaInventario insertar(EntradaInventario entrada) {
        // Primero aumenta el stock en inventario
        int idInv = entrada.getIdInventario().getId_inventario();
        inventarioService.aumentarStock(idInv, entrada.getCantidad());

        // Luego registra la entrada en el log
        return entradaRepository.save(entrada);
    }

    @Override
    public List<EntradaInventario> listarPorInventario(int idInventario) {
        return entradaRepository.listarPorInventario(idInventario);
    }

    @Override
    public List<EntradaInventario> listarPorEmpresa(int idEmpresa) {
        return entradaRepository.listarPorEmpresa(idEmpresa);
    }
}