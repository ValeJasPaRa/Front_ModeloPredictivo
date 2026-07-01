package pe.edu.upc.tp_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upc.tp_backend.dtos.Ventas_HistoricasDTO;
import pe.edu.upc.tp_backend.entities.Archivos_Excel;
import pe.edu.upc.tp_backend.entities.Empresas;
import pe.edu.upc.tp_backend.entities.Usuario;
import pe.edu.upc.tp_backend.entities.Ventas_Historicas;
import pe.edu.upc.tp_backend.repositories.IArchivos_ExcelRepository;
import pe.edu.upc.tp_backend.repositories.IEmpresaRepository;
import pe.edu.upc.tp_backend.repositories.IUsuarioRepository;
import pe.edu.upc.tp_backend.repositories.IVentas_HistoricasRepository;
import pe.edu.upc.tp_backend.servicesinterfaces.IIVentas_HistoricasService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/ventas-historicas")
public class Ventas_HistoricasController {

    @Autowired
    private IIVentas_HistoricasService ventasService;

    // Necesitamos estos repos directamente para el upload
    @Autowired
    private IArchivos_ExcelRepository archivoRepo;

    @Autowired
    private IEmpresaRepository empresaRepo;

    @Autowired
    private IUsuarioRepository usuarioRepo;


    @Autowired
    private IVentas_HistoricasRepository ventasRepo;

    // ── GET /ventas-historicas/empresa/{id} ───────────────────────────────
    // Trae CSV activo + MANUAL — usado por dashboard, predicción y reportes
    @GetMapping("/empresa/{idEmpresa}")
    public ResponseEntity<List<Ventas_Historicas>> listar(
            @PathVariable int idEmpresa) {
        return ResponseEntity.ok(
                ventasService.listarPorEmpresa(idEmpresa));
    }

    // ── GET /ventas-historicas/empresa/{id}/todas ─────────────────────────
    // Trae TODAS las ventas sin filtro — para reportes completos
    @GetMapping("/empresa/{idEmpresa}/todas")
    public ResponseEntity<List<Ventas_Historicas>> listarTodas(
            @PathVariable int idEmpresa) {
        return ResponseEntity.ok(
                ventasService.listarTodas(idEmpresa));
    }

    // ── POST /ventas-historicas/insertar ──────────────────────────────────
    // Inserta una venta manual desde Streamlit
    // fuente="MANUAL", stock_final calculado automáticamente
    @PostMapping("/insertar")
    public ResponseEntity<Ventas_Historicas> insertar(
            @RequestBody Ventas_HistoricasDTO dto) {
        return ResponseEntity.ok(ventasService.insertar(dto));
    }

