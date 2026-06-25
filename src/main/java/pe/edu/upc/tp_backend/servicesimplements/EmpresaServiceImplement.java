package pe.edu.upc.tp_backend.servicesimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tp_backend.entities.Empresas;
import pe.edu.upc.tp_backend.repositories.IEmpresaRepository;
import pe.edu.upc.tp_backend.servicesinterfaces.IEmpresaService;

import java.util.List;

@Service
public class EmpresaServiceImplement implements IEmpresaService {

    @Autowired
    private IEmpresaRepository empresaR;

    @Override
    public List<Empresas> list() { return empresaR.findAll(); }

    @Override
    public void insert(Empresas empresa) { empresaR.save(empresa); }

    @Override
    public Empresas listId(int id) { return empresaR.findById(id).orElse(new Empresas()); }

    @Override
    public void update(Empresas empresa) { empresaR.save(empresa); }

    @Override
    public void delete(int id) { empresaR.deleteById(id); }

    @Override
    public Empresas insertar(Empresas empresa) {
        return empresaR.save(empresa);  // save() devuelve la entidad con id generado
    }
}