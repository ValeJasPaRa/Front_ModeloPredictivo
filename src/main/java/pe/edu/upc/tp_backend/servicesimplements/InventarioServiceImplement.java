package pe.edu.upc.tp_backend.servicesimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tp_backend.entities.Inventario;
import pe.edu.upc.tp_backend.repositories.IEntradaInventarioRepository;
import pe.edu.upc.tp_backend.repositories.IInventarioRepository;
import pe.edu.upc.tp_backend.repositories.IVentas_HistoricasRepository;
import pe.edu.upc.tp_backend.servicesinterfaces.IInventarioService;

import java.util.List;

@Service
public class InventarioServiceImplement implements IInventarioService {

    @Autowired
    private IInventarioRepository inventarioRepo;

    @Autowired
    private IVentas_HistoricasRepository ventasRepository;

    @Autowired
    private IEntradaInventarioRepository entradaRepository;

   /* @Override
    public List<Inventario> listarPorEmpresa(int idEmpresa) {
        return inventarioRepo.findByEmpresa(idEmpresa);
    }*/

    @Override
    public List<Inventario> listarPorEmpresa(int idEmpresa, boolean incluirInactivos) {
        if (incluirInactivos) {
            return inventarioRepo.findByEmpresa(idEmpresa);
        }
        return inventarioRepo.listarActivosPorEmpresa(idEmpresa);
    }

    @Override
    public Inventario insertar(Inventario inv) {
        return inventarioRepo.save(inv);
    }

    @Override
    public Inventario actualizar(int id, Inventario inv) {
        Inventario existing = inventarioRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Inventario no encontrado"));
        existing.setStock_actual(inv.getStock_actual());
        existing.setStock_minimo(inv.getStock_minimo());
        existing.setPrecio_unitario(inv.getPrecio_unitario());
        existing.setUnidad_medida(inv.getUnidad_medida());
        return inventarioRepo.save(existing);
    }

    @Override
    public Inventario reactivar(int id) {
        Inventario inv = inventarioRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        inv.setActivo(true);
        return inventarioRepo.save(inv);
    }

   /* @Override
    public void eliminar(int id) {
        inventarioRepo.deleteById(id);
    }*/

    @Override
    public void eliminar(int id) {
        Inventario inv = inventarioRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado en inventario"));

        int idEmpresa = inv.getIdEmpresa().getIdEmpresa();

        // Verificar si tiene historial
        boolean tieneVentas = ventasRepository.existeVentaPorProducto(inv.getProducto(), idEmpresa);
        boolean tieneEntradas = entradaRepository.existeEntradaPorInventario(id);

        if (tieneVentas || tieneEntradas) {
            // SOFT DELETE: tiene historial, preservar trazabilidad
            inv.setActivo(false);
            inventarioRepo.save(inv);
        } else {
            // HARD DELETE: no tiene historial, eliminar limpio
            inventarioRepo.deleteById(id);
        }
    }

    @Override
    public Inventario descontarStock(int id, int cantidad) {
        Inventario inv = inventarioRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado en inventario"));

        if (cantidad <= 0) {
            throw new RuntimeException("La cantidad debe ser mayor a 0");
        }

        if (inv.getStock_actual() < cantidad) {
            throw new RuntimeException("Stock insuficiente. Disponible: " + inv.getStock_actual());
        }

        inv.setStock_actual(inv.getStock_actual() - cantidad);
        return inventarioRepo.save(inv);
    }

    @Override
    public Inventario aumentarStock(int id, int cantidad) {
        Inventario inv = inventarioRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado en inventario"));

        if (cantidad <= 0) {
            throw new RuntimeException("La cantidad debe ser mayor a 0");
        }

        inv.setStock_actual(inv.getStock_actual() + cantidad);
        return inventarioRepo.save(inv);
    }
}