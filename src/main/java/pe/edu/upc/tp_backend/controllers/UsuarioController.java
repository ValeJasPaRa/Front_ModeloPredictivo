package pe.edu.upc.tp_backend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tp_backend.dtos.UserMostrarDTO;
import pe.edu.upc.tp_backend.dtos.UserxNombreDTO;
import pe.edu.upc.tp_backend.dtos.UsuarioDTO;
import pe.edu.upc.tp_backend.dtos.UsuarioPerfilDTO;
import pe.edu.upc.tp_backend.entities.Usuario;
import pe.edu.upc.tp_backend.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioS;

    @GetMapping("/listar")
    public List<UserMostrarDTO> listar() {
        return usuarioS.list().stream().map(u -> {
            ModelMapper m = new ModelMapper();
            return m.map(u, UserMostrarDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        usuarioS.insert(m.map(dto, Usuario.class));
    }

    @GetMapping("/{id}")
    public UserMostrarDTO buscarId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        return m.map(usuarioS.listId(id), UserMostrarDTO.class);
    }
   //actualizar sin control de cambio de contraseña
   /* @PutMapping("/actualizar")
    public void actualizar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        usuarioS.update(m.map(dto, Usuario.class));
    }  */

    //con control de cambio o no de contraseña, si no cambia se mantiene la
    //anterior contraseña
    @PutMapping("/actualizar")
    public void actualizar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();

        // Configuración para objetos anidados
        m.getConfiguration().setAmbiguityIgnored(true);

        Usuario usuario = m.map(dto, Usuario.class);
        usuarioS.update(usuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id) {
        usuarioS.delete(id);
    }

    @GetMapping("/buscaruserxname")
    public List<UserxNombreDTO> BuscarUsuarioporNombre(@RequestParam String nombre) {
        return usuarioS.BuscarUsuarioxNombre(nombre).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, UserxNombreDTO.class);
        }).collect(Collectors.toList());
    }

    // GET /usuarios/perfil/{username}
    // Requiere JWT — el usuario ya debe estar autenticado
    @GetMapping("/perfil/{username}")
    public ResponseEntity<UsuarioPerfilDTO> obtenerPerfil(
            @PathVariable String username) {
        return ResponseEntity.ok(usuarioS.obtenerPerfil(username));
    }

    // GET /usuarios/empresa/{idEmpresa}
    @GetMapping("/empresa/{idEmpresa}")
    public ResponseEntity<List<UsuarioPerfilDTO>> listarPorEmpresa(
            @PathVariable int idEmpresa) {
        return ResponseEntity.ok(usuarioS.listarPorEmpresa(idEmpresa));
    }
}