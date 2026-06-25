package pe.edu.upc.tp_backend.servicesimplements;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tp_backend.dtos.PrediccionInsertarDTO;
import pe.edu.upc.tp_backend.entities.Predicciones;
import pe.edu.upc.tp_backend.repositories.IEmpresaRepository;
import pe.edu.upc.tp_backend.repositories.IPrediccionesRepository;
import pe.edu.upc.tp_backend.repositories.IUsuarioRepository;
import pe.edu.upc.tp_backend.servicesinterfaces.IPrediccionesService;

import java.time.LocalDate;
import java.util.List;
@Service
public class PrediccionesServiceImplement implements IPrediccionesService {

    @Autowired private IPrediccionesRepository prediccionRepo;
    @Autowired private IEmpresaRepository empresaRepo;
    @Autowired private IUsuarioRepository usuarioRepo;

    @Override
    public Predicciones insertar(PrediccionInsertarDTO dto) {
        Predicciones p = new Predicciones();

        // FK
        p.setIdEmpresa(empresaRepo.findById(dto.getIdEmpresa())
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada")));
        p.setId_usuario(usuarioRepo.findById(dto.getId_usuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));

        // Fijo
        p.setModelo_version("RF_v2");

        // Input
        p.setFecha_proyectada(LocalDate.parse(dto.getFecha_proyectada()));
        p.setProducto(dto.getProducto());
        p.setCategoria(dto.getCategoria());
        p.setPrecio_unitario(dto.getPrecio_unitario());
        p.setCanal_venta(dto.getCanal_venta());
        p.setTipo_cliente(dto.getTipo_cliente());
        p.setRegion_venta(dto.getRegion_venta());
        p.setTiene_dscto(dto.isTiene_dscto());
        p.setPorcentaje_dscto(dto.getPorcentaje_dscto());
        p.setEs_campain(dto.isEs_campain());
        p.setTipo_campain(dto.getTipo_campain());
        p.setStock_inicial(dto.getStock_inicial());

        // Output
        p.setCantidad_predicha(dto.getCantidad_predicha());
        p.setStock_recomendado(dto.getStock_recomendado());
        p.setConfianza(dto.getConfianza());

        // estado y fecha los pone @PrePersist
        return prediccionRepo.save(p);
    }

    @Override
    public List<Predicciones> getByEmpresa(int idEmpresa) {
        return prediccionRepo.findByEmpresa(idEmpresa);
    }

    @Override
    public List<Predicciones> getUltimas5(int idEmpresa) {
        return prediccionRepo.findUltimas5(idEmpresa);
    }

    @Override
    public Page<Predicciones> getByEmpresaPaginado(int idEmpresa, int page, int size) {
        return prediccionRepo.findByEmpresaPaginado(
                idEmpresa, PageRequest.of(page, size));
    }


    // En impl:
    @Override
    public void eliminar(int id) {
        prediccionRepo.deleteById(id);
    }
}
