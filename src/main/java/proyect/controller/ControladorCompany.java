package proyect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyect.bean.Empresa;
import proyect.repository.EmpresaRepository;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class ControladorCompany {

//    @Autowired
//    private final EmpresaRepository EmpresaRepository;
//
//    public ControladorCompany(EmpresaRepository EmpresaRepository) {
//        this.EmpresaRepository = EmpresaRepository;
//    }
//
//    @GetMapping
//    public List<Empresa> getAllCompanies() {
//        return EmpresaRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Empresa> getEmpresaById(@PathVariable Long id) {
//        return EmpresaRepository.findById(id)
//                .map(Empresa -> ResponseEntity.ok(Empresa))
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<Empresa> createEmpresa(@RequestBody Empresa Empresa) {
//        Empresa newEmpresa = EmpresaRepository.save(Empresa);
//        return ResponseEntity.status(HttpStatus.CREATED).body(newEmpresa);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Empresa> updateEmpresa(@PathVariable Long id, @RequestBody Empresa updatedEmpresa) {
//        return EmpresaRepository.findById(id)
//                .map(existingEmpresa -> {
//                    updatedEmpresa.setId(id);
//                    Empresa savedEmpresa = EmpresaRepository.save(updatedEmpresa);
//                    return ResponseEntity.ok(savedEmpresa);
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deleteEmpresa(@PathVariable Long id) {
//        return EmpresaRepository.findById(id)
//                .map(existingEmpresa -> {
//                    EmpresaRepository.deleteById(id);
//                    return ResponseEntity.noContent().build();
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
}
