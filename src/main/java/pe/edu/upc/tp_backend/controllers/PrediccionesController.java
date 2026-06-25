package pe.edu.upc.tp_backend.controllers;
import org.springframework.data.domain.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.tp_backend.dtos.PrediccionInsertarDTO;

import pe.edu.upc.tp_backend.entities.Predicciones;
import pe.edu.upc.tp_backend.servicesinterfaces.IPrediccionesService;

import java.util.List;

@RestController
@RequestMapping("/predicciones")

public class PrediccionesController {

    @Autowired
    private IPrediccionesService prediccionService;

    // POST /predicciones/insertar
    @PostMapping("/insertar")
    public ResponseEntity<Predicciones> insertar(
            @RequestBody PrediccionInsertarDTO dto) {
        return ResponseEntity.ok(prediccionService.insertar(dto));
    }

    // GET /predicciones/empresa/{id}
    @GetMapping("/empresa/{idEmpresa}")
    public ResponseEntity<List<Predicciones>> getByEmpresa(
            @PathVariable int idEmpresa) {
        return ResponseEntity.ok(prediccionService.getByEmpresa(idEmpresa));
    }

    // GET /predicciones/empresa/{id}/recientes
    @GetMapping("/empresa/{idEmpresa}/recientes")
    public ResponseEntity<List<Predicciones>> getUltimas5(
            @PathVariable int idEmpresa) {
        return ResponseEntity.ok(prediccionService.getUltimas5(idEmpresa));
    }

    // GET /predicciones/empresa/{id}/pagina?page=0&size=10
    @GetMapping("/empresa/{idEmpresa}/pagina")
    public ResponseEntity<Page<Predicciones>> getPaginado(
            @PathVariable int idEmpresa,
            @RequestParam(defaultValue = "0")  int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(
                prediccionService.getByEmpresaPaginado(idEmpresa, page, size));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        prediccionService.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
