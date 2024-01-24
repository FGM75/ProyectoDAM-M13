package proyect.controller;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import proyect.bean.*;
import proyect.repository.*;
import proyect.controller.*;


import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Controlador", description = "API REST de Empresas y Ofertas con Operaciones CRUD")
public class ControladorAppRest<EmpresaServicio, OfertaServicio> {

    private final EmpresaServicio empresaServicio;
    private final OfertaServicio ofertaServicio;

    public ControladorAppRest(EmpresaServicio empresaServicio, OfertaServicio ofertaServicio) {
        this.empresaServicio = empresaServicio;
        this.ofertaServicio = ofertaServicio;
    }

    // MÉTODOS DE EMPRESA ----------------------------------------------

    @GetMapping("/empresas")
    List<Empresa> buscarTodasLasEmpresas() {
        return empresaServicio.findAll();
    }

    @PostMapping("/empresas")
    Empresa crearNuevaEmpresa(@RequestBody Empresa nuevaEmpresa) {
        return empresaServicio.save(nuevaEmpresa);
    }

    @GetMapping("/empresas/{id}")
    Empresa buscarUnaEmpresa(@PathVariable Long id) {
        return empresaServicio.buscarPorId(id).orElseThrow(() -> new EmpresaNoEncontradaException(id));
    }

    @PutMapping("/empresas/{id}")
    Empresa reemplazarEmpresa(@RequestBody Empresa nuevaEmpresa, @PathVariable Long id) {
        return empresaServicio.reemplazarEmpresa(nuevaEmpresa, id);
    }

    @DeleteMapping("/empresas/{id}")
    void eliminarEmpresa(@PathVariable Long id) {
        empresaServicio.eliminarPorId(id);
    }

    // MÉTODOS DE OFERTA ----------------------------------------------

    @GetMapping("/ofertas")
    List<Oferta> buscarTodasLasOfertas() {
        return ofertaServicio.buscarTodasLasOfertas();
    }

    @GetMapping("/ofertas/{id}")
    Oferta buscarUnaOferta(@PathVariable Long id) {
        return ofertaServicio.buscarPorId(id).orElseThrow(() -> new OfertaNoEncontradaException(id));
    }

    @GetMapping(value = "empresas/{id}/ofertas")
    List<Oferta> buscarTodasLasOfertasPorEmpresa(@PathVariable("id") Long id) {
        return ofertaServicio.buscarOfertasPorIdEmpresa(id);
    }

    @GetMapping(value = "empresas/{idEmp}/ofertas/{idOf}")
    Optional<Oferta> buscarUnaOfertaPorEmpresa(@PathVariable("idEmp") Long idEmp, @PathVariable("idOf") Long idOf) {
        return ofertaServicio.buscarOfertaPorEmpresa(idEmp, idOf);
    }

    @PostMapping(value = "empresas/{id}/ofertas")
    public ResponseEntity<Oferta> crearOfertaParaEmpresa(@RequestBody Oferta oferta, @PathVariable("id") Long id) {
        return ofertaServicio.crearOfertaParaEmpresa(oferta, id);
    }

    @PutMapping("/ofertas/{id}")
    Oferta reemplazarOferta(@RequestBody Oferta nuevaOferta, @PathVariable Long id) {
        return ofertaServicio.actualizarOferta(id, nuevaOferta);
    }

    @DeleteMapping("empresas/{idEmp}/ofertas/{idOf}")
    public void eliminarOferta(@PathVariable Long idEmp, @PathVariable Long idOf) {
        ofertaServicio.eliminarOferta(idEmp, idOf);
    }
}
