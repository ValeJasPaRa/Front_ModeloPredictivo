package pe.edu.upc.tp_backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tp_backend.dtos.EmpresaDTO;
import pe.edu.upc.tp_backend.entities.Empresas;
import pe.edu.upc.tp_backend.servicesinterfaces.IEmpresaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empresas")

public class EmpresaController {

    @Autowired
    private IEmpresaService empresaS;

    @GetMapping("/listar")
    public List<EmpresaDTO> listar() {
        return empresaS.list().stream().map(e -> {
            ModelMapper m = new ModelMapper();
            return m.map(e, EmpresaDTO.class);
        }).collect(Collectors.toList());
    }

   /* @PostMapping("/insertar")
    public void insertar(@RequestBody EmpresaDTO dto) {
        ModelMapper m = new ModelMapper();
        empresaS.insert(m.map(dto, Empresas.class));
    } */

    @GetMapping("/{id}")
    public EmpresaDTO buscarId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        return m.map(empresaS.listId(id), EmpresaDTO.class);
    }

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody EmpresaDTO dto) {
        ModelMapper m = new ModelMapper();
        empresaS.update(m.map(dto, Empresas.class));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        empresaS.delete(id);
    }

    // devuelve la empresa con su id generado
    @PostMapping("/insertar")
    public ResponseEntity<Empresas> insertar(@RequestBody Empresas empresa) {
        Empresas nueva = empresaS.insertar(empresa);
        return ResponseEntity.ok(nueva);
    }
}

