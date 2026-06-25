package pe.edu.upc.tp_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tp_backend.entities.Inventario;
import pe.edu.upc.tp_backend.servicesinterfaces.IInventarioService;

import java.util.List;

@RestController
@RequestMapping("/inventario")
@CrossOrigin(origins = "*")
public class InventarioController {

    @Autowired
    private IInventarioService inventarioService;

   /* @GetMapping("/empresa/{idEmpresa}")
    public ResponseEntity<List<Inventario>> listar(
            @PathVariable int idEmpresa) {
        return ResponseEntity.ok(
                inventarioService.listarPorEmpresa(idEmpresa));
    }*/

    @GetMapping("/empresa/{idEmpresa}")
    public ResponseEntity<List<Inventario>> listar(
            @PathVariable int idEmpresa,
            @RequestParam(required = false, defaultValue = "false") boolean incluirInactivos) {
        return ResponseEntity.ok(
                inventarioService.listarPorEmpresa(idEmpresa, incluirInactivos));
    }

    @PostMapping("/insertar")
    public ResponseEntity<Inventario> insertar(
            @RequestBody Inventario inv) {
        return ResponseEntity.ok(
                inventarioService.insertar(inv));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Inventario> actualizar(
            @PathVariable int id,
            @RequestBody Inventario inv) {
        return ResponseEntity.ok(
                inventarioService.actualizar(id, inv));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable int id) {
        inventarioService.eliminar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/descontar/{id}")
    public ResponseEntity<?> descontar(
            @PathVariable int id,
            @RequestParam int cantidad) {
        try {
            Inventario actualizado = inventarioService.descontarStock(id, cantidad);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/aumentar/{id}")
    public ResponseEntity<?> aumentar(
            @PathVariable int id,
            @RequestParam int cantidad) {
        try {
            Inventario actualizado = inventarioService.aumentarStock(id, cantidad);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/reactivar/{id}")
    public ResponseEntity<?> reactivar(@PathVariable int id) {
        try {
            Inventario reactivado = inventarioService.reactivar(id);
            return ResponseEntity.ok(reactivado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}