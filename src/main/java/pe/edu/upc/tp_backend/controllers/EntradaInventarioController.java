package pe.edu.upc.tp_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tp_backend.entities.EntradaInventario;
import pe.edu.upc.tp_backend.servicesinterfaces.IEntradaInventarioService;

import java.util.List;

@RestController
@RequestMapping("/entradas")
@CrossOrigin(origins = "*")
public class EntradaInventarioController {

    @Autowired
    private IEntradaInventarioService entradaService;

    @PostMapping("/insertar")
    public ResponseEntity<?> insertar(@RequestBody EntradaInventario entrada) {
        try {
            return ResponseEntity.ok(entradaService.insertar(entrada));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/inventario/{id}")
    public ResponseEntity<List<EntradaInventario>> listarPorInventario(@PathVariable int id) {
        return ResponseEntity.ok(entradaService.listarPorInventario(id));
    }

    @GetMapping("/empresa/{idEmpresa}")
    public ResponseEntity<List<EntradaInventario>> listarPorEmpresa(@PathVariable int idEmpresa) {
        return ResponseEntity.ok(entradaService.listarPorEmpresa(idEmpresa));
    }
}