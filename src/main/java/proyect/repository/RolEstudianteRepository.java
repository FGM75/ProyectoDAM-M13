package proyect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import proyect.bean.Administrador;

public interface RolEstudianteRepository extends JpaRepository< Administrador, Long> {

    Optional<Administrador> findByUsername(String username);
}
