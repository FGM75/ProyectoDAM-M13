package proyect.service;


import proyect.bean.*;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdministradorService<RepositorioUsuarioAdministrador, UserRegisterDTO> {
    private final PasswordEncoder passwordEncoder;

    public AdministradorService(RepositorioUsuarioAdministrador repository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    public Administrador save(Administrador user2) {
        Administrador user = new Administrador(
                null,
                user2.getUsername(),
                passwordEncoder.encode(user2.getPassword()),
                user2.getCorreoElectronico(),
                List.of(RolUsuario.ROLE_READ, RolUsuario.ROLE_WRITE)
        );
        return this.save(user);
    }
}
