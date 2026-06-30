package pe.edu.upc.tp_backend.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tp_backend.dtos.Ventas_HistoricasDTO;
import pe.edu.upc.tp_backend.entities.Ventas_Historicas;
import pe.edu.upc.tp_backend.repositories.IArchivos_ExcelRepository;
import pe.edu.upc.tp_backend.repositories.IEmpresaRepository;
import pe.edu.upc.tp_backend.repositories.IUsuarioRepository;
import pe.edu.upc.tp_backend.repositories.IVentas_HistoricasRepository;
import pe.edu.upc.tp_backend.servicesinterfaces.IIVentas_HistoricasService;

import java.time.LocalDate;
import java.util.List;

@Service
public class Ventas_HistoricasServiceImplement  implements IIVentas_HistoricasService {

    @Autowired
    private IVentas_HistoricasRepository repo;

    @Autowired
    private IEmpresaRepository empresaRepo;

    @Autowired
    private IUsuarioRepository usuarioRepo;

    @Autowired
    private IArchivos_ExcelRepository archivoRepo;

    // ── Insertar venta manual ─────────────────────────────────────
    @Override
    public Ventas_Historicas insertar(Ventas_HistoricasDTO dto) {
        Ventas_Historicas v = new Ventas_Historicas();

        v.setFecha(LocalDate.parse(dto.getFecha()));
        v.setProducto(dto.getProducto());
        v.setCategoria(dto.getCategoria());
        v.setCantidad_vendida(dto.getCantidad_vendida());
        v.setPrecio_unitario(dto.getPrecio_unitario());
        v.setPrecio_final_venta(dto.getPrecio_final_venta());
        v.setCosto_unitario(dto.getCosto_unitario());
        v.setCanal_venta(dto.getCanal_venta());
        v.setTipo_cliente(dto.getTipo_cliente());
        v.setRegion_venta(dto.getRegion_venta());
        v.setModalidad_pago(dto.getModalidad_pago() != null
                ? dto.getModalidad_pago() : "Efectivo");
        v.setTiene_dscto(dto.getTiene_dscto());
        v.setPorcentaje_dscto(dto.getPorcentaje_dscto());
        v.setEs_campain(dto.getEs_campain());
        v.setTipo_campain(dto.getTipo_campain());
        v.setStock_inicial_periodo(dto.getStock_inicial_periodo());
        v.setStock_final_periodo(dto.getStock_final_periodo());
        v.setFuente("MANUAL");  // siempre MANUAL aquí

        // Empresa
        v.setIdEmpresa(empresaRepo.findById(dto.getIdEmpresa())
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada")));

        // Usuario
        v.setId_usuario(usuarioRepo.findById(dto.getId_usuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));

        // Sin archivo Excel (es manual)
        v.setId_archivoxls(null);

        return repo.save(v);
    }

    // ── Listar ventas activas de la empresa ───────────────────────
    @Override
    public List<Ventas_Historicas> listarPorEmpresa(int idEmpresa) {
        return repo.findByEmpresaActivo(idEmpresa);
    }

    // ── Listar todas (para reportes) ──────────────────────────────
    @Override
    public List<Ventas_Historicas> listarTodas(int idEmpresa) {
        return repo.findByEmpresa(idEmpresa);
    }

    @Override
    public void eliminar(int id) {
        repo.deleteById(id);
    }

}