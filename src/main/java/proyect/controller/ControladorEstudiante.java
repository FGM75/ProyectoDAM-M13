package proyect.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import proyect.*;

import proyect.repository.*;
import proyect.controller.*;

@RestController
@RequestMapping("/estudiantes")
public class ControladorEstudiante<UserStudentService, OfferService> {

    private final UserStudentService servicioEstudiante;
    private final OfferService servicioOferta;

    public ControladorEstudiante(UserStudentService servicioEstudiante, OfferService servicioOferta) {
        this.servicioEstudiante = servicioEstudiante;
        this.servicioOferta = servicioOferta;
    }

    @GetMapping("/ofertas")
    List<Oferta> consultarTodasOfertasEstudiante() {
        Authentication autenticacion = SecurityContextHolder.getContext().getAuthentication();
        String nombreUsuario = autenticacion.getName();
        Optional<RolEstudiante> estudiante = servicioEstudiante.buscarPorNombreUsuario(nombreUsuario);

        return servicioEstudiante.consultarTodasOfertasSeleccionadas(estudiante);
    }

    @PostMapping("/ofertas/inscribir")
    public ResponseEntity<Optional<Oferta>> inscribirEstudianteEnOferta(@RequestParam Long idOferta) {
        Authentication autenticacion = SecurityContextHolder.getContext().getAuthentication();
        String nombreUsuario = autenticacion.getName();

        Optional<RolEstudiante> estudiante = servicioEstudiante.buscarPorNombreUsuario(nombreUsuario);
        Optional<Oferta> oferta = servicioOferta.consultarPorId(idOferta);

        if (estudiante.isPresent() && oferta.isPresent()) {
            servicioEstudiante.inscribirEstudianteEnOferta(estudiante, idOferta);
            return ResponseEntity.ok(oferta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