    // ── POST /ventas-historicas/upload ────────────────────────────────────
    // Sube un CSV masivo de ventas
    // Desactiva el CSV anterior y registra el nuevo en Archivos_Excel
    // Columnas del CSV (en orden):
    // fecha, producto, categoria, cantidad_vendida, precio_unitario,
    // costo_unitario, canal_venta, tipo_cliente, region_venta,
    // tiene_dscto, porcentaje_dscto, es_campain, tipo_campain,
    // stock_inicial_periodo
    @PostMapping("/upload")
    public ResponseEntity<String> upload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("empresa_id") int empresaId,
            @RequestParam("usuario_id") int usuarioId) {
        try {
            // ── Paso 1: Desactivar CSV anterior de esta empresa ───────────
            Archivos_Excel csvAnterior =
                    archivoRepo.findByEmpresaActivo(empresaId);
            if (csvAnterior != null) {
                // No borramos — solo marcamos como inactivo
                // Las ventas del CSV anterior siguen en la BD
                // pero no se usan en predicción ni dashboard
                csvAnterior.setEs_activo_predic_archivo(false);
                archivoRepo.save(csvAnterior);
            }

            // ── Paso 2: Registrar el nuevo archivo en Archivos_Excel ──────
            Archivos_Excel nuevoArchivo = new Archivos_Excel();
            nuevoArchivo.setStorage_url_archivoxls(
                    file.getOriginalFilename());
            nuevoArchivo.setVersion_archivoxls(
                    csvAnterior != null
                            ? csvAnterior.getVersion_archivoxls() + 1 : 1);
            nuevoArchivo.setEs_activo_predic_archivo(true);
            nuevoArchivo.setEstado_archivoxls("procesado");
            nuevoArchivo.setIdEmpresa(
                    empresaRepo.findById(empresaId).orElseThrow());
            nuevoArchivo.setId_usuario(
                    usuarioRepo.findById(usuarioId).orElseThrow());
            Archivos_Excel archivoGuardado =
                    archivoRepo.save(nuevoArchivo);

            // ── Paso 3: Leer el CSV línea por línea y guardar ─────────────
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(file.getInputStream()));
            String linea;
            boolean esPrimeraLinea = true;
            int filasGuardadas = 0;

            Empresas empresa =
                    empresaRepo.findById(empresaId).orElseThrow();
            Usuario usuario  =
                    usuarioRepo.findById(usuarioId).orElseThrow();

            while ((linea = reader.readLine()) != null) {
                // Saltamos la primera línea (headers del CSV)
                if (esPrimeraLinea) {
                    esPrimeraLinea = false;
                    continue;
                }

                // Ignoramos líneas vacías
                if (linea.trim().isEmpty()) continue;

                String[] cols = linea.split(",");
                if (cols.length < 14) continue; // línea incompleta

                Ventas_Historicas v = new Ventas_Historicas();

                // Mapeamos columnas en el orden del CSV
                // [0] fecha  [1] producto  [2] categoria
                // [3] cantidad_vendida  [4] precio_unitario
                // [5] costo_unitario  [6] canal_venta
                // [7] tipo_cliente  [8] region_venta
                // [9] tiene_dscto  [10] porcentaje_dscto
                // [11] es_campain  [12] tipo_campain
                // [13] stock_inicial_periodo
                //v.setFecha(LocalDate.parse(cols[0].trim()));
                String fechaStr = cols[0].trim();
                LocalDate fechaParsed;
                if (fechaStr.contains("/")) {
                    // Formato DD/MM/YYYY (típico de Excel en español)
                    DateTimeFormatter formatoDDMMYYYY = DateTimeFormatter.ofPattern("d/M/yyyy");
                    fechaParsed = LocalDate.parse(fechaStr, formatoDDMMYYYY);
                } else {
                    // Formato ISO YYYY-MM-DD (estándar del sistema)
                    fechaParsed = LocalDate.parse(fechaStr);
                }
                v.setFecha(fechaParsed);
                v.setProducto(cols[1].trim());
                v.setCategoria(cols[2].trim());
                v.setCantidad_vendida(
                        Integer.parseInt(cols[3].trim()));
                float precioUnitario = Float.parseFloat(cols[4].trim());
                boolean tieneDscto    = Boolean.parseBoolean(cols[9].trim());
                float porcentajeDscto = Float.parseFloat(cols[10].trim());

                float precioFinal = (tieneDscto && porcentajeDscto > 0)
                        ? precioUnitario * (1 - porcentajeDscto / 100f)
                        : precioUnitario;

                v.setPrecio_unitario(precioUnitario);
                v.setPrecio_final_venta(precioFinal);
                v.setCosto_unitario(
                        Float.parseFloat(cols[5].trim()));
                v.setCanal_venta(cols[6].trim());
                v.setTipo_cliente(cols[7].trim());
                v.setRegion_venta(cols[8].trim());
                v.setModalidad_pago("Efectivo"); // default en CSV
                v.setTiene_dscto(tieneDscto);
                v.setPorcentaje_dscto(porcentajeDscto);
                v.setEs_campain(
                        Boolean.parseBoolean(cols[11].trim()));
                v.setTipo_campain(cols[12].trim());
                v.setStock_inicial_periodo(
                        Integer.parseInt(cols[13].trim()));

                // Stock final calculado automáticamente
                int stockFinal = Integer.parseInt(cols[13].trim())
                        - Integer.parseInt(cols[3].trim());
                v.setStock_final_periodo(Math.max(0, stockFinal));

                // Campos automáticos — el usuario no los llena
                v.setFuente("CSV");
                v.setIdEmpresa(empresa);
                v.setId_usuario(usuario);
                v.setId_archivoxls(archivoGuardado);

                ventasRepo.save(v);
                filasGuardadas++;
            }

            return ResponseEntity.ok(
                    "CSV procesado: " + filasGuardadas + " registros guardados.");

        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body("Error procesando CSV: " + e.getMessage());
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        ventasService.eliminar(id);
        return ResponseEntity.ok().build();
    }
}


