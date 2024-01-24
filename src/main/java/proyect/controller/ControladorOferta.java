package proyect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyect.bean.*;
import proyect.repository.OfertaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ofertas")
public class ControladorOferta {
//
//    @Autowired
//    private final OfertaRepository ofertaRepository;
//
//    public ControladorOferta(OfertaRepository ofertaRepository) {
//        this.ofertaRepository = ofertaRepository;
//    }
//
//    @GetMapping
//    public List<Oferta> obtenerTodasLasOfertas() {
//        return ofertaRepository.findAll();
//    }
//
//    @PostMapping
//    public ResponseEntity<Oferta> crearOferta(@RequestBody Oferta oferta) {
//        Oferta nuevaOferta = ofertaRepository.save(oferta);
//        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaOferta);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Oferta> obtenerOfertaPorId(@PathVariable Long id) {
//        Optional<Oferta> oferta = ofertaRepository.findById(id);
//        return oferta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Oferta> actualizarOferta(@PathVariable Long id, @RequestBody Oferta ofertaActualizada) {
//        return ofertaRepository.findById(id)
//                .map(ofertaExistente -> {
//                    ofertaActualizada.setId(id);
//                    Oferta ofertaGuardada = ofertaRepository.save(ofertaActualizada);
//                    return ResponseEntity.ok(ofertaGuardada);
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> eliminarOferta(@PathVariable Long id) {
//        return ofertaRepository.findById(id)
//                .map(ofertaExistente -> {
//                    ofertaRepository.deleteById(id);
//                    return ResponseEntity.noContent().build();
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
}
