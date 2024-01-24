package proyect.seguridad;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import proyect.bean.*;
import proyect.repository.*;
import proyect.service.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiantes")
public class ControladorEstudiante {

    private final RolEstudiante RolEstudiante;
    private final ServicioOferta servicioOferta;

    public ControladorEstudiante(RolEstudiante RolEstudiante, ServicioOferta servicioOferta) {
        this.RolEstudiante = RolEstudiante;
        this.servicioOferta = servicioOferta;
    }

    @GetMapping("/ofertas")
    List<Oferta> consultarTodasOfertasEstudiante() {
        Authentication autenticacion = SecurityContextHolder.getContext().getAuthentication();
        String nombreUsuario = autenticacion.getName();
        Optional<RolEstudiante> estudiante = RolEstudiante.buscarPorNombreUsuario(nombreUsuario);

        return RolEstudiante.consultarTodasOfertasSeleccionadas(estudiante);
    }

    @PostMapping("/ofertas/inscribir")
    public ResponseEntity<Optional<Oferta>> inscribirEstudianteEnOferta(@RequestParam Long idOferta) {
        Authentication autenticacion = SecurityContextHolder.getContext().getAuthentication();
        String nombreUsuario = autenticacion.getName();

        Optional<RolEstudiante> estudiante = RolEstudiante.buscarPorNombreUsuario(nombreUsuario);
        Optional<Oferta> oferta = servicioOferta.consultarPorId(idOferta);

        if (estudiante.isPresent() && oferta.isPresent()) {
            RolEstudiante.inscribirEstudianteEnOferta(estudiante, idOferta);
            return ResponseEntity.ok(oferta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
