package proyect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proyect.bean.RolUsuario;

@Repository
	public interface AdministradorRepository extends JpaRepository<RolUsuario, Long> {
	    Optional<RolUsuario> findByUsername(String username);
	    
}
