package pe.edu.upc.tp_backend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tp_backend.dtos.RolDTO;
import pe.edu.upc.tp_backend.entities.Rol;
import pe.edu.upc.tp_backend.servicesinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")

public class RolController {

    @Autowired
    private IRolService rolS;

    @GetMapping("/listar")
    public List<RolDTO> listar() {
        return rolS.list().stream().map(r -> {
            ModelMapper m = new ModelMapper();
            return m.map(r, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        rolS.insert(m.map(dto, Rol.class));
    }

    @GetMapping("/{id}")
    public RolDTO buscarId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        return m.map(rolS.listId(id), RolDTO.class);
    }

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        rolS.update(m.map(dto, Rol.class));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        rolS.delete(id);
    }
}