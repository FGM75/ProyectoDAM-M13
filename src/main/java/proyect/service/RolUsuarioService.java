package proyect.service;

import cat.iticbcn.demo.Exception.CompanyNotFoundException;
import cat.iticbcn.demo.bean.Oferta;
import cat.iticbcn.demo.bean.UserAuthority;
import cat.iticbcn.demo.bean.RolEstudiante;
import cat.iticbcn.demo.dto.UserRegisterDTO;
import cat.iticbcn.demo.repository.RolEstudianteRepository;

import proyect.exepciones.*;
import proyect.bean.*;
import proyect.repository.*;
import proyect.tranferDatos.*;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RolUsuarioService<RolEstudianteRepository, OfertaService> {

    private final RolEstudianteRepository repository;
    private final OfertaService OfertaService;
    private final PasswordEncoder passwordEncoder;

    public RolUsuarioService(RolEstudianteRepository repository, OfertaService OfertaService, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.OfertaService = OfertaService;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Oferta> findAllSelectedOfertas(Optional<RolEstudiante> RolEstudiante) {
        return RolEstudiante.map(RolEstudiante::getOfertas).orElseThrow(() -> new CompanyNotFoundException(1L));
    }

    public Optional<RolEstudiante> findByUsername(String username) {
        return this.repository.findByUsername(username);
    }

    public RolEstudiante save(UserRegisterDTO userDTO) {
        RolEstudiante user = new RolEstudiante(
                null,
                userDTO.username(),
                passwordEncoder.encode(userDTO.password()),
                userDTO.email(),
                List.of(UserAuthority.READ),
                Collections.emptyList()
        );
        return this.repository.save(user);
    }

    public Optional<Oferta> enrollStudentInOferta(Optional<RolEstudiante> studentOptional, Long OfertaId) {
        Optional<Oferta> optionalOferta = OfertaService.findById(OfertaId);
        if (optionalOferta.isPresent()) {
            RolEstudiante student = studentOptional.get();
            Oferta Oferta = optionalOferta.get();

            if (!student.getOfertas().contains(Oferta)) {
                student.getOfertas().add(Oferta);
                repository.save(student);
            }
        }
        return optionalOferta;
    }
}
